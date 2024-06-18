public class Veiculo {
    String marca;
    String modelo;
    int ano;
    private boolean ligado;

    public Veiculo(String marca, String modelo, int ano){
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.ligado = false; // o veículo começa desligado né kkk
    }

    public void ligar(){
        if (!ligado){
            ligado = true;
            System.out.println("Veículo está ligado");
        }else {
            System.out.println("Veículo já está ligado");
        }
    }

    public void desligar(){
        if (ligado){
            ligado = false;
            System.out.println("Veículo está ligado desligado");
        }else{
            System.out.println("Veículo ja está desligado");
        }
    }
}
