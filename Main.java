import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.text.SimpleDateFormat;
import java.util.*;
import java.text.ParseException;

/**
 * Escreva uma descrição da classe Main aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */


public class Main extends JFrame {
    private List<Usuario> usuarios;
    private List<Atendimento> atendimentos;
    private SimpleDateFormat dateFormat;
    private JDesktopPane desktopPane;
    private JComboBox<String> usuariosComboBox;

    public Main() {
        usuarios = new ArrayList<>();
        atendimentos = new ArrayList<>();
        dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        // Configurações básicas da janela principal
        setTitle("Sistema de Atendimento Contábil");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        // Criação do desktopPane para suportar MDI
        desktopPane = new JDesktopPane();
        setContentPane(desktopPane);

        // Criação do menu
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        // Menu Cadastro
        JMenu cadastroMenu = new JMenu("Cadastro");
        menuBar.add(cadastroMenu);

        JMenuItem cadastrarProfessorItem = new JMenuItem("Cadastrar Professor");
        JMenuItem cadastrarEstudanteItem = new JMenuItem("Cadastrar Estudante");
        JMenuItem cadastrarUsuarioItem = new JMenuItem("Cadastrar Usuário");
        cadastroMenu.add(cadastrarProfessorItem);
        cadastroMenu.add(cadastrarEstudanteItem);
        cadastroMenu.add(cadastrarUsuarioItem);

        // Ação do menu para cadastrar professor
        cadastrarProfessorItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarProfessor();
            }
        });

        // Ação do menu para cadastrar estudante
        cadastrarEstudanteItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarEstudante();
            }
        });

        // Ação do menu para cadastrar usuário
        cadastrarUsuarioItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarUsuario();
            }
        });

        // Menu Atendimento
        JMenu atendimentoMenu = new JMenu("Atendimento");
        menuBar.add(atendimentoMenu);

        JMenuItem cadastrarAtendimentoItem = new JMenuItem("Cadastrar Atendimento");
        JMenuItem relatorioAtendimentosItem = new JMenuItem("Relatório de Atendimentos");
        atendimentoMenu.add(cadastrarAtendimentoItem);
        atendimentoMenu.add(relatorioAtendimentosItem);

        // Ação do menu para cadastrar atendimento
        cadastrarAtendimentoItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
                    @Override
                    protected Void doInBackground() throws Exception {
                        cadastrarAtendimento();
                        return null;
                    }
                };
                worker.execute();
            }
        });

        // Ação do menu para exibir o relatório de atendimentos
        relatorioAtendimentosItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exibirRelatorioAtendimentos();
            }
        });

        // Inicializar o ComboBox de usuários disponíveis para atendimento
        usuariosComboBox = new JComboBox<>();
        usuariosComboBox.addItem("Selecione um Usuário");
        for (Usuario usuario : usuarios) {
            usuariosComboBox.addItem(usuario.getNome());
        }

        // Add usuariosComboBox to the frame
        JPanel comboBoxPanel = new JPanel();
        comboBoxPanel.add(usuariosComboBox);
        getContentPane().add(comboBoxPanel, BorderLayout.NORTH);
    }

 
    private void cadastrarUsuario() {
        String nome;
        String telefone;
        String email;
        String cpf;
        Date dataNascimento;
    
        do {
            nome = JOptionPane.showInputDialog(desktopPane, "Digite o nome do usuário:");
            if (nome == null) {
                return; // Cancela input
            }
    
            telefone = JOptionPane.showInputDialog(desktopPane, "Digite o telefone do usuário:");
            if (telefone == null) {
                return; // Cancela input
            }
    
            email = JOptionPane.showInputDialog(desktopPane, "Digite o email do usuário:");
            if (email == null) {
                return; // Cancela input
            }
    
            cpf = JOptionPane.showInputDialog(desktopPane, "Digite o CPF do usuário (formato XXX.XXX.XXX-XX):");
            if (cpf == null) {
                return; // Cancela input
            }
    
            String dataNascimentoStr = JOptionPane.showInputDialog(desktopPane, "Digite a data de nascimento do usuário (formato dd/MM/yyyy):");
            if (dataNascimentoStr == null) {
                return; // Cancela input
            }
    
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                dataNascimento = dateFormat.parse(dataNascimentoStr);
            } catch (ParseException e) {
                JOptionPane.showMessageDialog(desktopPane, "Data de nascimento inválida. Insira a data no formato dd/MM/yyyy. Por favor, repita a última entrada.", "Erro", JOptionPane.ERROR_MESSAGE);
                continue; // Restart the loop to re-enter the data
            }
    
            Usuario novoUsuario = new Usuario(nome, telefone, email, cpf, dataNascimento);
            try {
                novoUsuario.validarDados();
    
                if (!usuarios.contains(novoUsuario)) {
                    usuarios.add(novoUsuario); //Novo usuário a lista
                    // Atualiza usuários disponíveis
                    usuariosComboBox.addItem(novoUsuario.getNome());
                    break; // End the loop when all data is valid
                } else {
                    JOptionPane.showMessageDialog(desktopPane, "Usuário já cadastrado.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(desktopPane, "Erro: " + e.getMessage() + " Por favor, repita a última entrada.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } while (true);
    }
    
    private void cadastrarProfessor() {
        String nome;
        String telefone;
        String email;
    
        do {
            nome = JOptionPane.showInputDialog(desktopPane, "Digite o nome do professor:");
            if (nome == null) {
                return; // Cancelamento do input
            }
    
            telefone = JOptionPane.showInputDialog(desktopPane, "Digite o telefone do professor:");
            if (telefone == null) {
                return; // Cancelamento do input
            }
    
            email = JOptionPane.showInputDialog(desktopPane, "Digite o email do professor:");
            if (email == null) {
                return; // Cancelamento do input
            }
    
            Professor professor = new Professor(nome, telefone, email);
            try {
                professor.validarDados();
                // Registrar professor
                // Salva professor na lista
                break; // Sai do loop em entrada válida
            } catch (Exception e) {
                JOptionPane.showMessageDialog(desktopPane, "Erro: " + e.getMessage() + " Por favor, repita a última entrada.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } while (true);
    }
    
    private void cadastrarEstudante() {
        String nome;
        String telefone;
        String email;
        String matricula;
    
        do {
            nome = JOptionPane.showInputDialog(desktopPane, "Digite o nome do estudante:");
            if (nome == null) {
                return; // Cancelamento do input
            }
    
            telefone = JOptionPane.showInputDialog(desktopPane, "Digite o telefone do estudante:");
            if (telefone == null) {
                return; // Cancelamento do input
            }
    
            email = JOptionPane.showInputDialog(desktopPane, "Digite o email do estudante:");
            if (email == null) {
                return; // Cancelamento do input
            }
    
            matricula = JOptionPane.showInputDialog(desktopPane, "Digite a matrícula do estudante:");
            if (matricula == null) {
                return; // Cancelamento do input
            }
    
            Estudante estudante = new Estudante(nome, telefone, email, matricula, new ArrayList<>(), new ArrayList<>());
            try {
                estudante.validarDados();
                // Salva estudante na lista
                break; // Sai do loop em entrada válida
            } catch (Exception e) {
                JOptionPane.showMessageDialog(desktopPane, "Erro: " + e.getMessage() + " Por favor, repita a última entrada.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } while (true);
    }


    private void cadastrarAtendimento() {
        if (usuarios.isEmpty()) {
            JOptionPane.showMessageDialog(desktopPane, "Não há usuários cadastrados para realizar atendimentos.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Cria um menu com nomes de usuarios
        String[] usuariosNomes = usuarios.stream().map(Usuario::getNome).toArray(String[]::new);
        String nomeUsuarioSelecionado = (String) JOptionPane.showInputDialog(
                desktopPane,
                "Selecione o Usuário:",
                "Cadastrar Atendimento",
                JOptionPane.PLAIN_MESSAGE,
                null,
                usuariosNomes,
                usuariosNomes[0]);

        // Se nenhum usuario for selecionado, retorna
        if (nomeUsuarioSelecionado == null) {
            return;
        }

        // Procura o usuario selecionado em uma lista
        Usuario usuarioAtendimento = usuarios.stream()
                .filter(u -> u.getNome().equals(nomeUsuarioSelecionado))
                .findFirst()
                .orElse(null);

        if (usuarioAtendimento == null) {
            JOptionPane.showMessageDialog(desktopPane, "Usuário não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String guicheStr = JOptionPane.showInputDialog(desktopPane, "Digite o número do Guichê:");
        int guicheAtendimento = 0;
        try {
            guicheAtendimento = Integer.parseInt(guicheStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(desktopPane, "Número de guichê inválido. Insira um número inteiro.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Cria lista para tipo de atendimento

        String[] tiposAtendimento = { "IRPF", "Retificações", "Dúvidas" };
        String tipoAtendimentoSelecionado = (String) JOptionPane.showInputDialog(
                desktopPane,
                "Selecione o Tipo de Atendimento:",
                "Cadastrar Atendimento",
                JOptionPane.PLAIN_MESSAGE,
                null,
                tiposAtendimento,
                tiposAtendimento[0]);

        // Se nenhum atendimento for selecionado, volta
        if (tipoAtendimentoSelecionado == null) {
            return;
        }

        Date dataHoraAtendimento = new Date(); // Usa a data atual

        Atendimento novoAtendimento = new Atendimento(usuarioAtendimento, guicheAtendimento, tipoAtendimentoSelecionado, dataHoraAtendimento);
        atendimentos.add(novoAtendimento);
        }

    private void exibirRelatorioAtendimentos() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        StringBuilder relatorio = new StringBuilder();
        relatorio.append("== Relatório de Atendimentos ==\n\n");
        for (Atendimento atendimento : atendimentos) {
            relatorio.append("Usuário: ").append(atendimento.getUsuario().getNome()).append("\n");
            relatorio.append("Guichê: ").append(atendimento.getGuiche()).append("\n");
            relatorio.append("Tipo de Atendimento: ").append(atendimento.getTipoAtendimento()).append("\n");
            relatorio.append("Data/Hora: ").append(formatter.format(atendimento.getDataHora())).append("\n\n");
        }
        JOptionPane.showMessageDialog(desktopPane, relatorio.toString(), "Relatório de Atendimentos", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main().setVisible(true);
            }
        });
    }
}





