import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Matriz matriz = new Matriz(4, 4); // criando uma matriz 4x4
        matriz.preencherAleatorio();
        System.out.println("matriz original:");
        matriz.exibirMatriz();

        System.out.println("\nescolha uma opção:");
        System.out.println("1 - ordenar linhas com bubble sort");
        System.out.println("2 - ordenar colunas com bubble sort");
        System.out.println("3 - ordenar linhas com merge sort");
        System.out.println("4 - ordenar colunas com merge sort");
        System.out.println("5 - ordenar matriz completa como vetor com merge sort");

        int opcao = scanner.nextInt();

        switch (opcao) {
            case 1:
                System.out.println("escolha a linha (0-3) para ordenar:");
                int linha = scanner.nextInt();
                matriz.ordenarLinhaBubble(linha);
                System.out.println("matriz após ordenar a linha " + linha + " com bubble sort:");
                matriz.exibirMatriz();
                break;

            case 2:
                System.out.println("escolha a coluna (0-3) para ordenar:");
                int coluna = scanner.nextInt();
                matriz.ordenarColunaBubble(coluna);
                System.out.println("matriz após ordenar a coluna " + coluna + " com bubble sort:");
                matriz.exibirMatriz();
                break;

            case 3:
                System.out.println("escolha a linha (0-3) para ordenar:");
                linha = scanner.nextInt();
                matriz.ordenarLinhaMerge(linha);
                System.out.println("matriz após ordenar a linha " + linha + " com merge sort:");
                matriz.exibirMatriz();
                break;

            case 4:
                System.out.println("escolha a coluna (0-3) para ordenar:");
                coluna = scanner.nextInt();
                matriz.ordenarColunaMerge(coluna);
                System.out.println("matriz após ordenar a coluna " + coluna + " com merge sort:");
                matriz.exibirMatriz();
                break;

            case 5:
                matriz.ordenarMatrizCompleta();
                System.out.println("matriz após ordenar como vetor:");
                matriz.exibirMatriz();
                break;

            default:
                System.out.println("opção inválida");
                break;
        }

        scanner.close();
    }
}