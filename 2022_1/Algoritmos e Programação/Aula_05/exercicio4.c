#include <stdio.h>
#include <stdlib.h>


int main()
{
    
    int vetor[5], i, codigo=0;

    for (i = 0; i < 5; i++) {
        printf("Digite o %dº valor:\n", i+1);
        scanf("%d%*c", &vetor[i]);
    }
    
    printf("Digite o codigo desejado:\n");
    scanf("%d%*c", &codigo);

    if (codigo == 0) {
        printf("Código Encerrado...\n");
    }
    else if (codigo == 1) {
        for (i = 0; i < 5; i++) {
            printf("Ordem Direta: %d\n", vetor[i]);
        }
    }
    else if (codigo == 2) {
        for (i = 4; i > 0; i--) {
            printf("Ordem Inversa: %d\n", vetor[i]);
        }
    }
    else if (codigo > 2){
        printf("codigo invalido\n");
    }
    
}