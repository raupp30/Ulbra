#include <stdio.h>

#include <math.h>

 int main(){

 float num1, num2, res;
 printf("digite o primeiro numero:");
 scanf("%f%*c",&num1);

 printf("digite o segundo numero:");
 scanf("%f%*c",&num2);

 if (num1 > num2){
     res=num1 + 100;
    printf("o numero maior e %.2f",res);
 }else{
     res=num2 + 100;
    printf("o numero maior e %2.f",res);
    
 }
 
}



