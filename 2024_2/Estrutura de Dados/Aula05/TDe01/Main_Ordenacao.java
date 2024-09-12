public class Main_Ordenacao {
    public static void main(String[] args) {
        int[] vetorBubble = {9, 7, 4, 3, 2, 1};
        int[] vetorSelection = {1, 100, 422, 50, 10};
        int[] vetorInsertion = {3, 100, 50, 20, 10};


        Ordenacao.bubbleSort(vetorBubble);
        Ordenacao.selectionSort(vetorSelection);
        Ordenacao.insertionSort(vetorInsertion);
        System.out.println("=======Bubble=========");
        Ordenacao.imprimeVetor(vetorBubble);
        System.out.println("=======Selection=========");
        Ordenacao.imprimeVetor(vetorSelection);
        System.out.println("=======Insertion=========");
        Ordenacao.imprimeVetor(vetorInsertion);
    }
}