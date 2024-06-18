// Subclasse de Animal: Ave
class Ave extends Animal implements Treinavel {
    private double envergaduraAsa;

    public Ave(String nome, int idade, double peso, String especie, double envergaduraAsa) {
        super(nome, idade, peso, especie);
        this.envergaduraAsa = envergaduraAsa;
    }

    public void voar() {
        System.out.println("A ave " + getNome() + " está voando.");
    }

    @Override
    public void realizarTruque() {
        System.out.println("A ave " + getNome() + " realizou um truque voador.");
    }
}