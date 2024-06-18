public class Vendedor extends Funcionario{
    @Override
    public void calcularSalario(){
        System.out.println("Calculando comissão e salário do vendedor");
    }
    @Override
    public void realizarTask(){
        System.out.println("Vendedor realizando task");
    }
}
