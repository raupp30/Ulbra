public class Main {
    public static void main(String[] args) {
        Relogio relogio = new Relogio();
        relogio.acertarRelogio(14, 25, 35);
        System.out.println("Hora: " + relogio.lerHora() + " Minuto: " + relogio.lerMinuto() + " Segundo: " + relogio.lerSegundo());
    }
}