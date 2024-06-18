import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {

    private List<Produto> produtos = new ArrayList<>();
    double valorTotal = 0;
    public void addAoCarrinho(Produto produto){
        produtos.add(produto);
        valorTotal += produto.valor;
    }

    public double getTotal(){
        return valorTotal;
    }
}
