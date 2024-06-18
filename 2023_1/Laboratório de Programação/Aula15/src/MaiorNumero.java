public class MaiorNumero {
    public static void main(String[] args) {
        // Declaração e inicialização do array "valores"
        int[] valores = {23, 1, 34, 89, 2};

        // Variável para armazenar o maior número
        int maiorNumero = valores[0];

        // Percorre o array para encontrar o maior número
        for (int i = 1; i < valores.length; i++) {
            if (valores[i] > maiorNumero) {
                maiorNumero = valores[i];
            }
        }

        // Imprime o maior número encontrado
        System.out.println("O maior número é: " + maiorNumero);
    }
}
