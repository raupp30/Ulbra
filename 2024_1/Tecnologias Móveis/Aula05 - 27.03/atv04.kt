Crie uma data class pessoa que recebe no seu construtor primário nome, idade, profissão e cpf, ambos são parâmetros imutáveis. Após instanciar a classe
utilize o método copy para criar uma nova instância alterando o nome passando por parâmetro o nome completo.

data class Pessoa
(
    val nome: String,
    val idade: Int,
    val profissao: String,
    val cpf: String
)

fun main(){
    val pessoaOriginal = Pessoa("João", 30, "Estudante", "03831859043")
    println ("Pessoa Original: $pessoaOriginal")
    
    val pessoaAtualizada = pessoaOriginal.copy(nome = "Pedrinho")
    println ("Pessoa atualizada: $pessoaAtualizada")
}