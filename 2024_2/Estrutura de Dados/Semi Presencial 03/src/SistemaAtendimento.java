import java.util.LinkedList;
import java.util.Queue;

public class SistemaAtendimento {
    private Queue<String> filaAtendimento;

    public SistemaAtendimento() {
        filaAtendimento = new LinkedList<>();
    }

    public void adicionarAtendimento(String atendimento) {
        filaAtendimento.add(atendimento);
        System.out.println("Atendimento adicionado: " + atendimento);
    }

    public String processarAtendimento() {
        if (!filaAtendimento.isEmpty()) {
            String atendimento = filaAtendimento.poll();
            System.out.println("Processando atendimento: " + atendimento);
            return atendimento;
        } else {
            System.out.println("Nenhum atendimento na fila.");
            return null;
        }
    }

    public void exibirFila() {
        System.out.println("Fila de Atendimento: " + filaAtendimento);
    }
}