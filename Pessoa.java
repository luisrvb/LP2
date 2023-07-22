import java.util.List;
import java.util.Map;
import java.util.HashMap;

/**
 * Escreva uma descrição da classe Pessoa aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */

abstract class Pessoa {
    private String nome;
    private String telefone;
    private String email;

    public Pessoa(String nome, String telefone, String email) {
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

    // UN3 - Mapa para associar os tipos de Pessoa com suas implementações
    private static final Map<Class<? extends Pessoa>, String> tipoPessoaMap = new HashMap<>();

    // UN3 - Método para registrar os tipos de Pessoa e suas implementações
    public static void registrarTipoPessoa(Class<? extends Pessoa> tipoPessoa, String descricao) {
        tipoPessoaMap.put(tipoPessoa, descricao);
    }

    // UN3 - Método para obter a descrição do tipo de Pessoa
    public static String getDescricaoTipoPessoa(Class<? extends Pessoa> tipoPessoa) {
        return tipoPessoaMap.get(tipoPessoa);
    }

    public abstract void validarDados() throws Exception;

    // Common data validation logic for all subclasses
    protected void validarDadosComuns() throws Exception {
        if (getNome().isEmpty()) {
            throw new Exception("O nome não pode estar vazio.");
        }

        if (!getTelefone().matches("\\d{11}")) {
            throw new Exception("Número de telefone inválido. Insira apenas os números do telefone (11 dígitos).");
        }

        if (!getEmail().matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
            throw new Exception("Email inválido. Insira um email válido no formato 'usuario@dominio.com'.");
        }
    }
}