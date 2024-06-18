public class Aluno {
    Prova prova1;
    Prova prova2;
    double CalcularMedia(){
        double media = (prova1.CalcularNotaTotal() + prova2.CalcularNotaTotal()) / 2;
            return media;
    }

}
