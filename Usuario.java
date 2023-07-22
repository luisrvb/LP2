import java.text.SimpleDateFormat;
import java.util.*;
import java.time.format.DateTimeFormatter;


/**
 * Escreva uma descrição da classe Usuario aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */

class Usuario extends Pessoa {
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

    @Override
    public void validarDados() throws Exception {
        if (!cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")) {
            throw new Exception("CPF inválido. Insira o CPF no formato XXX.XXX.XXX-XX.");
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String formattedDate = dateFormat.format(dataNascimento);

        if (!formattedDate.matches("\\d{2}/\\d{2}/\\d{4}")) {
            throw new Exception("Data de nascimento inválida. Insira a data no formato dd/MM/yyyy.");
        }

        if (!getTelefone().matches("\\d{11}")) {
            throw new Exception("Número de telefone inválido. Insira apenas os números do telefone (11 dígitos).");
        }
    }
}
