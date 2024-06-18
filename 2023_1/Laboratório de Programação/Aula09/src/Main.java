public class Main {
public static void main(String[]args){
    Cachorro cachorro1 = new Cachorro("AuAu", "Pitbull", 20);

    System.out.println("O nome é do cachorro é: " +cachorro1.getNome());
    System.out.println("A idade do cachorro é: " +cachorro1.getIdade());
    System.out.println("A raça do cachorro é: " +cachorro1.getRaca());

    Livro livro1 = new Livro("Naosei", "Joao Vitor", 9);

    System.out.println("O nome do livro é " +livro1.titulo);
    System.out.println("O autor do livro é " +livro1.autor);
    System.out.println("O valor do livro é " +livro1.preco);

    Estudante estudante1 = new Estudante("Joãozinho", "AAABBBCCC", "ADS");

    System.out.println("O nome do aluno é " +estudante1.nome);
    System.out.println("A matricula do " +estudante1.nome +" é a " +estudante1.matricula);
    System.out.println("O curso do " +estudante1.nome +" é " +estudante1.curso);
}
}