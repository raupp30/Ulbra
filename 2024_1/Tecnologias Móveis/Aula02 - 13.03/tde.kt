/*Escreva um programa em Kotlin que recebe uma lista de 5 números inteiros como entrada
e calcule amédia desses números. Certifique-se de lidar com casos em que a lista pode estar vazia*/

fun main() {
    println("Digite 5 números inteiros separados por espaço:")
    val input = readLine()?.split(" ")?.map { it.toIntOrNull() } ?: emptyList()
    
    if (input.size != 5 || input.any { it == null }) {
        println("Entrada inválida. Por favor, insira exatamente 5 números inteiros.")
        return
    }
    
    val sum = input.sumOf { it!! }
    val average = sum.toDouble() / input.size
    
    println("A média dos números é: $average")
}

/*Crie um programa que verifique uma variável utilizando o WHEN traduza as seguintes cores em
inglês para o portugues: blue, red, green, yellow*/

fun main() {
    println("Digite uma cor em inglês (blue, red, green, yellow):")
    val corEmIngles = readLine()?.toLowerCase()

    val corEmPortugues = when (corEmIngles) {
        "blue" -> "azul"
        "red" -> "vermelho"
        "green" -> "verde"
        "yellow" -> "amarelo"
        else -> "Cor desconhecida"
    }

    println("A cor em português é: $corEmPortugues")
}


