import java.util.Arrays;
import java.util.Scanner;

public class Matriz {
    private int[][] matriz;

    public Matriz(int linhas, int colunas) {
        matriz = new int[linhas][colunas]; // inicializa a matriz com o tamanho especificado
    }

    public void preencherAleatorio() {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = (int) (Math.random() * 100); // preenche com valores aleatórios de 0 a 99
            }
        }
    }

    public void exibirMatriz() {
        for (int[] linha : matriz) {
            for (int valor : linha) {
                System.out.print(valor + " "); // exibe a matriz linha por linha
            }
            System.out.println();
        }
    }

    public void ordenarLinhaBubble(int linha) {
        int n = matriz[linha].length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (matriz[linha][j] > matriz[linha][j + 1]) {
                    int temp = matriz[linha][j];
                    matriz[linha][j] = matriz[linha][j + 1];
                    matriz[linha][j + 1] = temp; // troca os elementos adjacentes se estiverem na ordem errada
                }
            }
        }
    }

    public void ordenarColunaBubble(int coluna) {
        int n = matriz.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (matriz[j][coluna] > matriz[j + 1][coluna]) {
                    int temp = matriz[j][coluna];
                    matriz[j][coluna] = matriz[j + 1][coluna];
                    matriz[j + 1][coluna] = temp; // troca elementos na coluna se necessário
                }
            }
        }
    }

    public void ordenarLinhaMerge(int linha) {
        mergeSort(matriz[linha], 0, matriz[linha].length - 1); // aplica merge sort na linha escolhida
    }

    public void ordenarColunaMerge(int coluna) {
        int[] tempColuna = new int[matriz.length]; // cria uma array temporária para a coluna
        for (int i = 0; i < matriz.length; i++) {
            tempColuna[i] = matriz[i][coluna]; // copia os valores da coluna
        }

        mergeSort(tempColuna, 0, tempColuna.length - 1); // ordena a coluna usando merge sort

        for (int i = 0; i < matriz.length; i++) {
            matriz[i][coluna] = tempColuna[i]; // coloca os valores ordenados de volta na matriz
        }
    }

    private void mergeSort(int[] array, int inicio, int fim) {
        if (inicio < fim) {
            int meio = (inicio + fim) / 2;
            mergeSort(array, inicio, meio);
            mergeSort(array, meio + 1, fim);
            merge(array, inicio, meio, fim); // divide o array ao meio e aplica o merge sort
        }
    }

    private void merge(int[] array, int inicio, int meio, int fim) {
        int n1 = meio - inicio + 1;
        int n2 = fim - meio;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++)
            L[i] = array[inicio + i]; // copia os elementos para o array da esquerda
        for (int j = 0; j < n2; j++)
            R[j] = array[meio + 1 + j]; // copia os elementos para o array da direita

        int i = 0, j = 0;
        int k = inicio;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                array[k] = L[i]; // coloca o menor valor no array original
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = R[j];
            j++;
            k++;
        }
    }

    public void ordenarMatrizCompleta() {
        int[] vetor = new int[matriz.length * matriz[0].length]; // transforma a matriz em um vetor
        int k = 0;
        for (int[] linha : matriz) {
            for (int valor : linha) {
                vetor[k++] = valor; // copia os valores da matriz para o vetor
            }
        }

        mergeSort(vetor, 0, vetor.length - 1); // ordena o vetor inteiro

        k = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = vetor[k++]; // coloca os valores ordenados de volta na matriz
            }
        }
    }
}