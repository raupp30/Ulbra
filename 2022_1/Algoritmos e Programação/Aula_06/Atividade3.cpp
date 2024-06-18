#include <stdio.h>
#include <math.h>
#include <string.h>

int main(void)
{
char palavra[20];
int contador, numVogais = 0;

scanf("%s",palavra);

for(contador=0; contador < palavra[contador]; contador++){

if (palavra[contador]== 'A'  || palavra[contador]== 'E'  || palavra[contador]== 'I' || palavra[contador]== 'O' || palavra[contador]== 'U'){
numVogais++;
}
}

printf("%d\n",numVogais);

return 0;
}
