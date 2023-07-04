import java.util.List;
import java.util.ArrayList;

/**
 * Escreva uma descrição da classe Professor aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */

class Professor extends PessoaFisica {
    private List<String> diasAtendimento;

    public Professor(String nome, String telefone, String email) {
        super(nome, telefone, email);
        diasAtendimento = new ArrayList<>();
    }

    public void adicionarDiaAtendimento(String dia) {
        diasAtendimento.add(dia);
    }

    public List<String> getDiasAtendimento() {
        return diasAtendimento;
    }
}
