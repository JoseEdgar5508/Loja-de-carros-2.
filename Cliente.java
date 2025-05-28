public class Cliente {
    private int clienteID;
    private String nome;
    private String telefone;
    private String email;
    private String cpf;
    private String endereco;

    public Cliente(int clienteID, String nome, String telefone, String email, String cpf, String endereco) {
        this.clienteID = clienteID;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.cpf = cpf;
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "ID: " + clienteID + " | " + nome + " - " + telefone + " - " + email +
                " - CPF: " + cpf + " - Endereço: " + endereco;
    }

    // Getters e Setters
    public int getClienteID() { return clienteID; }
}

