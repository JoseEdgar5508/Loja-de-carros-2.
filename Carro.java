public class Carro {
    private int carroID;
    private String modelo;
    private String marca;
    private int ano;
    private double preco;
    private String cor;
    private String placa;
    private String chassi;
    private String status;

    public Carro(int carroID, String modelo, String marca, int ano, double preco,
                 String cor, String placa, String chassi, String status) {
        this.carroID = carroID;
        this.modelo = modelo;
        this.marca = marca;
        this.ano = ano;
        this.preco = preco;
        this.cor = cor;
        this.placa = placa;
        this.chassi = chassi;
        this.status = status;
    }

    @Override
    public String toString() {
        return "ID: " + carroID + " | " + modelo + " - " + marca + " (" + ano + ") - " +
                cor + " - Placa: " + placa + " - Chassi: " + chassi + " - " +
                String.format("R$ %.2f", preco) + " - Status: " + status;
    }

    // Getters e Setters
    public int getCarroID() { return carroID; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}


