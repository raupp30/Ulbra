//parte 1

var valor = parseFloat(prompt("Digite um valor"));

if (valor > 10) {
	alert("É maior que 10");
}else if(valor < 10){
	alert("Não é maior que 10");
}else{
    alert("É igual a 10");
}


//parte 2


var valor1 = parseFloat (prompt("Qual o valor 1?"));
var valor2 = parseFloat (prompt("Qual o valor 2?"));

valor = valor1 + valor2;

alert("Seu valor é: "+ valor );


//parte 3


var valor1 = parseFloat (prompt("Qual o valor 1?"));
var operacao = prompt('digite a operacao a ser realizada: (+, -,* ou /)');
var valor2 = parseFloat (prompt("Qual o valor 2?"));
var resultado;
switch (operacao) {
	case '+':
	resultado = valor1 + valor2
	break;
	case '-':
	resultado = valor1 - valor2
	break;
	case '*':
	resultado = valor1 * valor2
	break;
	case '/':
	resultado = valor1 / valor2
	break;

}
alert('o resultado da operacao e :' + resultado);


//parte 4


var nome = prompt('Digite seu nome: ');
var vezes = parseFloat(prompt('digite o numero de vezes'));

for(var i=0; i < vezes; i++){
	alert('Imprimindo ' + nome + ' ' + (i+1) + 'vezes')
}


//parte 5


var dados = []

dados [0] = prompt('digite o nome: ')
dados [1] = prompt('Digite o endereço: ')
dados [2] = prompt('digite o email: ')

alert('boa noite ' + dados[0] + ',seu endereco e' + dados[1] + ',e seu email e' + dados[2])