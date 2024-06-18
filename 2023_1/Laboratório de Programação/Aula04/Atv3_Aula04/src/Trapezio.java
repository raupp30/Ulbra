public class Trapezio {
    double BaseMaior;
    double BaseMenor;
    double Altura;

    double CalcularArea(){
        double Area;
        Area = BaseMaior + BaseMenor / 2 * Altura;
        return Area;
    }
}
