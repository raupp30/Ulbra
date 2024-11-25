import java.util.Stack;

public class EditorTexto {
    private Stack<String> desfazer;
    private Stack<String> refazer;

    public EditorTexto() {
        desfazer = new Stack<>();
        refazer = new Stack<>();
    }

    public void realizarAcao(String acao) {
        desfazer.push(acao);
        refazer.clear();
        System.out.println("Ação realizada: " + acao);
    }

    public void desfazerAcao() {
        if (!desfazer.isEmpty()) {
            String acao = desfazer.pop();
            refazer.push(acao);
            System.out.println("Ação desfeita: " + acao);
        } else {
            System.out.println("Nada para desfazer.");
        }
    }

    public void refazerAcao() {
        if (!refazer.isEmpty()) {
            String acao = refazer.pop();
            desfazer.push(acao);
            System.out.println("Ação refeita: " + acao);
        } else {
            System.out.println("Nada para refazer.");
        }
    }

    public void exibirHistorico() {
        System.out.println("Histórico de ações: " + desfazer);
    }
}