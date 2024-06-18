2 - Escreva uma função que recebe uma lista de números e retorna apenas os números pares.

fun numerosPares (lista: List<Int>): List<Int>{
    val numerosPares = mutableListOf<Int>()
    for(numero in lista) {
        if (numero % 2 == 0) {
            numerosPares.add(numero)
        }
    }
    return numerosPares;
}

fun main (){
    val listaOriginal = listOf (1, 3, 4, 20)
    val pares = numerosPares(listaOriginal)
    print("Numeros pares da lista original: $pares");
}