

import java.util.HashMap;
import java.util.Map;

public class CatalogoProdutos {
    private Map<String, String> produtos;

    public CatalogoProdutos() {
        produtos = new HashMap<>();
    }

    public void adicionarProduto(String codigo, String nome) {
        produtos.put(codigo, nome);
        System.out.println("Produto adicionado: " + nome);
    }

    public String buscarProduto(String codigo) {
        return produtos.getOrDefault(codigo, "Produto não encontrado");
    }

    public void exibirProdutos() {
        System.out.println("Produtos cadastrados: " + produtos);
    }
}
