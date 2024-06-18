public class Main {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente();
        cliente1.nome = "João Vitor";
        cliente1.endereco = "Rua Pedro Reck, 41";
        cliente1.numeroCartao = 773;
        System.out.println("O nome do cliente é: "+cliente1.nome);
        System.out.println("O endereço do cliente é: "+cliente1.endereco);
        System.out.println("O numero do cartão do cliente é: " +cliente1.numeroCartao);
    }
}