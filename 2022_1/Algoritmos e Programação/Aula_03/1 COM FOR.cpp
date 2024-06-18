#include <stdio.h>
#include <math.h>

int main() {
int numero,soma;
soma=0;
for(int i=0;i<10;i++){
  printf("Digite um numero %d\n",i+1);
  scanf("%d%*c",&numero);
  soma=numero+soma;
}
  printf("A soma eh %d", soma);
  return 0;

}
