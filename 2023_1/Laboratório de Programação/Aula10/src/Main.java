public class Main {
    public static void main(String[] args){
        Equipe equipe1 = new Equipe("Equipe One", 0, 0 ,0, 0);
        Equipe equipe2 = new Equipe("Equipe Two", 0, 0, 0 , 0);

        //registrando vitorias/derrotas/empates
        equipe1.registrarVitoria(130);
        equipe1.registrarEmpate(95);
        equipe2.registrarDerrota(56);
        equipe2.registrarEmpate(88);
        //printando nome da equipe, vitorias/derrotas/empates


        equipe1.exibirInfo();
        System.out.println("-------------------------------------------");
        equipe2.exibirInfo();
    }
}