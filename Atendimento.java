import java.util.Date;
import java.time.LocalDateTime;

/**
 * Escreva uma descrição da classe Atendimento aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */

class Atendimento implements AtendimentoContabil {
    private Usuario usuario;
    private int guiche;
    private String tipoAtendimento;
    private Date dataHora;

    public Atendimento(Usuario usuario, int guiche, String tipoAtendimento, Date dataHora) {
        this.usuario = usuario;
        this.guiche = guiche;
        this.tipoAtendimento = tipoAtendimento;
        this.dataHora = dataHora;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public int getGuiche() {
        return guiche;
    }

    public String getTipoAtendimento() {
        return tipoAtendimento;
    }

    public Date getDataHora() {
        return dataHora;
    }

    @Override
    public void realizarAtendimento() {
        System.out.println("Realizando atendimento...");
    }
}

