import com.sun.security.jgss.GSSUtil;

import java.util.Scanner;

public class Exer1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite um número inteiro positivo");
        int num = sc.nextInt();

        int soma = 0;
        int i = 1;

        while (i <= num){
            soma += i++;
            i++;

            System.out.println("A soma dos numeros naturais até" + num + "é" + soma);
            sc.close();
        }
    }
}
