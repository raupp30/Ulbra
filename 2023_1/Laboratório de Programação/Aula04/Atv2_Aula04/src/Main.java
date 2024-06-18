public class Main {
    public static void main(String[] args) {
        Fracao fracao1 = new Fracao();
        fracao1.numerador = 5;
        fracao1.denominador = 2;

        Fracao fracao2 = new Fracao();
        fracao2.numerador = 7;
        fracao2.denominador = 3;

        Fracao fracao3 = new Fracao();

        fracao3 = fracao1.multiplicar(fracao2);

        System.out.println("O resultado da fração é " +fracao3.denominador + " / " + fracao3.numerador);
    }
}