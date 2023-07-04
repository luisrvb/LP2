import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

/**
 * Escreva uma descrição da classe Main aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */

public class Main {
    public static void main(String[] args) throws ParseException {
        List<Usuario> usuarios = new ArrayList<>();
        List<Atendimento> atendimentos = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Scanner scanner = new Scanner(System.in);

        int opcao;
        do {
            System.out.println("== Menu ==");
            System.out.println("1. Cadastrar Professor");
            System.out.println("2. Cadastrar Estudante");
            System.out.println("3. Cadastrar Usuário");
            System.out.println("4. Cadastrar Atendimento");
            System.out.println("5. Relatório de Atendimentos");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha pendente

            switch (opcao) {
                case 1:
                    System.out.println("== Cadastro de Professor ==");
                    System.out.print("Nome: ");
                    String nomeProfessor = scanner.nextLine();
                    System.out.print("Telefone: ");
                    String telefoneProfessor = scanner.nextLine();
                    System.out.print("Email: ");
                    String emailProfessor = scanner.nextLine();
                    Professor professor = new Professor(nomeProfessor, telefoneProfessor, emailProfessor);
                    // código para cadastrar professor
                    break;
                case 2:
                    System.out.println("== Cadastro de Estudante ==");
                    System.out.print("Nome: ");
                    String nomeEstudante = scanner.nextLine();
                    System.out.print("Telefone: ");
                    String telefoneEstudante = scanner.nextLine();
                    System.out.print("Email: ");
                    String emailEstudante = scanner.nextLine();
                    System.out.print("Matrícula: ");
                    String matriculaEstudante = scanner.nextLine();
                    // código para cadastrar estudante
                    break;
                case 3:
                    System.out.println("== Cadastro de Usuário ==");
                    System.out.print("Nome: ");
                    String nomeNovoUsuario = scanner.nextLine();
                    System.out.print("Telefone: ");
                    String telefoneNovoUsuario = scanner.nextLine();
                    System.out.print("Email: ");
                    String emailNovoUsuario = scanner.nextLine();
                    System.out.print("CPF: ");
                    String cpfNovoUsuario = scanner.nextLine();
                    System.out.print("Data de Nascimento (dd/MM/yyyy): ");
                    Date dataNascimento = dateFormat.parse(scanner.nextLine());
                    Usuario novoUsuario = new Usuario(nomeNovoUsuario, telefoneNovoUsuario, emailNovoUsuario, cpfNovoUsuario, dataNascimento);
                    usuarios.add(novoUsuario); // Adiciona o novo usuário à lista de usuários
                    break;
                case 4:
                    System.out.println("== Cadastro de Atendimento ==");
                    System.out.print("CPF do Usuário: ");
                    String cpfAtendimento = scanner.nextLine();
                    // Código para buscar o usuário pelo CPF
                    Usuario usuarioAtendimento = null;
                    for (Usuario usuario : usuarios) {
                        if (usuario.getCpf().equals(cpfAtendimento)) {
                            usuarioAtendimento = usuario;
                            break;
                        }
                    }
                    if (usuarioAtendimento == null) {
                        System.out.println("Usuário não encontrado.");
                        break;
                    }
                    System.out.print("Guichê: ");
                    int guicheAtendimento = scanner.nextInt();
                    scanner.nextLine(); // Consumir a quebra de linha pendente
                    System.out.print("Tipo de Atendimento (IRPF, Retificações, Dúvidas): ");
                    String tipoAtendimento = scanner.nextLine();
                    Date dataHoraAtendimento = new Date(); // Usar a data e hora atual
                    Atendimento novoAtendimento = new Atendimento(usuarioAtendimento, guicheAtendimento, tipoAtendimento, dataHoraAtendimento);
                    atendimentos.add(novoAtendimento); // Adiciona o novo atendimento à lista de atendimentos
                    break;
                case 5:
                    System.out.println("== Relatório de Atendimentos ==");
                    // Código para exibir o relatório de atendimentos
                    for (Atendimento atendimento : atendimentos) {
                        System.out.println("Usuário: " + atendimento.getUsuario().getNome());
                        System.out.println("Guichê: " + atendimento.getGuiche());
                        System.out.println("Tipo de Atendimento: " + atendimento.getTipoAtendimento());
                        System.out.println("Data/Hora: " + atendimento.getDataHora());
                        System.out.println();
                    }
                    break;
                case 0:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
            System.out.println();
        } while (opcao != 0);
    }
}
