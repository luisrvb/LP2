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

    public abstract void validarDados() throws Exception;

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
}