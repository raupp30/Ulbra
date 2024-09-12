public class VetorClientes {

    private Cliente[] clientes;
    private int tamanho;

    public VetorClientes(int capacidade) {
        this.clientes = new Cliente[capacidade];
        this.tamanho = 0;
    }

    public boolean addClient(Cliente cliente) {
        if (tamanho < clientes.length) {
            clientes[tamanho] = cliente;
            tamanho++;
            return true;
        } else {
            System.out.println("Capacidade max atingida, cliente n add");
            return false;
        }
    }

    public void listarClient() {
        for (int i = 0; i < tamanho; i++) {
            System.out.println(clientes[i]);
        }
    }

    public Cliente buscarClient(String nome) {
        for (int i = 0; i < tamanho; i++) {
            if (clientes[i].getNome().equalsIgnoreCase(nome)) {
                return clientes[i];
            }
        }
        return null;
    }

    public void filtrarClientesEmailDominio(String dominio) {
        for (int i = 0; i < tamanho; i++) {
            if (clientes[i].getEmail().endsWith(dominio)) {
                System.out.println(clientes[i]);
            }
        }
    }
    public boolean alterarCliente(int posicao, Cliente novoCliente) {
        if (posicao >= 0 && posicao < tamanho) {
            clientes[posicao] = novoCliente;
            return true;
        }
        return false;
    }
    public boolean excluirClient(int posicao) {
        if (posicao >= 0 && posicao < tamanho) {
            for (int i = posicao; i < tamanho; i++) {
                clientes[i] = clientes[i + 1];
            }
            clientes[tamanho - 1] = null;
            tamanho--;
            return true;
        }
        return false;
    }

    public boolean inserirCliente(int posicao, Cliente cliente) {
        if (posicao >= 0 && posicao < tamanho && tamanho < clientes.length) {
            for (int i = tamanho; i > posicao; i--) {
                clientes[i] = clientes[i - 1];
            }
            clientes[posicao] = cliente;
            tamanho++;
            return true;
        }
        return false;
    }
}
