public class Turma {

    Aluno aluno1;
    Aluno aluno2;
    Aluno aluno3;
    double CalcularMedia(){
        double media = (aluno1.CalcularMedia() + aluno2.CalcularMedia() + aluno3.CalcularMedia()) / 3;
            return media;
    }
}
