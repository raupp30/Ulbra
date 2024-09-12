public class Main {
    public static void main(String[] args) {
        VetorClientes vetorClientes = new VetorClientes(20);

        System.out.println("Add clientes -----------------------");
        for (int i = 1; i <= 10; i++) {
            Cliente cliente = new Cliente("Cliente " + i, "Telefone " + i, "email" + i + "@exemplo.com");
            vetorClientes.addClient(cliente);
        }

        System.out.println("Alterando clientes -----------------------");
        Cliente clienteAlterado = new Cliente("Cliente Alterado", "Telefone Alterado", "alterado@exemplo.com");
        vetorClientes.alterarCliente(5, clienteAlterado);

        System.out.println("Excluindo clientes -----------------------");
        vetorClientes.excluirClient(3);

        System.out.println("Inserindo cliente na pos 2 -----------------------");
        Cliente novoCliente = new Cliente("Novo Cliente", "Novo Telefone", "novo@exemplo.com");
        vetorClientes.inserirCliente(2, novoCliente);

        System.out.println("Listando clientes -----------------------");
        vetorClientes.listarClient();

        System.out.println("Buscando cliente por nome -----------------------");
        Cliente clienteBuscado = vetorClientes.buscarClient("Cliente Alterado");
        if (clienteBuscado != null) {
            System.out.println("Cliente encontrado: " + clienteBuscado);
        } else {
            System.out.println("Cliente não encontrado.");
        }

        System.out.println("Buscando cliente por dominio email  -----------------------");
        System.out.println("Clientes com email do domínio @exemplo.com:");
        vetorClientes.filtrarClientesEmailDominio("@exemplo.com");
    }
}
