from flask import Flask, render_template, request, redirect, url_for, session, flash, jsonify
import pyrebase

app = Flask(__name__)
app.secret_key = '123'

config = {
    "apiKey": "AIzaSyBD7ypZDp5UMJIJ8aSA2yoVdKFP3He3uDA",
    "authDomain": "pds2025-fc352.firebaseapp.com",
    "projectId": "pds2025-fc352",
    "storageBucket": "pds2025-fc352.firebasestorage.app",
    "messagingSenderId": "392600380234",
    "appId": "1:392600380234:web:e4c4cae5beec8f354517b3",
    "measurementId": "G-3H83DY41EQ",
    "databaseURL": 'https://pds2025-fc352-default-rtdb.firebaseio.com/'
}

firebase = pyrebase.initialize_app(config)
auth = firebase.auth()
db = firebase.database()

from flask import Flask

@app.route('/')
def home():
    return render_template('home.html')

@app.route('/terms')
def terms():
    return render_template('terms.html')

@app.route('/painel_fisio')
def painel_fisio():
    return render_template('painel_fisio.html')

@app.route('/painel_paciente')
def painel_paciente():
    return render_template('painel_paciente.html')

@app.route('/logout')
def logout():
    session.pop('email', None)
    return redirect(url_for('home'))

@app.route("/register_fisio", methods=["GET", "POST"])
def register_fisio():
    if request.method == "POST":
        nome = request.form["nome"]
        email = request.form["email"]
        senha = request.form["senha"]

        try:
            # Registro no Firebase Authentication
            user = auth.create_user_with_email_and_password(email, senha)
            uid = user["localId"]

            # Salvando os dados no Realtime Database
            db.child("usuarios").child(uid).set({
                "nome": nome,
                "email": email,
                "tipo": "fisioterapeuta"
            })

            flash("Fisioterapeuta registrado com sucesso!", "success")
            return redirect("/login_fisio")
        except Exception as e:
            flash(f"Erro no registro: {e}", "danger")

    return render_template("register_fisio.html")

@app.route("/login_fisio", methods=["GET", "POST"])
def login_fisio():
    if request.method == "POST":
        email = request.form["email"]
        senha = request.form["senha"]

        try:
            user = auth.sign_in_with_email_and_password(email, senha)
            uid = user["localId"]

            tipo = db.child("usuarios").child(uid).child("tipo").get().val()
            if tipo != "fisioterapeuta":
                flash("Acesso negado: não é um fisioterapeuta.", "danger")
                return redirect("/login_fisio")

            flash("Login realizado com sucesso!", "success")
            return redirect("/painel_fisio")
        except Exception as e:
            flash(f"Erro no login: {e}", "danger")

    return render_template("login_fisio.html")

@app.route("/register_paciente", methods=["GET", "POST"])
def register_paciente():
    if request.method == "POST":
        nome = request.form["nome"]
        email = request.form["email"]
        senha = request.form["senha"]

        try:
            # Registro no Firebase Authentication
            user = auth.create_user_with_email_and_password(email, senha)
            uid = user["localId"]

            # Salvando os dados no Realtime Database
            db.child("usuarios").child(uid).set({
                "nome": nome,
                "email": email,
                "tipo": "paciente"
            })

            flash("Paciente registrado com sucesso!", "success")
            return redirect("/login_paciente")
        except Exception as e:
            flash(f"Erro no registro: {e}", "danger")

    return render_template("register_paciente.html")

@app.route("/login_paciente", methods=["GET", "POST"])
def login_paciente():
    if request.method == "POST":
        email = request.form["email"]
        senha = request.form["senha"]

        try:
            user = auth.sign_in_with_email_and_password(email, senha)
            uid = user["localId"]

            tipo = db.child("usuarios").child(uid).child("tipo").get().val()
            if tipo != "paciente":
                flash("Acesso negado: não é um paciente.", "danger")
                return redirect("/login_paciente")

            flash("Login realizado com sucesso!", "success")
            return redirect("/painel_paciente")
        except Exception as e:
            flash(f"Erro no login: {e}", "danger")

    return render_template("login_paciente.html")

if __name__ == '__main__':
    app.run(debug=True)

