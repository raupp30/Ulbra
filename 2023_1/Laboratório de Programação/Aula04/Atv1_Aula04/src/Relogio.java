public class Relogio {
    private Ponteiro ponteiroHora;
    private Ponteiro ponteiroMinuto;
    private Ponteiro ponteiroSegundo;

    public Relogio() {
        this.ponteiroHora = new Ponteiro();
        this.ponteiroMinuto = new Ponteiro();
        this.ponteiroSegundo = new Ponteiro();
    }

    public void acertarRelogio(int hora, int minuto, int segundo) {
        this.ponteiroHora.setPosicao(hora);
        this.ponteiroMinuto.setPosicao(minuto);
        this.ponteiroSegundo.setPosicao(segundo);
    }

    public int lerHora() {
        return this.ponteiroHora.getPosicao();
    }

    public int lerMinuto() {
        return this.ponteiroMinuto.getPosicao();
    }

    public int lerSegundo() {
        return this.ponteiroSegundo.getPosicao();
    }
}
