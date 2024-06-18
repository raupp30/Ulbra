public class Impares {
    public static void main(String[] args) {
        // Declaração e inicialização do array "numerosImpares"
        int[] numerosImpares = new int[10];
        int numero = 1;

        // Preenche o array com os primeiros 10 números ímpares
        for (int i = 0; i < numerosImpares.length; i++) {
            numerosImpares[i] = numero;
            numero += 2;
        }

        // Imprime cada número ímpar do array
        for (int i = 0; i < numerosImpares.length; i++) {
            System.out.println(numerosImpares[i]);
        }
    }
}
