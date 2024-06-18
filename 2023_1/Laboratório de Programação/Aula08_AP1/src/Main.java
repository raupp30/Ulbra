public class Main {
    public static void main(String[] args){
        Estudante estudante1 = new Estudante();
        Estudante estudante2 = new Estudante();
        Estudante estudante3 = new Estudante();
        Estudante estudante4 = new Estudante();

        estudante1.setNome("Joãozinho");
        estudante1.setIdade(18);
        estudante1.setPontos(1350);

        estudante2.setNome("Pedrinho");
        estudante2.setIdade(17);
        estudante2.setPontos(1120);

        estudante3.setNome("Luquinhas");
        estudante3.setIdade(15);
        estudante3.setPontos(970);

        estudante4.setNome("Rodriguinho");
        estudante4.setIdade(14);
        estudante4.setPontos(1229);

        Gincana gincana1 = new Gincana();
        gincana1.setNomeGincana("Gincana de São João");
        gincana1.setTotalEstudantes(4);
        gincana1.setPontuacaoMaxima(1500);
        gincana1.adicionarEstudante(estudante1);
        gincana1.adicionarEstudante(estudante2);
        gincana1.adicionarEstudante(estudante3);
        gincana1.adicionarEstudante(estudante4);
        gincana1.exibirVencedor();
    }
}