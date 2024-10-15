package ex03;

import java.util.Arrays;
import java.util.Comparator;

class Aluno {
    String nome;
    double nota1;
    double nota2;
    double media;

    Aluno(String nome, double nota1, double nota2) {
        this.nome = nome;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.media = calcularMedia();
    }

    private double calcularMedia() {
        return (nota1 + nota2) / 2;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Nota1: " + nota1 + ", Nota2: " + nota2 + ", Média: " + media;
    }
}

public class CadastroAlunos {

    public static void main(String[] args) {
        Aluno[] alunos = new Aluno[8];

        // Cadastro dos alunos
        alunos[0] = new Aluno("Ana", 8.0, 7.5);
        alunos[1] = new Aluno("Bruno", 5.5, 6.0);
        alunos[2] = new Aluno("Carlos", 7.0, 8.0);
        alunos[3] = new Aluno("Daniela", 9.0, 8.5);
        alunos[4] = new Aluno("Eduardo", 4.5, 5.0);
        alunos[5] = new Aluno("Fernanda", 6.0, 6.5);
        alunos[6] = new Aluno("Gabriel", 7.5, 7.0);
        alunos[7] = new Aluno("Helena", 10.0, 9.5);

        // Ordenação e exibição dos dados
        System.out.println("Ordem Crescente de Nota Média:");
        ordenarPorMedia(alunos);
        exibirAlunos(alunos);

        System.out.println("\nAprovados em Ordem Alfabética:");
        exibirAprovados(alunos);

        System.out.println("\nReprovados em Ordem Alfabética:");
        exibirReprovados(alunos);
    }

    // Ordena os alunos por média (ordem crescente)
    public static void ordenarPorMedia(Aluno[] alunos) {
        int n = alunos.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (alunos[j].media < alunos[minIdx].media) {
                    minIdx = j;
                }
            }
            // Troca o aluno com a menor média com o primeiro aluno
            Aluno temp = alunos[minIdx];
            alunos[minIdx] = alunos[i];
            alunos[i] = temp;
        }
    }

    // Exibe os alunos aprovados em ordem alfabética
    public static void exibirAprovados(Aluno[] alunos) {
        Aluno[] aprovados = Arrays.stream(alunos)
                .filter(aluno -> aluno.media >= 7.0)
                .toArray(Aluno[]::new);

        Arrays.sort(aprovados, Comparator.comparing(aluno -> aluno.nome));

        exibirAlunos(aprovados);
    }

    // Exibe os alunos reprovados em ordem alfabética
    public static void exibirReprovados(Aluno[] alunos) {
        Aluno[] reprovados = Arrays.stream(alunos)
                .filter(aluno -> aluno.media < 7.0)
                .toArray(Aluno[]::new);

        Arrays.sort(reprovados, Comparator.comparing(aluno -> aluno.nome));

        exibirAlunos(reprovados);
    }

    // Exibe os dados dos alunos
    public static void exibirAlunos(Aluno[] alunos) {
        for (Aluno aluno : alunos) {
            System.out.println(aluno);
        }
    }
}
