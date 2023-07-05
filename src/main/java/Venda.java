public class Venda {

    private Cliente cliente;
    private Vendedor vendedor;
    private double valorASerPago;
    private String dataRegistro;

    public Venda(Cliente cliente, Vendedor vendedor, double valorASerPago, String dataRegistro) {
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.valorASerPago = valorASerPago;
        this.dataRegistro = dataRegistro;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public double getValorASerPago() {
        return valorASerPago;
    }

    public String getDataRegistro() {
        return dataRegistro;
    }
}
