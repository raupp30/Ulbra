#include <stdio.h>
#include <math.h>

int main() {
  int numeroIn, numeroFi;
  printf("Digite um numero\n");
  scanf("%d%*c" ,&numeroIn);

  printf("Digite um numero\n");
  scanf("%d%*c" ,&numeroFi);

while (numeroIn<numeroFi){
  if(numeroIn %2 != 0){
    printf("%d\n",numeroIn);
    
  }
  numeroIn++;
 }
  return 0;
 }
