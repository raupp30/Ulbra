import java.util.ArrayList;

public class Tabuleiro {
    private Casa inicio;
    private ArrayList<Casa> casas;

    public Tabuleiro() {
        casas = new ArrayList<>();
    }

    public void addCasa(Casa novaCasa) {
        if (inicio == null) {
            inicio = novaCasa;
            inicio.setProxima(inicio); // faz o tabuleiro circular
        } else {
            Casa atual = inicio;
            while (atual.getProxima() != inicio) {
                atual = atual.getProxima();
            }
            atual.setProxima(novaCasa);
            novaCasa.setProxima(inicio);
        }
        casas.add(novaCasa);
    }

    public ArrayList<Casa> getCasas() {
        return casas;
    }

    public Casa getInicio() {
        return inicio;
    }

    public void listarCasas() {
        for (Casa casa : casas) {
            System.out.println(casa.getNome() + " (" + casa.getTipo() + ")");
        }
    }

    public void removerCasa(Casa casa) {
        casas.remove(casa);
    }
}
