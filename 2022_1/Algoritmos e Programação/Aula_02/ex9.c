#include <stdio.h>
#include <math.h>
int main() {
float nota1, nota2, nota3, media;
    printf("Digite a primeira nota");
    scanf("%f%*c", &nota1);

    printf("Digite a segunda nota");
    scanf("%f%*c", &nota2);

    printf("Digite a terceira nota");
    scanf("%f%*c", &nota3);
media = (nota1 + nota2 + nota3)/3;

if(media >=9){
  printf("Obteve conceito A");

}
  
if(media >=7.5 && media <9){
  printf("Obteve conceito B");
}
  
if(media >=6 && media <7.5){
  printf("Obteve conceito C");
}
  
if(media >=4 && media <6){
  printf("Obteve conceito D");
}
  
if(media >=0 && media <4){
  printf("Obteve conceito E");
}
    return 0;
}