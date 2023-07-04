import java.util.List;

/**
 * Escreva uma descrição da classe PessoaFisicaFisica aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */

abstract class PessoaFisica {
    private String nome;
    private String telefone;
    private String email;

    public PessoaFisica(String nome, String telefone, String email) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }
}