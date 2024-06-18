// Faça um algoritmo que leia a nota de vários alunos de uma turma. Ao final, deve ser escrita a média geral da turma. A leitura das médias somente encerra quando uma nota negativa for digitada.

#include <stdio.h>
#include <windows.h>

int main(){
    UINT CPAGE_UTF8 = 65001;
    SetConsoleOutputCP (CPAGE_UTF8);

    int i;
    float nota, media, soma;

    soma = 0;
    i = 1;

    do{
        printf("Digite a nota %d\n", i+1);
        scanf("%f%*c", &nota);

        if(nota >= 0){
            i++;
            soma = (soma + nota);
        }else{
            printf("Encerrando...\n");
            break;
        }
    }while (nota >= 0);
    media = (soma / i);
    printf("A média é %f\n", media);
    printf("Foram lidos %d\n", i);
}
