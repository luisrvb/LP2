import java.util.Date;


/**
 * Escreva uma descrição da classe Usuario aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */

class Usuario extends PessoaFisica {
    private String cpf;
    private Date dataNascimento;

    public Usuario(String nome, String telefone, String email, String cpf, Date dataNascimento) {
        super(nome, telefone, email);
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }
}
