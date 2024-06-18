
#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <time.h>

int main()
{
    

    int vet[100];
    int i;
    int cont = 0, op = 0;
    int maior = 0;

    srand((unsigned)time(NULL));

    for (i = 0; i < 100; i++)
    {
        vet[i] = rand() % 1000;
        printf("Numero %d: %d\n", i + 1, vet[i]);
        cont++;
        if (vet[i] == 999)
        {
            break;
        }
    }

    do
    {
        printf("Digite 1 para exibir uma lista os números presentes no vetor, não incluído o 999.\n");
        printf("Digite 2 para imprimir o vetor na ordem inversa.\n");
        printf("Digite 3 para Exibir o maior número\n");
        printf("Digite 4 para Exibir quantos números foram sorteados.\n");
        printf("Digite 5 para Encerrar o programa.\n");
        scanf("%d%*c", &op);

        printf("\n");

        switch (op)
        {
        case 1:
            for (i = 0; i < 100; i++)
            {
                printf("Vetor [%d], número: %d\n", i + 1, vet[i]);
            }
            break;
        case 2:
            for (i = 99; i >= 0; i--)
            {
                printf("Vetor [%d], número: %d\n", i + 1, vet[i]);
            }
            break;
        case 3:
            for (i = 0; i < 100; i++)
            {
                if (vet[i] > maior)
                {
                    maior = vet[i];
                }
            }
            printf("O maior número é: %d\n", maior);
            break;
        case 4:
            printf("Foram sorteados %d números\n", cont);
            break;
        default:
            break;
        }
    } while (op != 5);
}
