public class Loja {
    private Produtos produto1;
    private Produtos produto2;
    private Produtos produto3;

    public void AdicionarProduto(Produtos produtos){
        String Ok = "Produto " + produtos.getNome() + " adicionado";
        String NaoOk = "Produto " + produtos.getNome() + " não foi encontrado";

        if(this.produto1 == null){
            this.produto1 = produtos;
            System.out.println(Ok);
        }else if(this.produto2 == null){
            this.produto2 = produtos;
            System.out.println(Ok);
        }else if(this.produto3 == null){
            this.produto3 = produtos;
            System.out.println(Ok);
        }else{
            System.out.println(NaoOk);
        }
    }

    public void RemoverProduto(Produtos produtos){
        String Ok = "Produto: " + produtos.getNome() + " foi removido da loja";
        String NaoOk = "Produto: " + produtos.getNome() + " não encontrado no estoque da loja";

        if(this.produto1 == produtos){
            this.produto1 = null;
            System.out.println(Ok);
        }else if(this.produto2 == produtos){
            this.produto2 = null;
            System.out.println(Ok);
        }else if(this.produto3 == produtos){
            this.produto3 = null;
            System.out.println(Ok);
        }else{
            System.out.println(NaoOk);
        }
    }

    public void ListarProduto(){
        if(this.produto1 != null){
            System.out.println("Produto: " + this.produto1.getNome() + " / Quantidade: " + this.produto1.getQuantidade());
        }
        if(this.produto2 != null){
            System.out.println("Produto: " + this.produto2.getNome() + " / Quantidade: " + this.produto2.getQuantidade());
        }
        if(this.produto3 != null){
            System.out.println("Produto: " + this.produto3.getNome() + " / Quantidade: " + this.produto3.getQuantidade());
        }
    }

    public void VenderProduto(Produtos produtos, int quantidade){
        int estoque;
        int novoEstoque;

        String Ok = "Venda feita com sucesso";
        String NaoOk = "Sem estoque para venda";

        if (this.produto1 == produtos){
            estoque = this.produto1.getQuantidade();
            if(estoque >= quantidade){
                novoEstoque = estoque - quantidade;
                this.produto1.setQuantidade(novoEstoque);
                System.out.println(Ok);
            }else{
                System.out.println(NaoOk);
            }
        }

        if (this.produto2 == produtos){
            estoque = this.produto2.getQuantidade();
            if(estoque >= quantidade){
                novoEstoque = estoque - quantidade;
                this.produto2.setQuantidade(novoEstoque);
                System.out.println(Ok);
            }else{
                System.out.println(NaoOk);
            }
        }

        if (this.produto3 == produtos){
            estoque = this.produto3.getQuantidade();
            if(estoque >= quantidade){
                novoEstoque = estoque - quantidade;
                this.produto3.setQuantidade(novoEstoque);
                System.out.println(Ok);
            }else{
                System.out.println(NaoOk);
            }
        }
    }

    public void adicionarEstoque(Produtos produtos, int quantidade){
        int estoque;
        int novoEstoque;
        String Ok = "Nova quantidade " + produtos.getNome() + " adicionada com sucesso";
        if (this.produto1 == produtos){
            estoque = this.produto1.getQuantidade();
            novoEstoque = estoque + quantidade;
            this.produto1.setQuantidade(novoEstoque);
            System.out.println(Ok);
        }else if (this.produto2 == produtos){
            estoque = this.produto2.getQuantidade();
            novoEstoque = estoque + quantidade;
            this.produto2.setQuantidade(novoEstoque);
            System.out.println(Ok);
        }else if (this.produto3 == produtos){
            estoque = this.produto3.getQuantidade();
            novoEstoque = estoque + quantidade;
            this.produto3.setQuantidade(novoEstoque);
            System.out.println(Ok);
        }
    }
}

