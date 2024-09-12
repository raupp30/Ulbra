public class Main {
    public static void main(String[] args) {
        Funcionario func1 = new Funcionario("Franciso", 5000);
        Funcionario func2 = new Funcionario("Alberto", 6000);
        Funcionario func3 = new Funcionario("Zilda", 7000);
        Funcionario[] funcionarios = {func1, func2, func3};
        System.out.println("----------Alfabetica-----------");
        BubbleFuncionario.ordemAlfabetica(funcionarios);
        System.out.println(funcionarios[0]);
        System.out.println(funcionarios[1]);
        System.out.println(funcionarios[2]);
        System.out.println("------------Crescente---------");
        BubbleFuncionario.ordemCrescente(funcionarios);
        System.out.println(funcionarios[0]);
        System.out.println(funcionarios[1]);
        System.out.println(funcionarios[2]);
        System.out.println("-----------Decrescente----------");
        BubbleFuncionario.ordemDecrescente(funcionarios);
        System.out.println(funcionarios[0]);
        System.out.println(funcionarios[1]);
        System.out.println(funcionarios[2]);
    }
}