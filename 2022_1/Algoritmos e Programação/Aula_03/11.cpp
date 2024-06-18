#include <stdio.h>

int main(){
	int total=3;
	int matricula,i;
	char nome[10];
	float nota1, nota2, nota3, media;
	
	
for(i=0;i<10;i++){
printf("Digite o nome do aluno %d: \n",i+1);
	scanf("%s%*c", &nome);
	
	printf("Digite o numero matricula \n");
	scanf("%d%*c", &matricula);
	
	printf("Digite a nota 1 \n");
	scanf("%f%*c", &nota1);
	
	printf("Digite a nota 2 \n");
	scanf("%f%*c", &nota2);
	
	printf("Digite a nota 3 \n");
	scanf("%f%*c", &nota3);
	media= (nota1+nota2+nota3)/3;
	if(media>=7){
	printf("O aluno %s matricula %d foi aprovado media %.2f \n", nome, matricula,media);
	}else{
		printf("O aluno foi reprovado media %.2f \n", nome,matricula,media);
			
				}
					}
}
