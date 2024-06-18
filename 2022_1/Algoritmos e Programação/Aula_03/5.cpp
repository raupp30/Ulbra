#include <stdio.h>

int main(){
	int n,i,soma;
	soma=0;
	i=0;
	
	
		printf("Digite o numero");
		scanf("%d%*c", &n);
		do{
		soma=i+soma;
		i++;
	}while(i<=n);
	printf("A soma de 1 ate %d eh %d",n,soma);
}
