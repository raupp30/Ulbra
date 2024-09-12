import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
    Aluno[] alunos ={
            new Aluno("Joao", 8, 6),
            new Aluno("Pedro", 4, 2),
            new Aluno("Vitor", 1, 3),
            new Aluno("Andres", 10, 8),
    };

        InsertionAluno.insertionSortPorMedia(alunos);
        System.out.println("Alunos em ordem crescente de media");
        for (Aluno aluno : alunos){
            System.out.println(aluno);
        }

        Aluno[] aprovados = Arrays.stream(alunos)
                .filter(Aluno::isAprovado)
                .toArray(Aluno[]::new);
        InsertionAluno.insertionSortPorNome(aprovados);
        System.out.println("------------------------------------");
        System.out.println("Alunos aprovados em ordem alfabeticq");
        for (Aluno aluno : aprovados){
            System.out.println(aluno);
        }

        Aluno[] reprovados = Arrays.stream(alunos)
                .filter(aluno -> !aluno.isAprovado())
                .toArray(Aluno[]::new);
        InsertionAluno.insertionSortPorNome(reprovados);
        System.out.println("------------------------------------");
        System.out.println("Alunos reprovados em ordem alfabeticq");
        for (Aluno aluno : reprovados){
            System.out.println(aluno);
    }
}
}