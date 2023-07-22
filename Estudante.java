import java.util.List;

/**
 * Escreva uma descrição da classe Estudante aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */

class Estudante extends Pessoa {
    private String matricula;
    private List<String> diasDisponiveis;
    private List<String> horariosDisponiveis;

    public Estudante(String nome, String telefone, String email, String matricula, List<String> diasDisponiveis, List<String> horariosDisponiveis) {
        super(nome, telefone, email);
        this.matricula = matricula;
        this.diasDisponiveis = diasDisponiveis;
        this.horariosDisponiveis = horariosDisponiveis;
    }

    public String getMatricula() {
        return matricula;
    }

    public List<String> getDiasDisponiveis() {
        return diasDisponiveis;
    }

    public List<String> getHorariosDisponiveis() {
        return horariosDisponiveis;
    }

    @Override
    public void validarDados() throws Exception {
        validarDadosComuns();
    }
    
}
