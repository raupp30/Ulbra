// 1 - Escreva uma função que recebe uma lista de números e retorna a média aritmética.

fun calcularMedia(numeros: List<Double>): Double{
    if(numeros.isEmpty()){
        return 0.0;
    }

    var soma = 0.0;
    for(numero in numeros){
        soma += numero;
    }
    return soma / numeros.size
}

fun main (){
    val numeros = listOf(10.0, 10.0, 10.0, 10.0, 10.0);
    val media = calcularMedia(numeros);
    println("A média dos números é: $media");
}