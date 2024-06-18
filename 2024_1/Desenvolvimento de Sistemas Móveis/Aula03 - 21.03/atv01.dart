// 1 - Crie uma calculadora simples que aceita dois números e uma operação (adição, subtração, multiplicação ou divisão) como entrada e retorna o resultado.

import 'dart:io';
void main{
    print('Insira o primeiro número');
    double numero1 = double.parse(stdin.readLineSync()!);

    print('Insira o segundo número');
    double numero2 = double.parse(stdin.readLineSync()!);

    print('Selecione a operação(+, -, *, /)');
    String operacao = stdin.readLineSync()!;

    double resultado = 0;
    switch(operacao){
        case '+':
        resultado = numero1 + numero2;
        break;
    
        case '-':
        resultado = numero1 - numero2;
        break;
    
        case '*':
        resultado = numero1 * numero2;
        break;
    
        case '/':
        if(numero2 != 0){
            resultado = numero1 / numero2;
        }else{
            print('Erro: Divisão por zero');
            return;
        }
        break;
    default:
        print('Operação inválida!');
        return;
    }
    print('O resultado é $resultado');
}
