public class Pedido {
    int id;
    String desc;

    public Pedido(int id, String desc) {
        this.id = id;
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Pedido ID: " + id + ", Descrição: " + desc;
    }
}