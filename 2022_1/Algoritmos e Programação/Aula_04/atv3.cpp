// Faça um programa para ler uma quantidade indeterminada de valores inteiros. Para cada valor fornecido escrever uma mensagem que indica se cada valor fornecido é PAR ou ÍMPAR. O programa será encerrado imediatamente após a leitura de um valor NULO (zero) ou NEGATIVO.

#include <stdio.h>
#include <windows.h>

int main(){
    UINT CPAGE_UTF8 = 65001;
    SetConsoleOutputCP (CPAGE_UTF8);

    int n;

    do{
        printf("Digite o número %d\n");
        scanf("%d%*c", &n);
        if(n <= 0){
            break;
        }else{
            if(n % 2 == 0){
            printf("O número é PAR\n");
            }else{
            printf("O número é IMPAR\n");
            }
        }

    }while(n > 0);

}