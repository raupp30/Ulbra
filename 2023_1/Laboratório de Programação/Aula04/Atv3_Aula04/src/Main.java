public class Main {
    public static void main(String[] args) {
        Quadrado quadrado1 = new Quadrado();
        quadrado1.lado = 5;
        double resultado = quadrado1.CalcularArea();
        System.out.println("Resultado da area do quadrado é " +resultado);

        Triangulo triangulo1 = new Triangulo();
        triangulo1.base = 5;
        triangulo1.altura = 2;
        double resultadoTriangulo = triangulo1.CalcularArea();
        System.out.println("Resultado do calculo do triangulo é " +resultadoTriangulo);

        Circunferencia circunferencia1 = new Circunferencia();
        circunferencia1.raio = 5;
        double resultadoCircunferencia = circunferencia1.CalcularArea();
        System.out.println("Resultado do calculo da circunferencia é " +resultadoCircunferencia);

        Trapezio trapezio1 = new Trapezio();
        trapezio1.Altura = 2;
        trapezio1.BaseMenor = 3;
        trapezio1.BaseMaior = 5;
        double resultadoTrapezio = trapezio1.CalcularArea();
        System.out.println("Resultado do calculo do trapezio é " +resultadoTrapezio);
    }
}