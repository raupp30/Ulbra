Crie uma classe pessoa que tenha um construtor primário que recebe nome e idade como parâmetro, além disso, é necessário ter um método caminhar e falar. 
Obs: Os métodos caminhar e falar devem apenas printar "caminhando" e "falando"

class Pessoa (val nome: String, val idade: Int){ //criando meu construtor primário
    
    fun caminhar() { 
        println ("Caminhando")
    }
    
    fun falar(){ 
        println("Falando")
    }
}

fun main(){
    val pessoa = Pessoa ("João", 30)
    pessoa.falar()
    pessoa.caminhar()
}

