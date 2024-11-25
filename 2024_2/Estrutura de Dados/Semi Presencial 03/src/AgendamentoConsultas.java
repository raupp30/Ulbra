

import java.util.TreeSet;

public class AgendamentoConsultas {
    private TreeSet<Integer> horariosDisponiveis;

    public AgendamentoConsultas() {
        horariosDisponiveis = new TreeSet<>();
    }

    public void adicionarHorario(int horario) {
        horariosDisponiveis.add(horario);
    }

    public Integer agendarConsulta() {
        Integer proximoHorario = horariosDisponiveis.pollFirst();
        if (proximoHorario != null) {
            System.out.println("Consulta agendada para: " + proximoHorario);
        } else {
            System.out.println("Nenhum horário disponível.");
        }
        return proximoHorario;
    }

    public void exibirHorarios() {
        System.out.println("Horários disponíveis: " + horariosDisponiveis);
    }
}
