#include <stdio.h>
#include <math.h>

int main() {
int numero,soma;
soma=0;
int i=0;
do{
  
  printf("Digite um numero %d\n",i+1);
  scanf("%d%*c",&numero);
  soma=numero+soma;
  i++;
}while(i<10);

  printf("A soma eh %d", soma);
  return 0;
}
  


