#include <stdio.h>
#include <math.h>

int main() {
int media,nota,soma,i;
soma=0;
  i=0;
do{
printf("Digite a nota de aluno\n");
scanf("%d%*c",&nota);
soma=nota+soma;
i++;
}while (i<10);
media=soma/10;
printf("A media foi de %d" ,media);
return 0;
}
