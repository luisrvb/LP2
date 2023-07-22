import java.util.List;
import java.util.ArrayList;

/**
 * Escreva uma descrição da classe Professor aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */

class Professor extends Pessoa {
    private List<Estudante> estudantes;

    public Professor(String nome, String telefone, String email) {
        super(nome, telefone, email);
    }

    @Override
    public void validarDados() throws Exception {
        validarDadosComuns();
    }
}