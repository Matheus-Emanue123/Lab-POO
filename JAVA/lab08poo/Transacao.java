import java.util.Date;

public class Transacao {
    private Date data;
    private double valor;
    private String descricao;

    public Transacao(double valor, String descricao) {
        this.data = new Date();
        this.valor = valor;
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Data: " + data + ", Valor: " + valor + ", Descrição: " + descricao;
    }
}
