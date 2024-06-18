import java.util.List;
public class Multiplicacao implements Operacao {
    @Override
    public double calcular(List<Double> numeros) {
        double resultado = 1;
        for (Double numero : numeros) {
            resultado *= numero;
        }
        return resultado;
    }
}