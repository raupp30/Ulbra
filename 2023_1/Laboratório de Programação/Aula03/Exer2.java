import java.util.Scanner;

public class Exer2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite um número");
        int num = sc.nextInt();

        boolean primo = true;

        if (num <= 1){
            primo = false;
        }else for (int i = 2; i <= num / 2; i++){
            if (num % i == 0){
                primo = false;
                break;
            }
        }
        if (primo) {
            System.out.println(num + "É numero primo");
        }else{
            System.out.println(num + "Não é número primo");
        }
    }
}
