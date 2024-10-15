public class Main {
    public static void main(String[] args) {

        // cria uma matriz de 3x3
        Matriz matriz = new Matriz(3, 3);

        // preenche a matriz com valores aleatórios e a exibe
        System.out.println("matriz preenchida aleatoriamente:");
        matriz.preencherAleatorio();
        matriz.exibirMatriz();

        // insere o valor 99 na posição 1 1 e exibe a matriz
        System.out.println("\ninsserindo valor 99 na posição [1][1]:");
        matriz.inserirElemento(1, 1, 99);
        matriz.exibirMatriz();

        // remove o valor na posição 1 1 e exibe a matriz
        System.out.println("\nremovendo valor da posição [1][1]:");
        matriz.removerElemento(1, 1);
        matriz.exibirMatriz();

        // ppermite que o user preencha a matriz manualmente e a exibe
        System.out.println("\npreenchendo manualmente:");
        matriz.preencherManual();
        matriz.exibirMatriz();
    }
}