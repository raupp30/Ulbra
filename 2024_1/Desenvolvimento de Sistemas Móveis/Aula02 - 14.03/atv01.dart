// Escreva um programa em DART que contém uma lista de 5 números inteiros como entrada e calcule a média desses números.
//Certifique-se de lidar com casos em que a lista pode estar vazia.

void main() {
  List<int> numbers = [10, 10, 10, 10, 10];
  if (numbers.isEmpty) {
    print("A lista está vazia.");
    return;
  }
  
  double sum = 0;
  for (int number in numbers) {
    sum += number;
  }
  
  double average = sum / numbers.length;
  
  print("A média dos números é: $average");
}

//

// Crie um programa que verifique uma variável utilizando o Switch, traduza as seguintes cores em inglês para o portugues: blue, red, green, yellow

void main() {
  String corEmIngles = 'red'; // altere a cor aqui para testar outras cores

  String corEmPortugues;

  switch (corEmIngles) {
    case 'blue':
      corEmPortugues = 'azul';
      break;
    case 'red':
      corEmPortugues = 'vermelho';
      break;
    case 'green':
      corEmPortugues = 'verde';
      break;
    case 'yellow':
      corEmPortugues = 'amarelo';
      break;
    default:
      corEmPortugues = 'Cor desconhecida';
  }

  print("A cor em português é: $corEmPortugues");
}
