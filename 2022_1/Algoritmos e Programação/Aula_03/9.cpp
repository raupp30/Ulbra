#include <stdio.h>
#include <math.h>

int main(){
	int n, i;
	for(i=1;i<11;i++){
		printf("Digite o numero da tabuada\n" );
		scanf("%d%*c", &n);
		printf("%d X %d = %d \n", i,n,(n*1) );
	}
}
