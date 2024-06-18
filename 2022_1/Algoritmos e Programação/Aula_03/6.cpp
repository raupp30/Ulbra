#include <stdio.h>
int main(){
	int n,i;
	
	for(i=0;i<5;i++){
		printf("Digite o numero :");
		scanf("%d%*c", &n);
		if(n==0){
			printf("Numero nulo");
		}else if(n>0){
			printf("Numero positivo");
		}else{
			printf("Numero negativo");
		}
	}
}
