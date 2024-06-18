
#include <stdio.h>
#include <stdlib.h>

int main(void)
{
int i, controle = 0;
int n;
int vet[10];

for(i=0 ; i < 10; i++) {
    vet[i] = rand()%100;
    printf("Numero %d: %d\n", i, vet[i]);
}

printf ("digite um numero: ");
scanf ("%d", &n);

for (i=0; i<10; i++){
	if (n==vet[i]){
	   	printf ("Esta no vetor na posicao %d", i);
	   	controle = 1;
	   	break;
	}

}

if(!controle)
    printf ("Nao esta no vetor");
}
