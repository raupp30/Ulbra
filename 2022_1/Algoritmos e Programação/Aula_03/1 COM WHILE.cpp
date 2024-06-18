#include <stdio.h>
#include <math.h>

int main() {
int numero,soma;
soma=0;
int i=0;
while(i<10){
  printf("Digite um numero %d\n",i+1);
  scanf("%d%*c",&numero);
  soma=numero+soma;
  i++;
}
  printf("A soma eh %d", soma);
  return 0;
}
