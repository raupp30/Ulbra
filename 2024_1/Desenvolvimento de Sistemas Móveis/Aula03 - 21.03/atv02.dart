// 2 - Escreva uma função que aceita uma lista de números como entrada e retorna uma nova lista onde cada elemento é o dobro do elemento correspondente na lista original.

import 'dart:io';
List<double> dobrarElementos(List<double> listaOriginal) {
    List<double> listaDobrada = [];

    for(double numero in listaOriginal){
        listaDobrada.add(numero * 2);
    }
    return listaDobrada;
}

void main (){
List<double> numeros = [2, 5, 10, 20];
List<double> numerosDobrados = dobrarElementos(numeros);
print('Lista original: $numeros');
print('Lista dobrados: $numerosDobrados');
}