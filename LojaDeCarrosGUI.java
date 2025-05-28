import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class LojaDeCarrosGUI extends JFrame {
    private final ArrayList<Carro> carros = new ArrayList<>();
    private final ArrayList<Cliente> clientes = new ArrayList<>();
    private final ArrayList<Venda> vendas = new ArrayList<>();

    private int proximoCarroID = 1;
    private int proximoClienteID = 1;
    private int proximoVendaID = 1;

    public LojaDeCarrosGUI() {
        setTitle("Sistema da Loja de Carros");
        setSize(600, 500);
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
        JPanel painel = new JPanel(new GridLayout(9, 2, 5, 5));
        JTextField campoModelo = new JTextField();
        JTextField campoMarca = new JTextField();
        JTextField campoAno = new JTextField();
        JTextField campoPreco = new JTextField();
        JTextField campoCor = new JTextField();
        JTextField campoPlaca = new JTextField();
        JTextField campoChassi = new JTextField();
        JTextField campoStatus = new JTextField();

        JButton btnCadastrar = new JButton("Cadastrar");

        painel.add(new JLabel("Modelo:"));
        painel.add(campoModelo);
        painel.add(new JLabel("Marca:"));
        painel.add(campoMarca);
        painel.add(new JLabel("Ano:"));
        painel.add(campoAno);
        painel.add(new JLabel("Preço:"));
        painel.add(campoPreco);
        painel.add(new JLabel("Cor:"));
        painel.add(campoCor);
        painel.add(new JLabel("Placa:"));
        painel.add(campoPlaca);
        painel.add(new JLabel("Chassi:"));
        painel.add(campoChassi);
        painel.add(new JLabel("Status:"));
        painel.add(campoStatus);
        painel.add(new JLabel());
        painel.add(btnCadastrar);

        btnCadastrar.addActionListener((ActionEvent e) -> {
            try {
                String modelo = campoModelo.getText();
                String marca = campoMarca.getText();
                int ano = Integer.parseInt(campoAno.getText());
                double preco = Double.parseDouble(campoPreco.getText());
                String cor = campoCor.getText();
                String placa = campoPlaca.getText();
                String chassi = campoChassi.getText();
                String status = campoStatus.getText();

                Carro carro = new Carro(proximoCarroID++, modelo, marca, ano, preco, cor, placa, chassi, status);
                carros.add(carro);
                JOptionPane.showMessageDialog(this, "Carro cadastrado!");
                // Limpa os campos após cadastro
                campoModelo.setText("");
                campoMarca.setText("");
                campoAno.setText("");
                campoPreco.setText("");
                campoCor.setText("");
                campoPlaca.setText("");
                campoChassi.setText("");
                campoStatus.setText("");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Erro: verifique os dados numéricos.");
            }
        });

        return painel;
    }

    private JPanel criarAbaClientes() {
        JPanel painel = new JPanel(new GridLayout(7, 2, 5, 5));
        JTextField campoNome = new JTextField();
        JTextField campoTelefone = new JTextField();
        JTextField campoEmail = new JTextField();
        JTextField campoCPF = new JTextField();
        JTextField campoEndereco = new JTextField();
        JButton btnCadastrar = new JButton("Cadastrar");

        painel.add(new JLabel("Nome:"));
        painel.add(campoNome);
        painel.add(new JLabel("Telefone:"));
        painel.add(campoTelefone);
        painel.add(new JLabel("Email:"));
        painel.add(campoEmail);
        painel.add(new JLabel("CPF:"));
        painel.add(campoCPF);
        painel.add(new JLabel("Endereço:"));
        painel.add(campoEndereco);
        painel.add(new JLabel());
        painel.add(btnCadastrar);

        btnCadastrar.addActionListener((ActionEvent e) -> {
            String nome = campoNome.getText();
            String telefone = campoTelefone.getText();
            String email = campoEmail.getText();
            String cpf = campoCPF.getText();
            String endereco = campoEndereco.getText();

            if(nome.isEmpty() || cpf.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Nome e CPF são obrigatórios.");
                return;
            }

            Cliente cliente = new Cliente(proximoClienteID++, nome, telefone, email, cpf, endereco);
            clientes.add(cliente);
            JOptionPane.showMessageDialog(this, "Cliente cadastrado!");

            // Limpar campos
            campoNome.setText("");
            campoTelefone.setText("");
            campoEmail.setText("");
            campoCPF.setText("");
            campoEndereco.setText("");
        });

        return painel;
    }

    private JPanel criarAbaVendas() {
        JPanel painel = new JPanel(new GridLayout(9, 2, 5, 5));
        JTextField campoIndiceCarro = new JTextField();
        JTextField campoIndiceCliente = new JTextField();
        JTextField campoData = new JTextField();
        JTextField campoValor = new JTextField();
        JTextField campoMetodoPagamento = new JTextField();
        JTextField campoObservacoes = new JTextField();
        JButton btnRegistrar = new JButton("Registrar Venda");

        painel.add(new JLabel("Índice do Carro:"));
        painel.add(campoIndiceCarro);
        painel.add(new JLabel("Índice do Cliente:"));
        painel.add(campoIndiceCliente);
        painel.add(new JLabel("Data da Venda:"));
        painel.add(campoData);
        painel.add(new JLabel("Valor:"));
        painel.add(campoValor);
        painel.add(new JLabel("Método de Pagamento:"));
        painel.add(campoMetodoPagamento);
        painel.add(new JLabel("Observações:"));
        painel.add(campoObservacoes);
        painel.add(new JLabel());
        painel.add(btnRegistrar);

        btnRegistrar.addActionListener((ActionEvent e) -> {
            try {
                int idxCarro = Integer.parseInt(campoIndiceCarro.getText());
                int idxCliente = Integer.parseInt(campoIndiceCliente.getText());
                String data = campoData.getText();
                double valor = Double.parseDouble(campoValor.getText());
                String metodoPagamento = campoMetodoPagamento.getText();
                String observacoes = campoObservacoes.getText();

                if (idxCarro < 0 || idxCarro >= carros.size()) {
                    JOptionPane.showMessageDialog(this, "Índice do carro inválido.");
                    return;
                }
                if (idxCliente < 0 || idxCliente >= clientes.size()) {
                    JOptionPane.showMessageDialog(this, "Índice do cliente inválido.");
                    return;
                }
                if (data.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Data da venda é obrigatória.");
                    return;
                }
                if (metodoPagamento.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Método de pagamento é obrigatório.");
                    return;
                }

                Venda venda = new Venda(proximoVendaID++, carros.get(idxCarro), clientes.get(idxCliente),
                        data, valor, metodoPagamento, observacoes);
                vendas.add(venda);
                JOptionPane.showMessageDialog(this, "Venda registrada!");

                // Limpar campos após registro
                campoIndiceCarro.setText("");
                campoIndiceCliente.setText("");
                campoData.setText("");
                campoValor.setText("");
                campoMetodoPagamento.setText("");
                campoObservacoes.setText("");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Erro: verifique os dados numéricos.");
            }
        });

        return painel;
    }

    private JPanel criarAbaConsultas() {
        JPanel painel = new JPanel(new FlowLayout());

        JButton btnVerCarros = new JButton("Ver Carros");
        JButton btnVerClientes = new JButton("Ver Clientes");
        JButton btnVerVendas = new JButton("Ver Vendas");

        btnVerCarros.addActionListener(e -> {
            if (carros.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Nenhum carro cadastrado.");
                return;
            }
            StringBuilder sb = new StringBuilder("Lista de Carros:\n");
            for (int i = 0; i < carros.size(); i++) {
                sb.append(i).append(": ").append(carros.get(i)).append("\n");
            }
            JTextArea areaTexto = new JTextArea(sb.toString());
            areaTexto.setEditable(false);
            JScrollPane scroll = new JScrollPane(areaTexto);
            scroll.setPreferredSize(new Dimension(550, 300));
            JOptionPane.showMessageDialog(this, scroll, "Carros Cadastrados", JOptionPane.INFORMATION_MESSAGE);
        });

        btnVerClientes.addActionListener(e -> {
            if (clientes.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Nenhum cliente cadastrado.");
                return;
            }
            StringBuilder sb = new StringBuilder("Lista de Clientes:\n");
            for (int i = 0; i < clientes.size(); i++) {
                sb.append(i).append(": ").append(clientes.get(i)).append("\n");
            }
            JTextArea areaTexto = new JTextArea(sb.toString());
            areaTexto.setEditable(false);
            JScrollPane scroll = new JScrollPane(areaTexto);
            scroll.setPreferredSize(new Dimension(550, 300));
            JOptionPane.showMessageDialog(this, scroll, "Clientes Cadastrados", JOptionPane.INFORMATION_MESSAGE);
        });

        btnVerVendas.addActionListener(e -> {
            if (vendas.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Nenhuma venda registrada.");
                return;
            }
            StringBuilder sb = new StringBuilder("Lista de Vendas:\n");
            for (Venda v : vendas) {
                sb.append(v).append("\n\n");
            }
            JTextArea areaTexto = new JTextArea(sb.toString());
            areaTexto.setEditable(false);
            JScrollPane scroll = new JScrollPane(areaTexto);
            scroll.setPreferredSize(new Dimension(550, 300));
            JOptionPane.showMessageDialog(this, scroll, "Vendas Registradas", JOptionPane.INFORMATION_MESSAGE);
        });

        painel.add(btnVerCarros);
        painel.add(btnVerClientes);
        painel.add(btnVerVendas);

        return painel;
    }
}
