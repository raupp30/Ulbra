public class Estudante extends Pessoa {
    public void Estudar(){
        System.out.println("Estudante estudando");
    }
    @Override
    public void Andar() {
        System.out.println("Estudante andando");
    }
    @Override
    public void Falar(){
        System.out.println("Estudante falando");
    }
}

