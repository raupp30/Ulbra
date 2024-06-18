import java.util.List;
public class Soma implements Operacao {
    @Override
    public double calcular(List<Double> numeros) {
        double resultado = 0;
        for (Double numero : numeros) {
            resultado += numero;
        }
        return resultado;
    }
}
