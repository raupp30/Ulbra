import java.util.List;
public class Subtracao implements Operacao {
    @Override
    public double calcular(List<Double> numeros) {
        double resultado = numeros.get(0);
        for (int i=1; i < numeros.size(); i++){
        resultado -= numeros.get(i);
        }
        return resultado;
    }
}