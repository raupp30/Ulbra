public class Main {
    public static void main(String[] args) {
        Funcionario funcionario;

        funcionario = new Gerente();
        funcionario.calcularSalario();
        funcionario.realizarTask();
        System.out.println("-----------");
        funcionario = new Vendedor();
        funcionario.calcularSalario();
        funcionario.realizarTask();
        System.out.println("-----------");
        funcionario = new Estagiario();
        funcionario.calcularSalario();
        funcionario.realizarTask();
    }
}