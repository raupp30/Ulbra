public class exercicio2_2 {
    public static void main(String[] args) {
        //declarar variavel p/ calcular soma

        int soma = 0;

        for (int i = 1; i <= 100; i += 2){
            // para cada interação de for, coma receba o seu valor anterior somado com valor de i

            soma = soma + i;
        }
        System.out.println(soma);
    }
}
