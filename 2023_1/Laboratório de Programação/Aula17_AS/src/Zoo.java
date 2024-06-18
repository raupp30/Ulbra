// Classe Zoo
class Zoo {
    private Animal[] animais;
    private Funcionario[] funcionarios;
    private int numAnimais;
    private int numFuncionarios;

    public Zoo(int numAnimais, int numFuncionarios) {
        this.animais = new Animal[numAnimais];
        this.funcionarios = new Funcionario[numFuncionarios];
        this.numAnimais = 0;
        this.numFuncionarios = 0;
    }

    public void adicionarAnimal(Animal animal) {
        if (numAnimais < animais.length) {
            animais[numAnimais] = animal;
            numAnimais++;
            System.out.println("Animal adicionado ao zoo: " + animal.getNome());
        } else {
            System.out.println("Não é possível adicionar mais animais ao zoo.");
        }
    }

    public void adicionarFuncionario(Funcionario funcionario) {
        if (numFuncionarios < funcionarios.length) {
            funcionarios[numFuncionarios] = funcionario;
            numFuncionarios++;
            System.out.println("Funcionário adicionado ao zoo: " + funcionario.getNome());
        } else {
            System.out.println("Não é possível adicionar mais funcionários ao zoo.");
        }
    }
}
