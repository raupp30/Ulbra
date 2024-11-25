

import java.util.ArrayList;
import java.util.List;

public class ArvoreGenealogica {
    private static class Pessoa {
        String nome;
        List<Pessoa> filhos;

        Pessoa(String nome) {
            this.nome = nome;
            this.filhos = new ArrayList<>();
        }

        void adicionarFilho(Pessoa filho) {
            filhos.add(filho);
        }

        void exibirArvore(String prefixo) {
            System.out.println(prefixo + nome);
            for (Pessoa filho : filhos) {
                filho.exibirArvore(prefixo + "--");
            }
        }
    }

    private Pessoa raiz;

    public void adicionarRaiz(String nome) {
        raiz = new Pessoa(nome);
    }

    public Pessoa adicionarFilho(String nomePai, String nomeFilho) {
        Pessoa pai = buscarPessoa(raiz, nomePai);
        if (pai != null) {
            Pessoa filho = new Pessoa(nomeFilho);
            pai.adicionarFilho(filho);
            return filho;
        }
        return null;
    }

    private Pessoa buscarPessoa(Pessoa atual, String nome) {
        if (atual == null) return null;
        if (atual.nome.equals(nome)) return atual;
        for (Pessoa filho : atual.filhos) {
            Pessoa encontrado = buscarPessoa(filho, nome);
            if (encontrado != null) return encontrado;
        }
        return null;
    }

    public void exibirArvore() {
        if (raiz != null) raiz.exibirArvore("");
    }
}
