

public class Main {
    public static void main(String[] args) {
        // 1. Sistema de Atendimento
        SistemaAtendimento atendimento = new SistemaAtendimento();
        atendimento.adicionarAtendimento("Cliente 1");
        atendimento.adicionarAtendimento("Cliente 2");
        atendimento.processarAtendimento();
        atendimento.exibirFila();

        // 2. Editor de Texto
        EditorTexto editor = new EditorTexto();
        editor.realizarAcao("Escrever texto");
        editor.desfazerAcao();
        editor.refazerAcao();
        editor.exibirHistorico();

        // 3. Gestão de Rotas
        GestaoRotas rotas = new GestaoRotas();
        rotas.adicionarConexao("A", "B");
        rotas.adicionarConexao("B", "C");
        System.out.println(rotas.existeCaminho("A", "C"));
        rotas.exibirGrafo();

        // 4. Catálogo de Produtos
        CatalogoProdutos catalogo = new CatalogoProdutos();
        catalogo.adicionarProduto("001", "Produto A");
        System.out.println(catalogo.buscarProduto("001"));
        catalogo.exibirProdutos();

        // 5. Agendamento de Consultas
        AgendamentoConsultas agendamento = new AgendamentoConsultas();
        agendamento.adicionarHorario(10);
        agendamento.adicionarHorario(14);
        agendamento.agendarConsulta();
        agendamento.exibirHorarios();

        // 6. Controle de Pontuação
        ControlePontuacao pontuacao = new ControlePontuacao();
        pontuacao.adicionarJogador("Jogador1");
        pontuacao.atualizarPontuacao("Jogador1", 50);
        System.out.println(pontuacao.jogadorComMaiorPontuacao());
        pontuacao.exibirPontuacoes();

        // 7. Árvore Genealógica
        ArvoreGenealogica arvore = new ArvoreGenealogica();
        arvore.adicionarRaiz("Avô");
        arvore.adicionarFilho("Avô", "Pai");
        arvore.adicionarFilho("Pai", "Filho");
        arvore.exibirArvore();

        // 8. Sistema de Recomendação
        SistemaRecomendacao recomendacao = new SistemaRecomendacao();
        recomendacao.adicionarUsuario("User1");
        recomendacao.registrarVisualizacao("User1", "Filme1");
        recomendacao.exibirHistorico("User1");

        // 9. Jogo de Tabuleiro
        JogoTabuleiro jogo = new JogoTabuleiro(3, 3);
        jogo.fazerMovimento(0, 0, "X");
        jogo.exibirTabuleiro();
    }
}
