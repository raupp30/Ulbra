public class Main {
    public static void main(String[] args) {
        Arquivo arquivo;

        arquivo = new ArqText();
        arquivo.abrir();
        System.out.println("-------");
        arquivo.fechar();
        System.out.println("-------");

        arquivo = new ArqMusic();
        arquivo.abrir();
        System.out.println("-------");
        arquivo.fechar();
        System.out.println("-------");

        arquivo = new ArqImg();
        arquivo.abrir();
        System.out.println("-------");
        arquivo.fechar();
    }
}