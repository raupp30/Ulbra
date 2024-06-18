// Ler uma quantidade indeterminada de duplas de valores (2 valores de cada vez). Escrever para cada dupla uma mensagem que indique se ela foi informada em ordem crescente ou decrescente. A repetição será encerrada ao ser fornecido, para os elementos da dupla, valores iguais.

// [Para os dados de entrada abaixo]  [Deve ser gerada a seguinte saída]
//             2   2                              Decrescente
//             5   4                              Decrescente
//             7   2                               Crescente
//             3   8

#include <stdio.h>
#include <windows.h>

int main(){
    UINT CPAGE_UTF8 = 65001;
    SetConsoleOutputCP (CPAGE_UTF8);

    int i;
    float n1, n2;
    i = 0;

    do{
        printf("Digite dois números:\n");
        scanf("%f%f%*c", &n1, &n2);

        if(n1 > n2){
            printf("Ordem decrescente\n");
        }else if(n2 > n1){
            printf("Ordem Crescente\n");
        }
        i++;
    }while (n1 != n2);
    printf("Encerrando..\n");
}