// 4 - Escreva uma função que calcule a média

import 'dart:io';
double calcularMedia(List<int> numeros) {
    if (numeros.isEmpty){
        return 0.0;
    }
    
    int soma = 0;
    for(var numero in numeros){
        soma += numero;
    }
        return soma / numeros.length;
    }

void main (){
List<int> numeros = [10, 10, 10, 10, 10];
double media = calcularMedia(numeros);
print('A média dos números é: $media');
}