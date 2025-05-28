public class Venda {
    private int vendaID;
    private Carro carro;
    private Cliente cliente;
    private String data;
    private double valor;
    private String metodoPagamento;
    private String observacoes;

    public Venda(int vendaID, Carro carro, Cliente cliente, String data, double valor,
                 String metodoPagamento, String observacoes) {
        this.vendaID = vendaID;
        this.carro = carro;
        this.cliente = cliente;
        this.data = data;
        this.valor = valor;
        this.metodoPagamento = metodoPagamento;
        this.observacoes = observacoes;
    }

    @Override
    public String toString() {
        return "Venda ID: " + vendaID +
                "\nCarro: " + carro +
                "\nCliente: " + cliente +
                "\nData: " + data +
                "\nValor: " + String.format("R$ %.2f", valor) +
                "\nMétodo de Pagamento: " + metodoPagamento +
                "\nObservações: " + observacoes;
    }

    // Getters e Setters
    public int getVendaID() { return vendaID; }
}


