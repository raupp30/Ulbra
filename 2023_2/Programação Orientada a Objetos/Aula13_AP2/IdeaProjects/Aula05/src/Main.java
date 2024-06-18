import java.util.List;

public class Main {
    public static void main(String[] args) {
        Calculadora calculadora = new MinhaCalculadora();

        List<Double> numeros = List.of(45.0, 9.0);

        System.out.println("Soma: "+ calculadora.executarOperacao("soma", numeros));
        System.out.println("Subtração: "+ calculadora.executarOperacao("subtracao", numeros));
        System.out.println("Multiplicação: "+ calculadora.executarOperacao("multiplicacao", numeros));
        System.out.println("Divisão: "+ calculadora.executarOperacao("divisao", numeros));

    }
}