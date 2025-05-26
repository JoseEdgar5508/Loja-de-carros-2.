public class Carro {
    private String modelo;
    private String marca;
    private int ano;
    private double preco;

    public Carro(String modelo, String marca, int ano, double preco) {
        this.modelo = modelo;
        this.marca = marca;
        this.ano = ano;
        this.preco = preco;
    }

    @Override
    public String toString() {
        return modelo + " - " + marca + " (" + ano + ") R$" + preco;
    }
}

