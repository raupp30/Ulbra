public class Main {
    public static void main(String[] args) {
        pessoa pessoa1 = new pessoa("João", 25, 1.75);

        System.out.println("Nome: " + pessoa1.getNome());
        System.out.println("Idade: " + pessoa1.getIdade());
        System.out.println("Altura: " + pessoa1.getAltura());

    }
}