public class Pedido {
    private int numeroPedido;
    private String descricao;
    private double valorTotal;
    private Cliente cliente;

    public Pedido(int numeroPedido, String descricao, double valorTotal, Cliente cliente) {
        this.numeroPedido = numeroPedido;
        this.descricao = descricao;
        this.valorTotal = valorTotal;
        this.cliente = cliente;
    }

    public int getNumeroPedido() {
        return numeroPedido;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public Cliente getCliente() {
        return cliente;
    }
}
