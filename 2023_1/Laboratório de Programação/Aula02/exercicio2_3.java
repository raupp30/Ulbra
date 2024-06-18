public class exercicio2_3 {
    public static void main(String[] args) {
        //acumular o valor da soma p checar quando devemos parar o loop

        int i = 0;

        //variavel para representar cada interação do bloco while
        int r = 0;
        // para checar se a prox interação passara de 100, eu faço a soma de r e i, verificando se é < que 100

        while (r + i <100){
            System.out.println(i);
            //r recebe seu valor + i
            r +=i;
            //incremento de i
            i++;
        }
    }
}
