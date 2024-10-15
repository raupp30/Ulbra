public class Cafeteria {
    public static void main(String[] args) {
        Fila<Pedido> filapedidos = new Fila<>();

        // add pedidos na fila
        filapedidos.enqueue(new Pedido(1, "Café Preto"));
        filapedidos.enqueue(new Pedido(2, "Chá"));
        filapedidos.enqueue(new Pedido(3, "Água mineral c/ gás"));
        filapedidos.enqueue(new Pedido(3, "Água mineral c/ gás"));

        // mostrar os pedidos pendentes
        System.out.println("Pedidos pendentes:");
        filapedidos.printQueue();
        System.out.println("----------------------");

        // atender um pedido (remover da fila)
        Pedido atendido = filapedidos.dequeue();
        System.out.println("Pedido atendido: " + atendido);
        System.out.println("----------------------");

        // imprime pedidos pendentes após atendimento
        System.out.println("Pedidos pendentes:");
        filapedidos.printQueue();
        System.out.println("----------------------");
    }
}
