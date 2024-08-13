import java.util.prefs.Preferences;

public static void main(String[] args) {
    Pessoa p1 = new Pessoa();
    p1.setNome("Joãozin");
    p1.setNome("joaovraupp@rede.ulbra.br");

    Professor prof = new Professor();
    prof.setNome("Juliano");

    Turma estDados = new Turma("Turma 01", prof, 30);

    Aluno aluno1 = new Aluno();
    aluno1.setNome("Joãozin");
    Aluno aluno2 = new Aluno();
    aluno2.setNome("Vitor");

    System.out.println(estDados.getNome());
    estDados.inserirAluno(aluno1);
    estDados.inserirAluno(aluno2);
    estDados.listarAluno();
}

