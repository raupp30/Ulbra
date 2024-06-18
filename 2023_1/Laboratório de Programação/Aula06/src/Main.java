public class Main {
    public static void main(String[] args){

        Turma turma1 = new Turma();

        Aluno aluno1 = new Aluno();
        Aluno aluno2 = new Aluno();
        Aluno aluno3 = new Aluno();

        //associação entre turma e alunos

        turma1.aluno1 = aluno1;
        turma1.aluno2 = aluno2;
        turma1.aluno3 = aluno3;


        Prova aluno1prova1 = new Prova();
        aluno1prova1.NotaParte1 = 4.0;
        aluno1prova1.NotaParte2 = 2.5;

        aluno1.prova1 = aluno1prova1;

        Prova aluno1prova2 = new Prova();
        aluno1prova2.NotaParte1 = 1.0;
        aluno1prova2.NotaParte2 = 7.0;

        aluno1.prova2 = aluno1prova2;



        Prova aluno2prova1 = new Prova();
        aluno2prova1.NotaParte1 = 6.5;
        aluno2prova1.NotaParte2 = 3.5;

        aluno2.prova1 = aluno2prova1;

        Prova aluno2prova2 = new Prova();
        aluno2prova2.NotaParte1 = 0.0;
        aluno2prova2.NotaParte2 = 3.0;

        aluno2.prova2 = aluno2prova2;



        Prova aluno3prova1 = new Prova();
        aluno3prova1.NotaParte1 = 5.0;
        aluno3prova1.NotaParte2 = 4.0;

        aluno3.prova1 = aluno3prova1;

        Prova aluno3prova2 = new Prova();
        aluno3prova2.NotaParte1 = 6.0;
        aluno3prova2.NotaParte2 = 1.5;

        aluno3.prova2 = aluno3prova2;

        //Média de cada aluno
        System.out.println("Media do Aluno 1 "+ turma1.aluno1.CalcularMedia());
        System.out.println("Media do Aluno 2 "+ turma1.aluno2.CalcularMedia());
        System.out.println("Media do Aluno 3 "+ turma1.aluno3.CalcularMedia());
        //Média da turma
        System.out.println("Média de turma é "+turma1.CalcularMedia());
        }
    }