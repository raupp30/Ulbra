Crie uma classe "CharGenerator" que receba no seu construtor primário (primary constructor), um valor min e um max e tenha um método onde gere um novo caracter.

import kotlin.random.Random

class CharGenerator (private val min: Char, private val max: Char){ //criando meu construtor primário
    init{
        require(min <= max) {"O valor mínimo deve ser menor ou igual o valor máximo"}
    }
    
    fun generateChar(): Char { 
        return Random.nextInt(min.toInt(), max.toInt() + 1).toChar() 
    }
}

fun main() {
    val charGenerator = CharGenerator('A', 'Z')

    // Gerando e imprimindo 5 caracteres aleatórios
    repeat(5) {
        println(charGenerator.generateChar())
    }
}