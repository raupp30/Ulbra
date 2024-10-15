// Arquivo: Main.java

public class Main {
    public static void main(String[] args) {
        // Criação de uma lista encadeada de inteiros
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();

        // Adicionando elementos na lista
        lista.adicionarNoInicio(10);
        lista.adicionarNoInicio(5);
        lista.adicionarNoFim(15);
        lista.adicionarNaPosicao(2, 12);  // Adiciona o 12 na posição 2

        // Exibindo a lista
        System.out.println("Lista após as inserções: " + lista);

        // Removendo elementos da lista
        int removidoInicio = lista.removerDoInicio();  // Remove o primeiro elemento
        System.out.println("Removido do início: " + removidoInicio);
        int removidoFim = lista.removerDoFim();  // Remove o último elemento
        System.out.println("Removido do fim: " + removidoFim);

        // Exibindo a lista após remoções
        System.out.println("Lista após as remoções: " + lista);

        // Atualizando um valor na lista
        lista.atualizar(1, 20);  // Atualiza o valor da posição 1 para 20
        System.out.println("Lista após a atualização: " + lista);

        // Buscando elementos
        int valorPosicao1 = lista.buscar(1);  // Busca o valor na posição 1
        System.out.println("Valor na posição 1: " + valorPosicao1);

        int posicaoValor10 = lista.buscarPosicao(10);  // Busca a posição do valor 10
        System.out.println("Posição do valor 10: " + (posicaoValor10 != -1 ? posicaoValor10 : "não encontrado"));

        // Removendo por valor
        try {
            int removidoValor = lista.removerPorValor(20);  // Remove o elemento com valor 20
            System.out.println("Elemento 20 removido: " + removidoValor);
        } catch (RuntimeException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        // Exibindo a lista final
        System.out.println("Lista final: " + lista);

        // Verificando o tamanho da lista
        System.out.println("Tamanho da lista: " + lista.tamanho());

        // Verificando se a lista está vazia
        System.out.println("A lista está vazia? " + lista.estaVazia());

        // Limpando a lista
        lista.limpar();
        System.out.println("Lista após limpar: " + lista);
        System.out.println("Tamanho após limpar: " + lista.tamanho());
    }
}
