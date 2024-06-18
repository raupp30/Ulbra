public class Divisao implements Operation{
    @Override
    public double executar(double numero1, double numero2){
        if(numero2 != 0){
            return numero1 / numero2;
    }else{
            throw new ArithmeticException("Divisão por 0 não é permitido");
         }
}
}
