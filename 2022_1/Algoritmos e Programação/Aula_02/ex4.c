#include <stdio.h>
 #include <math.h>
int main() {
float num1, num2;
 printf("Digite o primeiro numero - ");
 scanf("%f%*c", &num1);
                                    
  printf("Digite o segundo numero - ");
  scanf("%f%*c", &num2); 
                                    
  if(num1 == num2){
  printf("Os numeros sao iguais");
 }
 if(num1>num2){
 printf("O valor maior e - %.2f",num1);
 }
 if(num2>num1){
 printf("O valor maior e- %.2f",num2);
 }
 return 0;
}



