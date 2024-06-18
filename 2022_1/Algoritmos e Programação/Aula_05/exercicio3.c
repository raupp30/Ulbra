#include <stdio.h>
#include <stdlib.h>

int main()
{

    int num[10], i = 0, j = 0, repetir;

    printf("Digite 10 numeros:\n");
    for (i = 0; i < 10; i++)
    {
        printf("[%i]", i + 1);
        scanf("%d", &num[i]);
    }

    printf("Numeros repetidos:\n");
    for (i = 0; i < 10; i++)
    {
        for (j = i + 1; j < 10; j++)
        {
            if (num[j] == num[i])
            {
                repetir = num[i];
                printf("%d\n", repetir);
            }
        }
    }
    return 0;
}