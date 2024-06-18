// Classe Main
public class Main {
    public static void main(String[] args) {
        // Criação de objetos
        Animal animal1 = new Animal("Leão", 5, 200.0, "Mamífero");
        Veterinario veterinario1 = new Veterinario("João", "Veterinário", 5000.0, "Felinos");
        Mamifero mamifero1 = new Mamifero("Elefante", 10, 5000.0, "Mamífero", "Pele grossa");
        Ave ave1 = new Ave("Papagaio", 3, 0.5, "Ave", 0.8);
        Zoo zoo = new Zoo(10, 5);

        // Demonstração do uso de métodos e polimorfismo
        animal1.movimentar(); // Saída: O animal se moveu de uma maneira padrão.
        animal1.movimentar("Correndo"); // Saída: O animal se moveu de uma maneira específica: Correndo

        veterinario1.realizarExame(animal1); // Saída: O veterinário está realizando um exame no animal Leão

        mamifero1.amamentar(); // Saída: O mamífero Elefante está amamentando.

        ave1.voar(); // Saída: A ave Papagaio está voando.
        ave1.realizarTruque(); // Saída: A ave Papagaio realizou um truque voador.

        zoo.adicionarAnimal(animal1); // Saída: Animal adicionado ao zoo: Leão
        zoo.adicionarAnimal(mamifero1); // Saída: Animal adicionado ao zoo: Elefante
        zoo.adicionarAnimal(ave1); // Saída: Animal adicionado ao zoo: Papagaio

        zoo.adicionarFuncionario(veterinario1); // Saída: Funcionário adicionado ao zoo: João
    }
}