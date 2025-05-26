public class Venda {
    private Carro carro;
    private Cliente cliente;
    private String data;
    private double valor;

    public Venda(Carro carro, Cliente cliente, String data, double valor) {
        this.carro = carro;
        this.cliente = cliente;
        this.data = data;
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Carro: " + carro + "\nCliente: " + cliente + "\nData: " + data + "\nValor: R$" + valor;
    }
}

