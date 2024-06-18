// Ler dois valores inteiros e escrever o resultado da divisão do primeiro pelo segundo. Se o segundo valor informado for ZERO, deve ser impressa uma mensagem de VALOR INVÁLIDO e ser lido um novo valor. Ao final do programa deve ser impressa a seguinte mensagem: VOCE DESEJA OUTRO CÁLCULO (S/N).  Se a resposta for S o programa deverá retornar ao começo, caso contrário deverá encerrar a sua execução imprimindo quantos cálculos foram feitos. 


#include <stdio.h>
#include <windows.h>

int main(){
    UINT CPAGE_UTF8 = 65001;
    SetConsoleOutputCP (CPAGE_UTF8);

    float n1, n2, div;
    char opcao;

    do{    
        printf("Digite o número 1\n");
        scanf("%f%*c", &n1);

        do{
            printf("Digite o número 2\n");
            scanf("%f%*c", &n2);  
            if(n2 == 0){
                printf("Valor INVÁLIDO\n");
            }
            
        }while (n2 == 0);

        div = (n1 / n2);
        printf("A divisão de %.f / %.f é %.2f\n", n1, n2, div);
        printf("Deseja efetuar um novo calculo? [s/n]\n");
        scanf("%c%*c", &opcao);

    }while ((opcao == 's') || (opcao == 'S'));
}