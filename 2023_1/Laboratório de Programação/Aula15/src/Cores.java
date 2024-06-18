public class Cores {
    public static void main(String[] args) {
        // Declaração e inicialização do array "cores"
        String[] cores = {"vermelho", "azul", "verde", "amarelo", "roxo"};

        // Percorre o array de trás para frente e imprime os elementos
        for (int i = cores.length - 1; i >= 0; i--) {
            System.out.println(cores[i]);
        }
    }
}
