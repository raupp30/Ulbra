//classe triangulo estendida de FormaGeometrica
class Triangulo extends FormaGeometrica {
    private double ladoA;
    private double ladoB;
    private double ladoC;

    public Triangulo(double ladoA, double ladoB, double ladoC) {
        this.ladoA = ladoA;
        this.ladoB = ladoB;
        this.ladoC = ladoC;
    }

    @Override
    public double calcularArea() {
        double p = calcularPerimetro() / 2; // semiperímetro
        return Math.sqrt(p * (p - ladoA) * (p - ladoB) * (p - ladoC));
    }

    @Override
    public double calcularPerimetro() {
        return ladoA + ladoB + ladoC;
    }
}