import java.util.Arrays;
import java.util.Random;

public class SortingAnalysis {

    static int comparacoes, trocas;


    public static void analisar(int[] array, String metodo) {
        comparacoes = 0;
        trocas = 0;
        int[] copia = Arrays.copyOf(array, array.length);

        long inicio = System.nanoTime();

        switch(metodo) {
            case "bubble":
                bubbleSort(copia);
                break;
            case "selection":
                selectionSort(copia);
                break;
            case "insertion":
                insertionSort(copia);
                break;
            case "merge":
                mergeSort(copia, 0, copia.length - 1);
                break;
            case "quick":
                quickSort(copia, 0, copia.length - 1);
                break;
            default:
                System.out.println("Método de ordenação desconhecido.");
                return;
        }

        long fim = System.nanoTime();
        double tempoSegundos = (fim - inicio) / 1e9;

        System.out.printf("%s Sort - Comparações: %d, Trocas: %d, Tempo: %.5f segundos%n", metodo, comparacoes, trocas, tempoSegundos);
    }


    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        trocas++;
    }


    public static void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                comparacoes++;
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }
    }


    public static void selectionSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                comparacoes++;
                if (array[j] < array[minIdx]) {
                    minIdx = j;
                }
            }
            if (minIdx != i) {
                swap(array, i, minIdx);
            }
        }
    }


    public static void insertionSort(int[] array) {
        int n = array.length;
        for (int i = 1; i < n; i++) {
            int chave = array[i];
            int j = i - 1;
            comparacoes++;
            while (j >= 0 && array[j] > chave) {
                comparacoes++;
                array[j + 1] = array[j];
                j--;
                trocas++;
            }
            array[j + 1] = chave;
        }
    }


    public static void mergeSort(int[] array, int esquerda, int direita) {
        if (esquerda < direita) {
            int meio = (esquerda + direita) / 2;
            mergeSort(array, esquerda, meio);
            mergeSort(array, meio + 1, direita);
            merge(array, esquerda, meio, direita);
        }
    }

    public static void merge(int[] array, int esquerda, int meio, int direita) {
        int n1 = meio - esquerda + 1;
        int n2 = direita - meio;
        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = array[esquerda + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = array[meio + 1 + j];
        }

        int i = 0, j = 0, k = esquerda;
        while (i < n1 && j < n2) {
            comparacoes++;
            if (L[i] <= R[j]) {
                array[k] = L[i];
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

    // Algoritmo Quick Sort
    public static void quickSort(int[] array, int inicio, int fim) {
        if (inicio < fim) {
            int pi = partition(array, inicio, fim);
            quickSort(array, inicio, pi - 1);
            quickSort(array, pi + 1, fim);
        }
    }

    public static int partition(int[] array, int inicio, int fim) {
        int pivo = array[fim];
        int i = (inicio - 1);
        for (int j = inicio; j < fim; j++) {
            comparacoes++;
            if (array[j] <= pivo) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, fim);
        return i + 1;
    }

    // Funções para gerar arrays
    public static int[] gerarArrayOrdenado(int tamanho) {
        int[] array = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            array[i] = i;
        }
        return array;
    }

    public static int[] gerarArrayInverso(int tamanho) {
        int[] array = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            array[i] = tamanho - i;
        }
        return array;
    }

    public static int[] gerarArrayAleatorio(int tamanho) {
        int[] array = new int[tamanho];
        Random random = new Random();
        for (int i = 0; i < tamanho; i++) {
            array[i] = random.nextInt(tamanho);
        }
        return array;
    }
}
