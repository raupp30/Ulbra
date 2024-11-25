public class Tabuleiro {

    private Casa inicio;

    public void addCasa(Casa novaCasa){
        if (inicio == null){
            inicio = novaCasa;
            inicio.setProxima(inicio); // faz o tabuleiro circular
        }else{
            Casa atual = inicio;
            while (atual.getProxima() != inicio){
                atual = atual.getProxima();
            }
            atual.setProxima(novaCasa);
            novaCasa.setProxima(inicio);
        }
    }

    public Casa getInicio (){
        return inicio;
    }
}
