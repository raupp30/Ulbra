#include <stdio.h>
#include <math.h>

int main() {
int media,nota,soma;
soma=0;
for(int i=0;i<10;i++){
printf("Digite a nota de aluno\n");
scanf("%d%*c",&nota);
soma=nota+soma;
}
media=soma/10;
printf("A media foi de %d" ,media);
}
