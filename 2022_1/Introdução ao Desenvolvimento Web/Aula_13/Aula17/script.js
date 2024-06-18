function calcular(){
    var num1 = parseFloat (document.getElementById('num1').value)
    var num2 = parseFloat (document.getElementById('num2').value)
    var operacao = document.getElementById('operacao').value
    var resultado 
    switch (operacao) {
        case '+':
            resultado = num1 + num2    
        break;
        case '-':
            resultado = num1 - num2    
        break;
        case '*':
            resultado = num1 * num2    
        break;
        case '/':
            resultado = num1 / num2    
        break;
    
    }

    document.getElementById('resultado').innerHTML = ('O resultado e: ' + resultado)
}

function calcularConta(){
    var quantidadeKwh = parseFloat(document.getElementById('quantidadeKwh').value)
    var valorKwh = parseFloat(document.getElementById('valorKwh').value)
    var valorConta = quantidadeKwh * valorKwh

    if(quantidadeKwh > 100 && quantidadeKwh <= 200){
        valorConta = valorConta * 1.25
    }else if(quantidadeKwh > 200){
        valorConta = valorConta * 1.5
    }

    document.getElementById('valorConta').innerHTML = ('O valor da conta e de R$' + valorConta)
}

function verificarMaior(){
    var numeros = document.getElementById('numeros').value
    numeros = numeros.split(',')
    var maior = 0 

    for(var i=0; i < numeros.length; i++){
        var valorAtual = parseFloat(numeros[i])
        if(valorAtual > maior){
            maior = valorAtual
        }
    }

    document.getElementById('maiorNumero').innerHTML = 'O maior numero é:' + maior
}

function verificarIdades(){
    var idades = document.getElementById('idades').value
    idades = idades.split(',')

    var menoresDeIdade = 0
    var maioresDeIdade = 0

    for(var i=0; i < idades.length; i++){
        var idadeAtual = parseFloat(idades[i])

            if(idadeAtual < 18){
                menoresDeIdade++
            }else{
                maioresDeIdade++
            }
    }
    document.getElementById('mostrarIdades').innerHTML = menoresDeIdade + 'pessoas são menores de idade e' + maioresDeIdade + 'pessoas são maior de idades'
}
