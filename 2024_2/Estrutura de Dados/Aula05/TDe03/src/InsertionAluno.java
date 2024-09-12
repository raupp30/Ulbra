public class InsertionAluno {
    public static void insertionSortPorMedia (Aluno[] alunos){
        int n = alunos.length;
        for (int i = 1; i < n; i++) {
            Aluno chave = alunos[i];
            int j = i -1;
            while (j >= 0 && alunos[j].getMedia() > chave.getMedia()){
                alunos [j+1] = alunos[j];
                j = j -1;
            }
            alunos [j+1] = chave;
        }
    }

    public static void insertionSortPorNome (Aluno[] alunos){
        int n = alunos.length;
        for (int i = 1; i < n; i++){
            Aluno chave = alunos[i];
            int j = i -1;

            while (j >= 0 && alunos[j].nome.compareTo(chave.nome) > 0){
                alunos[j+1] = alunos[j];
                j = j -1;
            }
            alunos[j + 1] = chave;
        }
    }
}
