public class Gerente extends Funcionario{
    @Override
    public void calcularSalario(){
        System.out.println("Calculando salário do gerente");
    }
    @Override
    public void realizarTask(){
        System.out.println("Gerente realizando task");
    }
}
