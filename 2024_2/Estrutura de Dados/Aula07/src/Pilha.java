public class Pilha {
    private String[] elementos;
    private int tamanho;

    public Pilha(int capacidade) {
        this.elementos = new String[capacidade];
        this.tamanho = 0;
    }

    public int tamanho() {
        return this.tamanho;
    }

    public boolean estaVazia() {
        return this.tamanho == 0;
    }

    public boolean estaCheia() {
        return this.tamanho == this.elementos.length;
    }

    public boolean empilhar(String elemento) {
        if (!estaCheia()) {
            this.elementos[this.tamanho] = elemento;
            this.tamanho++;
            return true;
        }
        return false;
    }

    public String desempilhar() {
        if (!estaVazia()) {
            String elementoRemovido = this.elementos[this.tamanho - 1];
            this.elementos[this.tamanho - 1] = null;
            this.tamanho--;
            return elementoRemovido;
        }
        return null;
    }

    public String espiar() {
        if (!estaVazia()) {
            return this.elementos[this.tamanho - 1];
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("[");
        for (int i = 0; i < this.tamanho - 1; i++) {
            s.append(this.elementos[i]);
            s.append(", ");
        }
        if (this.tamanho > 0) {
            s.append(this.elementos[this.tamanho - 1]);
        }
        s.append("]");
        return s.toString();
    }
}
