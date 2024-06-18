#include <stdio.h>

int main(){
	int i,valor;
	int nImpar=0;
	int nPar=0;
	i=0;
	do{
	
	printf("Digite o valor inteiro \n");
	scanf("%d%*c", &valor);
	if(valor%2==0){
		printf("Numero par\n");
		nPar++;
	}else{
		printf("Numero impar\n");
		nImpar++;
	}
	i++;
	
	}while(i<10);
	printf("Foram executados %d pares\n", nPar);
	printf("Foram executados %d impares\n", nImpar);
}

