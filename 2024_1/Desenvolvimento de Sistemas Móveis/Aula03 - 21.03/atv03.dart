// 3 - Escreva uma função que aceita uma lista de números como entrada e retorna uma nova lista contendo apenas os números pares da lista original.

import 'dart:io';
List<int> encontrarNumPar(List<int> listaOriginal) {
    List<int> numerosPares = [];

    for(int numero in listaOriginal){
        if(numero %2 == 0){
            numerosPares.add(numero);
        }    
    }
    return numerosPares;
}

void main (){
List<int> numeros = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
List<int> numerosPares = encontrarNumPar(numeros);
print('Lista original: $numeros');
print('Lista pares: $numerosPares');
}