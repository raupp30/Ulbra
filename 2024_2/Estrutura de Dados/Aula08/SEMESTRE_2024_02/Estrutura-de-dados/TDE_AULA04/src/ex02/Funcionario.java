package ex02;


import java.util.Arrays;
import java.util.Comparator;

class Funcionario {
    String nome;
    double salario;

    Funcionario(String nome, double salario) {
        this.nome = nome;
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Salário: R$ " + salario;
    }
}

 class cadastroFuncionarios {

    public static void main(String[] args) {
        Funcionario[] funcionarios = new Funcionario[5];

        // Cadastro dos funcionários
        funcionarios[0] = new Funcionario("Ana", 4500);
        funcionarios[1] = new Funcionario("Carlos", 3200);
        funcionarios[2] = new Funcionario("Beatriz", 5500);
        funcionarios[3] = new Funcionario("Eduardo", 3000);
        funcionarios[4] = new Funcionario("Fernando", 4800);

        // Ordenação e exibição dos dados
        System.out.println("Ordem Crescente de Salário:");
        ordenarPorSalario(funcionarios, true);
        exibirFuncionarios(funcionarios);

        System.out.println("\nOrdem Decrescente de Salário:");
        ordenarPorSalario(funcionarios, false);
        exibirFuncionarios(funcionarios);

        System.out.println("\nOrdem Alfabética:");
        ordenarPorNome(funcionarios);
        exibirFuncionarios(funcionarios);
    }

    // Ordena os funcionários por salário (crescente ou decrescente)
    public static void ordenarPorSalario(Funcionario[] funcionarios, boolean crescente) {
        for (int i = 1; i < funcionarios.length; i++) {
            Funcionario chave = funcionarios[i];
            int j = i - 1;

            while (j >= 0 && (crescente ? funcionarios[j].salario > chave.salario : funcionarios[j].salario < chave.salario)) {
                funcionarios[j + 1] = funcionarios[j];
                j = j - 1;
            }
            funcionarios[j + 1] = chave;
        }
    }

    // Ordena os funcionários por nome em ordem alfabética
    public static void ordenarPorNome(Funcionario[] funcionarios) {
        Arrays.sort(funcionarios, Comparator.comparing(func -> func.nome));
    }

    // Exibe os dados dos funcionários
    public static void exibirFuncionarios(Funcionario[] funcionarios) {
        for (Funcionario func : funcionarios) {
            System.out.println(func);
        }
    }
}
