import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        double n1, n2;
        double resultado = 0;
        int op;
        int countSoma = 0, countSubtracao = 0, countMultiplicacao = 0, countDivisao = 0;
        int totalOperacoes = 0;
        boolean continuar = true;
        Scanner entrada = new Scanner(System.in);

        while(continuar){
            System.out.println("Informe o primeiro valor");
            n1 = entrada.nextDouble();
            System.out.println("Informe o segundo valor");
            n2 = entrada.nextDouble();

            System.out.println("Selecione uma operação");
            System.out.println("[1] Soma");
            System.out.println("[2] Subtrair");
            System.out.println("[3] Multiplicar");
            System.out.println("[4] Dividir");
            System.out.println("Digite sua opção");
            op = entrada.nextInt();

            switch (op){
                case 1:
                    resultado = n1 + n2;
                    System.out.println("A soma é " +resultado);
                    countSoma++;
                    break;
                case 2:
                    resultado = n1 - n2;
                    System.out.println("A subtração é " +resultado);
                    countSubtracao++;
                    break;
                case 3:
                    resultado = n1 * n2;
                    System.out.println("A multiplicação é " +resultado);
                    countMultiplicacao++;
                    break;
                case 4:
                    if (n2 == 0){
                        System.out.println("Impossível dividir por 0 ");
                    }else{
                        resultado = n1 / n2;
                        System.out.println("A divisão é " +resultado);
                        countDivisao++;
                    }
                    break;
                default:
                    System.out.println("Operação inválida");
                    continue; //retorna o inicio do loop
            }
            totalOperacoes++;

            System.out.println("Deseja realizar outrs operações??? (S/N");
            char opcao =entrada.next().charAt(0);
            if (opcao == 'N' || opcao == 'n'){
                continuar = false;
            }
        }
        System.out.println("\nResumo das operações realizadas:");
        System.out.println("Somas realizadas: " + countSoma);
        System.out.println("Subtrações realizadas: " + countSubtracao);
        System.out.println("Multiplicações realizadas: " + countMultiplicacao);
        System.out.println("Divisões realizadas: " + countDivisao);
        System.out.println("Total de operações realizadas: " + totalOperacoes);

    }
}