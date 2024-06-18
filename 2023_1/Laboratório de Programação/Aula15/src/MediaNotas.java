public class MediaNotas {
    public static void main(String[] args) {
        // Declaração e inicialização do array "notas"
        double[] notas = {8.5, 7.0, 9.0, 6.5, 10.0};

        // Cálculo da média das notas
        double soma = 0;
        for (double nota : notas) {
            soma += nota;
        }
        double media = soma / notas.length;

        // Impressão da média das notas
        System.out.println("A média das notas é: " + media);
    }
}