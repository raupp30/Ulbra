public class Main {
    public static void main(String[] args) {
        double numero1 = 10;
        double numero2 = 5;

        Operation soma = new Soma();
        Operation subtracao = new Subtracao();
        Operation divisao = new Divisao();
        Operation multiplicacao = new Multiplicacao();

        System.out.println("Soma: "+soma.executar(numero1, numero2));
        System.out.println("Subtração: "+subtracao.executar(numero1, numero2));
        System.out.println("Divisão: "+divisao.executar(numero1, numero2));
        System.out.println("Multiplicação: "+multiplicacao.executar(numero1, numero2));
    }
}