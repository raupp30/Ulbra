import java.util.List;
class MinhaCalculadora extends Calculadora {
    @Override
    public double executarOperacao(String operacao, List<Double> numeros) {
        // Verificar a operação desejada e calcular
        Operacao operacaoRealizada = null;

        switch (operacao) {
            case "soma":
                operacaoRealizada = new Soma();
                break;
            case "subtracao":
                operacaoRealizada = new Subtracao();
                break;
            case "multiplicacao":
                operacaoRealizada = new Multiplicacao();
                break;
            case "divisao":
                operacaoRealizada = new Divisao();
                break;
            default:
                System.out.println("Operação inválida");
                break;
        }
        if (operacaoRealizada != null) {
            double resultado = operacaoRealizada.calcular(numeros);
            return resultado;
        }
        return 0;
    }
}