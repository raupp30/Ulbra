#include <stdio.h>
#include <math.h>
int main() {
float idade;
    printf("Digite a idade - ");
    scanf("%f%*c", &idade);

if(idade >= 18){
  printf("Voce eh maior de idade", idade);
}
  
if (idade < 18){
  printf("Voce eh menor de idade", idade);
}
  
  return 0;
    }