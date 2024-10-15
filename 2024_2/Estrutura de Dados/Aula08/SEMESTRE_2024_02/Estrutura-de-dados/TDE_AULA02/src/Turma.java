import java.util.ArrayList;
import java.util.List;

public class Turma {
    private int id;
    private String nome;
    private Professor professor;
    private List<Aluno> alunosMatriculados;

    // Construtor
    public Turma(int id, String nome, Professor professor) {
        this.id = id;
        this.nome = nome;
        this.professor = professor;
        this.alunosMatriculados = new ArrayList<>();
    }

    // Método para inserir um aluno na turma
    public void inserirAluno(Aluno aluno) {
        if (aluno != null) {
            alunosMatriculados.add(aluno);
        }
    }

    // Método para listar alunos matriculados na turma
    public void listarAlunos() {
        System.out.println("Alunos matriculados na turma " + nome + ":");
        for (Aluno aluno : alunosMatriculados) {
            System.out.println(aluno.getNome());
        }
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Professor getProfessor() {
        return professor;
    }
}
