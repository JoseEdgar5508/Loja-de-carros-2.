import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class LojaDeCarrosGUI extends JFrame {
    private final ArrayList<Carro> carros = new ArrayList<>();
    private final ArrayList<Cliente> clientes = new ArrayList<>();
    private final ArrayList<Venda> vendas = new ArrayList<>();

    public LojaDeCarrosGUI() {
        setTitle("Sistema da Loja de Carros");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JTabbedPane abas = new JTabbedPane();
        abas.add("Cadastro de Carros", criarAbaCarros());
        abas.add("Cadastro de Clientes", criarAbaClientes());
        abas.add("Registrar Venda", criarAbaVendas());
        abas.add("Consultas", criarAbaConsultas());

        add(abas);
        setVisible(true);
    }

    private JPanel criarAbaCarros() {
        JPanel painel = new JPanel(new GridLayout(5, 2));
        JTextField campoModelo = new JTextField();
        JTextField campoMarca = new JTextField();
        JTextField campoAno = new JTextField();
        JTextField campoPreco = new JTextField();
        JButton btnCadastrar = new JButton("Cadastrar");

        painel.add(new JLabel("Modelo:"));
        painel.add(campoModelo);
        painel.add(new JLabel("Marca:"));
        painel.add(campoMarca);
        painel.add(new JLabel("Ano:"));
        painel.add(campoAno);
        painel.add(new JLabel("Preço:"));
        painel.add(campoPreco);
        painel.add(btnCadastrar);

        btnCadastrar.addActionListener((ActionEvent e) -> {
            try {
                String modelo = campoModelo.getText();
                String marca = campoMarca.getText();
                int ano = Integer.parseInt(campoAno.getText());
                double preco = Double.parseDouble(campoPreco.getText());
                Carro carro = new Carro(modelo, marca, ano, preco);
                carros.add(carro);
                JOptionPane.showMessageDialog(this, "Carro cadastrado!");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Erro: verifique os dados.");
            }
        });

        return painel;
    }

    private JPanel criarAbaClientes() {
        JPanel painel = new JPanel(new GridLayout(4, 2));
        JTextField campoNome = new JTextField();
        JTextField campoTelefone = new JTextField();
        JTextField campoEmail = new JTextField();
        JButton btnCadastrar = new JButton("Cadastrar");

        painel.add(new JLabel("Nome:"));
        painel.add(campoNome);
        painel.add(new JLabel("Telefone:"));
        painel.add(campoTelefone);
        painel.add(new JLabel("Email:"));
        painel.add(campoEmail);
        painel.add(btnCadastrar);

        btnCadastrar.addActionListener((ActionEvent e) -> {
            String nome = campoNome.getText();
            String telefone = campoTelefone.getText();
            String email = campoEmail.getText();
            Cliente cliente = new Cliente(nome, telefone, email);
            clientes.add(cliente);
            JOptionPane.showMessageDialog(this, "Cliente cadastrado!");
        });

        return painel;
    }

    private JPanel criarAbaVendas() {
        JPanel painel = new JPanel(new GridLayout(5, 2));
        JTextField campoIndiceCarro = new JTextField();
        JTextField campoIndiceCliente = new JTextField();
        JTextField campoData = new JTextField();
        JTextField campoValor = new JTextField();
        JButton btnRegistrar = new JButton("Registrar Venda");

        painel.add(new JLabel("Índice do Carro:"));
        painel.add(campoIndiceCarro);
        painel.add(new JLabel("Índice do Cliente:"));
        painel.add(campoIndiceCliente);
        painel.add(new JLabel("Data da Venda:"));
        painel.add(campoData);
        painel.add(new JLabel("Valor:"));
        painel.add(campoValor);
        painel.add(btnRegistrar);

        btnRegistrar.addActionListener((ActionEvent e) -> {
            try {
                int idxCarro = Integer.parseInt(campoIndiceCarro.getText());
                int idxCliente = Integer.parseInt(campoIndiceCliente.getText());
                String data = campoData.getText();
                double valor = Double.parseDouble(campoValor.getText());

                if (idxCarro < 0 || idxCarro >= carros.size() || idxCliente < 0 || idxCliente >= clientes.size()) {
                    JOptionPane.showMessageDialog(this, "Índices inválidos.");
                    return;
                }

                Venda venda = new Venda(carros.get(idxCarro), clientes.get(idxCliente), data, valor);
                vendas.add(venda);
                JOptionPane.showMessageDialog(this, "Venda registrada!");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Erro: verifique os dados.");
            }
        });

        return painel;
    }

    private JPanel criarAbaConsultas() {
        JPanel painel = new JPanel();
        JButton btnVerCarros = new JButton("Ver Carros");
        JButton btnVerClientes = new JButton("Ver Clientes");
        JButton btnVerVendas = new JButton("Ver Vendas");

        btnVerCarros.addActionListener(e -> {
            StringBuilder sb = new StringBuilder("Lista de Carros:\n");
            for (int i = 0; i < carros.size(); i++) {
                sb.append(i).append(": ").append(carros.get(i)).append("\n");
            }
            JOptionPane.showMessageDialog(this, sb.toString());
        });

        btnVerClientes.addActionListener(e -> {
            StringBuilder sb = new StringBuilder("Lista de Clientes:\n");
            for (int i = 0; i < clientes.size(); i++) {
                sb.append(i).append(": ").append(clientes.get(i)).append("\n");
            }
            JOptionPane.showMessageDialog(this, sb.toString());
        });

        btnVerVendas.addActionListener(e -> {
            StringBuilder sb = new StringBuilder("Lista de Vendas:\n");
            for (Venda v : vendas) {
                sb.append(v).append("\n\n");
            }
            JOptionPane.showMessageDialog(this, sb.toString());
        });

        painel.add(btnVerCarros);
        painel.add(btnVerClientes);
        painel.add(btnVerVendas);

        return painel;
    }
}

