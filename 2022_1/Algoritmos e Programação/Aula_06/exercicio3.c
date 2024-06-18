#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <string.h>
#include <time.h>
#include <assert.h>

int main()
{

    

    char palavra[20];
    int cont, Vogais = 0, tamanho = 0;

    printf("Digite uma palavra:\n");
    scanf("%s", palavra);

    for (cont = 0; cont < palavra[cont]; cont++) {

        if (palavra[cont] == 'a' || palavra[cont] == 'e' || palavra[cont] == 'i' || palavra[cont] == 'o' || palavra[cont] == 'u') {
            Vogais++;
        }
    }

    tamanho = strlen(palavra);
    printf("A palavra %s possui %d Letras e %d vogais\n", palavra, tamanho, Vogais);

    return 0;
}