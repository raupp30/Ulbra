#include <stdio.h>
#include <math.h>
int main() {
    int num1, num2;
        printf("Digite o primeiro numero - ");
        scanf("%d%*c", &num1);

        

    if(num1 %2 ==0){
    printf("O numero e multiplo -", num1);
    }else {
        printf("Nao e multiplo -", num1);
    }
    
    return 0;
}