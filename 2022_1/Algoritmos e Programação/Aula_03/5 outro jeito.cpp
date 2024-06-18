#include <stdio.h>

int main(){
	int n,i,soma;
	soma=0;
	i=0;
	
	
		printf("Digite o numero");
		scanf("%d%*c", &n);
		i=0;
		soma=0;
		
	while(i<=n);
	{
		soma=i+soma;
		i++;
	}
	printf("A soma de 1 ate %d eh %d",n,soma);
}
