public class Main {
    public static void main(String[] args) {
        int[] tamanhos = {100, 10000, 100000};
        String[] metodos = {"bubble", "selection", "insertion", "merge", "quick"};

        for (int tamanho : tamanhos) {
            System.out.printf("Testando com array de tamanho %d%n", tamanho);

            int[] arrayOrdenado = SortingAnalysis.gerarArrayOrdenado(tamanho);
            int[] arrayInverso = SortingAnalysis.gerarArrayInverso(tamanho);
            int[] arrayAleatorio = SortingAnalysis.gerarArrayAleatorio(tamanho);

            for (String metodo : metodos) {
                System.out.println("Array Ordenado:");
                SortingAnalysis.analisar(arrayOrdenado, metodo);

                System.out.println("Array Inversamente Ordenado:");
                SortingAnalysis.analisar(arrayInverso, metodo);

                System.out.println("Array Aleatório:");
                SortingAnalysis.analisar(arrayAleatorio, metodo);
                System.out.println();
            }
        }
    }
}
