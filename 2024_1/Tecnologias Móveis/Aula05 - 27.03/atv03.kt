Crie uma sealed class que tenha o nome result e algumas classes que herdam da mesma, como Sucesso, Error e Loading. Utilizar sintaxe apresentada em aula.

sealed class Result {

class Sucess (val data: String) : Result()
class Error (val message: String) : Result()
object Loading : Result()

}

fun handleResult(result: Result){
    when(result){
        is Result.Sucess -> println ("Sucesso: ${result.data}")
        is Result.Error -> println ("Erro: ${result.message}")
        Result.Loading -> println ("Carregando...")
    }
}

fun main(){
    val sucessResult = Result.Sucess("Dados carregados com sucesso")
    val errorResult = Result.Error("Falha ao carregar os dados")
    val loadingResult = Result.Loading
    
    handleResult(sucessResult)
    handleResult(errorResult)
    handleResult(loadingResult)
    
}