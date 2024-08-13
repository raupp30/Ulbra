from flask import Flask, render_template, request, redirect, url_for, session, flash, jsonify
from flask_mysqldb import MySQL
import bcrypt

app = Flask(__name__)
app.secret_key = '123'

# Configurando o MySQL
app.config['MYSQL_HOST'] = 'localhost'
app.config['MYSQL_USER'] = 'root'
app.config['MYSQL_PASSWORD'] = ''
app.config['MYSQL_DB'] = 'db_lsp'
mysql = MySQL(app)

# Listas de categorias
categories = ["Peito", "Costas", "Ombros", "Braços", "Abdômen", "Pernas"]

# Rota principal
@app.route('/')
def index():
    return render_template('login.html')

# Login
@app.route('/login', methods=['GET', 'POST'])
def login():
    if request.method == 'POST':
        email = request.form['email']
        password = request.form['password'].encode('utf-8')

        cur = mysql.connection.cursor()
        cur.execute("SELECT * FROM user WHERE email = %s", (email,))
        user = cur.fetchone()
        cur.close()

        if user:
            if bcrypt.checkpw(password, user[3].encode('utf-8')):
                session['email'] = email
                return redirect(url_for('dashboard'))
            else:
                flash('Senha incorreta', 'error')
                return render_template('login.html')
        else:
            flash('E-mail não registrado', 'error')
            return render_template('login.html')

    return render_template('login.html')

# Perfil
@app.route('/profile', methods=['GET', 'POST'])
def profile():
    if 'email' in session:
        email = session['email']
        cur = mysql.connection.cursor()
        cur.execute("SELECT * FROM user WHERE email = %s", (email,))
        user = cur.fetchone()
        cur.close()

        if user:
            success = False
            if request.method == 'GET':
                # Exibir o formulário de edição de perfil
                return render_template('profile.html', user=user, success=success)
            elif request.method == 'POST':
                # Atualizar os dados do perfil
                name = request.form['name']
                peso = request.form['peso']
                altura = request.form['altura']
                idade = request.form['idade']
                tipo_sanguineo = request.form['tipo_sanguineo']

                cur = mysql.connection.cursor()
                cur.execute("""
                    UPDATE user
                    SET name = %s, peso = %s, altura = %s, idade = %s, tipo_sanguineo = %s
                    WHERE email = %s
                """, (name, peso, altura, idade, tipo_sanguineo, email))
                mysql.connection.commit()
                cur.close()

                # Definir a variável de sucesso como True
                success = True

                # Redirecionar de volta para a página de perfil com a mensagem de sucesso
                return redirect(url_for('profile', success=success))
        else:
            return jsonify({"message": "User not found"}), 404
    else:
        return jsonify({"message": "User not logged in"}), 401

# Registro
@app.route('/register', methods=['GET', 'POST'])
def register():
    if request.method == 'POST':
        name = request.form['text']
        email = request.form['email']
        password = request.form['password'].encode('utf-8')

        terms_accepted = 'terms' in request.form

        if not terms_accepted:
            flash('Você deve aceitar os termos e condições!', 'error')
            return redirect(url_for('register'))

        # Verificar se o e-mail já está registrado
        cur = mysql.connection.cursor()
        cur.execute("SELECT * FROM user WHERE email = %s", (email,))
        existing_user = cur.fetchone()
        
        if existing_user:
            cur.close()
            flash("O e-mail já está registrado", "error")
            return redirect(url_for('register'))

        # Hash da senha
        hashed_password = bcrypt.hashpw(password, bcrypt.gensalt())

        # Inserir o novo usuário
        cur.execute("INSERT INTO user (name, email, password) VALUES (%s, %s, %s)", (name, email, hashed_password))
        mysql.connection.commit()
        cur.close()

        # Definir a sessão do usuário
        session['email'] = email
        return redirect(url_for('dashboard'))

    return render_template('register.html')

# Dashboard
@app.route('/dashboard')
def dashboard():
    if 'email' not in session:
        return redirect(url_for('login'))
    else:
        return render_template('dashboard.html')

# Deslogar
@app.route('/logout')
def logout():
    session.pop('email', None)
    return redirect(url_for('login'))

# Termos
@app.route('/terms')
def terms():
    return render_template('terms.html')

# Rota para criar treinos com categorias
@app.route('/criar_treino', methods=['GET', 'POST'])
def criar_treino():
    if 'email' not in session:
        return redirect(url_for('login'))

    email = session['email']

    if request.method == 'POST':
        selected_trainings = {}
        for category in categories:
            selected_trainings[category] = request.form.getlist(category)

        # Verificar se pelo menos um treino foi selecionado
        if not any(selected_trainings.values()):
            flash('Selecione pelo menos um treino antes de salvar.', 'error')
            return redirect(url_for('criar_treino'))

        # Salvar os treinos selecionados no banco de dados
        cur = mysql.connection.cursor()

        # Excluir os treinos anteriores selecionados pelo usuário
        cur.execute("DELETE FROM user_selected_trainings WHERE user_email = %s", (email,))
        
        # Inserir os novos treinos selecionados
        for category, exercises in selected_trainings.items():
            for exercise in exercises:
                cur.execute("""
                    INSERT INTO user_selected_trainings (user_email, category, exercise_name)
                    VALUES (%s, %s, %s)
                """, (email, category, exercise))

        mysql.connection.commit()
        cur.close()

        return redirect(url_for('treinos_selecionados'))

    # Recuperar os treinos salvos pelo usuário
    cur = mysql.connection.cursor()
    cur.execute("SELECT category, exercise_name FROM user_selected_trainings WHERE user_email = %s", (email,))
    saved_trainings = cur.fetchall()
    cur.close()

    # Organizar os treinos salvos por categoria
    user_trainings = {}
    for category, exercise in saved_trainings:
        if category not in user_trainings:
            user_trainings[category] = []
        user_trainings[category].append(exercise)

    # Carregar informações completas dos treinos do banco de dados
    trainings_info = {}
    for category in categories:
        query = f"SELECT nome, descricao, foto_url FROM treinos_{category.lower()}"
        cur = mysql.connection.cursor()
        cur.execute(query)
        trainings_info[category] = cur.fetchall()
        cur.close()

    return render_template('criar_treino.html', trainings=trainings_info, user_trainings=user_trainings)


# Rota para exibir treinos selecionados pelo usuário
@app.route('/treinos_selecionados')
def treinos_selecionados():
    if 'email' not in session:
        return redirect(url_for('login'))

    email = session['email']

    cur = mysql.connection.cursor()
    cur.execute("SELECT category, exercise_name FROM user_selected_trainings WHERE user_email = %s", (email,))
    saved_trainings = cur.fetchall()
    cur.close()

    # Organizar os treinos por categoria
    selected_trainings = {}
    for category, exercise in saved_trainings:
        if category not in selected_trainings:
            selected_trainings[category] = []
        selected_trainings[category].append(exercise)

    # Recuperar informações completas dos treinos selecionados
    trainings_info = {}
    for category, exercises in selected_trainings.items():
        for exercise in exercises:
            query = f"SELECT descricao, foto_url FROM treinos_{category.lower()} WHERE nome = %s"
            cur = mysql.connection.cursor()
            cur.execute(query, (exercise,))
            info = cur.fetchone()
            if category not in trainings_info:
                trainings_info[category] = []
            trainings_info[category].append({
                'nome': exercise,
                'descricao': info[0],
                'foto_url': info[1]
            })
            cur.close()

    return render_template('treinos_selecionados.html', selected_trainings=trainings_info)

@app.route('/desafios')
def desafios():
    return render_template('desafios.html')

@app.route('/evolucao')
def evolucao():
    return render_template('evolucao.html')

if __name__ == '__main__':
    app.run(debug=True)
