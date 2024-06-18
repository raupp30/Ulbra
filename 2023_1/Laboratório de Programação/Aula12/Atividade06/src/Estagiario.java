public class Estagiario extends Funcionario{
    @Override
    public void calcularSalario(){
        System.out.println("Calculando bolsa estágio do estagiario");
    }
    @Override
    public void realizarTask(){
        System.out.println("Estagiario realizando task");
    }
}
