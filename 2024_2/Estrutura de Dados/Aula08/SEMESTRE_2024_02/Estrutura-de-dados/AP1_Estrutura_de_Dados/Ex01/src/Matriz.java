import java.util.Scanner;
import java.util.Random;

public class Matriz {
    private int[][] matriz; // declaração da matriz


    public Matriz(int linhas, int colunas) {
        matriz = new int[linhas][colunas]; // inicializa a matriz com o número de linhas e colunas
    }

    // preenche a matriz manualmente com valores fornecidos pelo usuário
    public void preencherManual() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print("digite um valor p/ posição [" + i + "][" + j + "]: ");
                matriz[i][j] = scanner.nextInt(); // le os valores e insere na matriz
            }
        }
    }

    // preenche a matriz com valores aleatórios de 0 a 99
    public void preencherAleatorio() {
        Random random = new Random();
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = random.nextInt(100); // gera um número aleatório entre 0 a 99
            }
        }
    }

    // insere um elemento em uma posição específica da matriz
    public void inserirElemento(int linha, int coluna, int valor) {
        if (linha >= 0 && linha < matriz.length && coluna >= 0 && coluna < matriz[linha].length) {
            matriz[linha][coluna] = valor; // Insere o valor se a posição for válida
        } else {
            System.out.println("posição invalida"); // Exibe mensagem de erro se a posição for inválida
        }
    }

    // remove um elemento de uma posição específica da matriz (define como 0)
    public void removerElemento(int linha, int coluna) {
        if (linha >= 0 && linha < matriz.length && coluna >= 0 && coluna < matriz[linha].length) {
            matriz[linha][coluna] = 0; // Remove o valor (define como 0) se a posição for válida
        } else {
            System.out.println("posição invalida."); // Exibe mensagem de erro se a posição for inválida
        }
    }

    // exibe a matriz no console
    public void exibirMatriz() {
        for (int[] linha : matriz) {
            for (int valor : linha) {
                System.out.print(valor + " "); // exibe cada valor com um espaço entre eles
            }
            System.out.println(); // pula para a próxima linha após exibir uma linha completa da matriz
        }
    }
}