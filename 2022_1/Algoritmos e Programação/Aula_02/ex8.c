#include <stdio.h>
#include <math.h>
int main() {
int num1, num2, num3,num4;
    printf("Digite o primeiro numero - ");
    scanf("%d%*c", &num1);


if(num1 %2 ==0){
  printf("O numero e multiplo por 2 \n-", num1);
}else {
	printf("Nao eh multiplo por 2 \n", num1);
	}

if (num1 %3 ==0){
	printf("O numero e multiplo por 3 \n", num1);
}else{
	printf("Nao eh multiplo por 3 \n", num1);
}
	
	
	
	
	printf("Digite o segundo numero - ");
    scanf("%d%*c", &num2);

  if(num2 %2 ==0){
  printf("O numero e multiplo por 2 \n-", num2);
}else {
	printf("Nao eh multiplo por 2 \n-", num2);
}
if (num2 %3 ==0){
	printf("O numero e multiplo por 3 \n", num1);
}else{
	printf("Nao eh multiplo por 3 \n", num1);
}
	





printf("Digite o terceiro numero - ");
    scanf("%d%*c", &num3);

  if(num3 %2 ==0){
  printf("O numero e multiplo por 2 \n-", num3);
}else {
	printf("Nao eh multiplo por 2 \n-", num3);
}
if (num3 %3 ==0){
	printf("O numero e multiplo por 3 \n", num1);
}else{
	printf("Nao eh multiplo por 3 \n", num1);
}
	



printf("Digite o quarto numero - ");
    scanf("%d%*c", &num4);

  if(num4 %2 ==0){
  printf("O numero e multiplo por 2 \n-", num4);
}else {
	printf("Nao eh multiplo por 2 \n-", num4);
}
if (num4 %3 ==0){
	printf("O numero e multiplo por 3 \n", num1);
}else{
	printf("Nao eh multiplo por 3 \n", num1);
}
	
return 0;
}