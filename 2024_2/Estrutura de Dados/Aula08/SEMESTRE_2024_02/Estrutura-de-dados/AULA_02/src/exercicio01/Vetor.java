package exercicio01;

public class Vetor {
    private String[] elementos;
    private int tamanho;

    public Vetor(int capacidade) {
        this.elementos = new String[capacidade];
        this.tamanho = 0;
    }

    // Adicionar elemento ao final
    public boolean adicionar(String elemento) {
        if (tamanho == elementos.length) {
            return false; // Vetor cheio
        }
        elementos[tamanho] = elemento;
        tamanho++;
        return true;
    }

    // Adicionar elemento em uma posição específica
    public boolean adicionar(int posicao, String elemento) {
        if (posicao < 0 || posicao > tamanho || tamanho == elementos.length) {
            return false; // Posição inválida ou vetor cheio
        }
        for (int i = tamanho - 1; i >= posicao; i--) {
            elementos[i + 1] = elementos[i];
        }
        elementos[posicao] = elemento;
        tamanho++;
        return true;
    }

    // Obter elemento de uma posição
    public String obter(int posicao) {
        if (posicao < 0 || posicao >= tamanho) {
            return null; // Posição inválida
        }
        return elementos[posicao];
    }

    // Alterar elemento de uma posição
    public boolean alterar(int posicao, String elemento) {
        if (posicao < 0 || posicao >= tamanho) {
            return false; // Posição inválida
        }
        elementos[posicao] = elemento;
        return true;
    }

    // Remover elemento pelo índice
    public boolean remover(int posicao) {
        if (posicao < 0 || posicao >= tamanho) {
            return false; // Posição inválida
        }
        for (int i = posicao; i < tamanho - 1; i++) {
            elementos[i] = elementos[i + 1];
        }
        elementos[tamanho - 1] = null;
        tamanho--;
        return true;
    }

    // Remover elemento pelo valor
    public boolean remover(String elemento) {
        int posicao = -1;
        for (int i = 0; i < tamanho; i++) {
            if (elementos[i].equals(elemento)) {
                posicao = i;
                break;
            }
        }
        if (posicao != -1) {
            remover(posicao);
            return true;
        }
        return false; // Elemento não encontrado
    }

    // Verificar se um elemento existe
    public boolean contem(String elemento) {
        for (int i = 0; i < tamanho; i++) {
            if (elementos[i].equals(elemento)) {
                return true;
            }
        }
        return false;
    }

    // Obter tamanho atual do vetor
    public int tamanho() {
        return tamanho;
    }

    // Verificar se o vetor está vazio
    public boolean estaVazio() {
        return tamanho == 0;
    }

    // Limpar o vetor
    public void limpar() {
        for (int i = 0; i < tamanho; i++) {
            elementos[i] = null;
        }
        tamanho = 0;
    }

    // Listar elementos
    @Override
    public String toString() {
        if (tamanho == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < tamanho - 1; i++) {
            sb.append(elementos[i]);
            sb.append(", ");
        }
        sb.append(elementos[tamanho - 1]);
        sb.append("]");
        return sb.toString();
    }

    // Teste da classe Vetor
    public static void main(String[] args) {
        Vetor vetor = new Vetor(3);

        vetor.adicionar("Elemento 1");
        vetor.adicionar("Elemento 2");
        vetor.adicionar("Elemento 3");
        System.out.println(vetor);

        vetor.adicionar("Elemento 4"); // Não adiciona, pois o vetor está cheio
        System.out.println(vetor);

        vetor.adicionar(1, "Elemento 5"); // Adiciona na posição 1
        System.out.println(vetor);

        System.out.println("Elemento na posição 2: " + vetor.obter(2));

        vetor.alterar(2, "Elemento Alterado");
        System.out.println(vetor);

        vetor.remover(3);
        System.out.println(vetor);

        vetor.remover("Elemento 1");
        System.out.println(vetor);

        System.out.println("Contém 'Elemento 2': " + vetor.contem("Elemento 2"));
        System.out.println("Tamanho atual: " + vetor.tamanho());

        vetor.limpar();
        System.out.println("Vetor após limpar: " + vetor);
        System.out.println("Vetor está vazio: " + vetor.estaVazio());
    }
}
