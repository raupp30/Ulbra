import java.util.Calendar;

public class Quadrado extends FiguraGeometrica {

    @Override
    public void CalcularArea(){
        int base = 5;
        int altura =2;
        System.out.println("A área é "+base * altura);
    }

    @Override
    public void CalcularPerimetro(){
        int lado = 5;
        System.out.println("A some do perimetro é "+lado*4);
    }
}
