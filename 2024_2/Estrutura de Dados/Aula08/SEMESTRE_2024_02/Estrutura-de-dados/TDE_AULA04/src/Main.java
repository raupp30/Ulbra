//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {

        class SortingAlgorithms {


            public void bubbleSortAsc(int[] array) {
                int n = array.length;
                for (int i = 0; i < n - 1; i++) {
                    for (int j = 0; j < n - i - 1; j++) {
                        if (array[j] > array[j + 1]) {
                            // Troca os elementos
                            int temp = array[j];
                            array[j] = array[j + 1];
                            array[j + 1] = temp;
                        }
                    }
                }
            }


            public void bubbleSortDesc(int[] array) {
                int n = array.length;
                for (int i = 0; i < n - 1; i++) {
                    for (int j = 0; j < n - i - 1; j++) {
                        if (array[j] < array[j + 1]) {
                            // Troca os elementos
                            int temp = array[j];
                            array[j] = array[j + 1];
                            array[j + 1] = temp;
                        }
                    }
                }
            }

            // Método Selection Sort - Ordem Crescente
            public void selectionSortAsc(int[] array) {
                int n = array.length;
                for (int i = 0; i < n - 1; i++) {
                    int minIdx = i;
                    for (int j = i + 1; j < n; j++) {
                        if (array[j] < array[minIdx]) {
                            minIdx = j;
                        }
                    }
                    // Troca o menor elemento encontrado com o primeiro elemento
                    int temp = array[minIdx];
                    array[minIdx] = array[i];
                    array[i] = temp;
                }
            }

            // Método Selection Sort - Ordem Decrescente
            public void selectionSortDesc(int[] array) {
                int n = array.length;
                for (int i = 0; i < n - 1; i++) {
                    int maxIdx = i;
                    for (int j = i + 1; j < n; j++) {
                        if (array[j] > array[maxIdx]) {
                            maxIdx = j;
                        }
                    }
                    // Troca o maior elemento encontrado com o primeiro elemento
                    int temp = array[maxIdx];
                    array[maxIdx] = array[i];
                    array[i] = temp;
                }
            }

            // Método Insertion Sort - Ordem Crescente
            public void insertionSortAsc(int[] array) {
                int n = array.length;
                for (int i = 1; i < n; i++) {
                    int key = array[i];
                    int j = i - 1;
                    while (j >= 0 && array[j] > key) {
                        array[j + 1] = array[j];
                        j = j - 1;
                    }
                    array[j + 1] = key;
                }
            }

            // Método Insertion Sort - Ordem Decrescente
            public void insertionSortDesc(int[] array) {
                int n = array.length;
                for (int i = 1; i < n; i++) {
                    int key = array[i];
                    int j = i - 1;
                    while (j >= 0 && array[j] < key) {
                        array[j + 1] = array[j];
                        j = j - 1;
                    }
                    array[j + 1] = key;
                }
            }

            // Método principal para testar os algoritmos
            public static void main(String[] args) {
                SortingAlgorithms sorter = new SortingAlgorithms();
                int[] array = {64, 25, 12, 22, 11};

                System.out.println("Original: " + Arrays.toString(array));

                sorter.bubbleSortAsc(array);
                System.out.println("Bubble Sort Asc: " + Arrays.toString(array));

                sorter.bubbleSortDesc(array);
                System.out.println("Bubble Sort Desc: " + Arrays.toString(array));

                sorter.selectionSortAsc(array);
                System.out.println("Selection Sort Asc: " + Arrays.toString(array));

                sorter.selectionSortDesc(array);
                System.out.println("Selection Sort Desc: " + Arrays.toString(array));

                sorter.insertionSortAsc(array);
                System.out.println("Insertion Sort Asc: " + Arrays.toString(array));

                sorter.insertionSortDesc(array);
                System.out.println("Insertion Sort Desc: " + Arrays.toString(array));
            }
        }


    }
    }
