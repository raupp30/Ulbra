// 5 - Escreva uma função que recebe uma lista de inteiros e retorna uma nova lista com apenas os números impares

import 'dart:io';
List<int> encontrarNumImpar(List<int> listaOriginal) {
    List<int> numerosImpar = [];

    for(int numero in listaOriginal){
        if(numero %2 == 1){
            numerosImpar.add(numero);
        }    
    }
    return numerosImpar;
}

void main (){
List<int> numeros = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
List<int> numerosImpar = encontrarNumImpar(numeros);
print('Lista original: $numeros');
print('Lista pares: $numerosImpar');
}