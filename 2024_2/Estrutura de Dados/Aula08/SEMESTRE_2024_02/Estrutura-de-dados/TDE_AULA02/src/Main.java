public class Main {
    public static void main(String[] args) {
        // Criando um professor
        Professor professor = new Professor("Carlos Silva", "carlos.silva@escola.com");

        // Criando alunos
        Aluno aluno1 = new Aluno("Ana Pereira", "ana.pereira@escola.com");
        Aluno aluno2 = new Aluno("João Souza", "joao.souza@escola.com");

        // Criando uma turma e adicionando o professor
        Turma turma = new Turma(1, "Matemática", professor);

        // Inserindo alunos na turma
        turma.inserirAluno(aluno1);
        turma.inserirAluno(aluno2);

        // Listando os alunos matriculados na turma
        turma.listarAlunos();

        // Testando o método logar
        professor.logar();
        aluno1.logar();
        aluno2.logar();
    }
}
