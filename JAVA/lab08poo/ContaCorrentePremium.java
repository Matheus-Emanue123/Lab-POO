public class ContaCorrentePremium extends Conta {
    private double limiteCredito;

    public ContaCorrentePremium(int numeroConta, String nomeTitular, double saldo, double limiteCredito) {
        super(numeroConta, nomeTitular, saldo);
        this.limiteCredito = limiteCredito;
    }

    @Override
    public void saque(double valor, String descricao) {
        if (valor <= saldo + limiteCredito) {
            saldo -= valor;
            transacoes.add(new Transacao(-valor, descricao));
        } else {
            System.out.println("Limite de crédito excedido.");
        }
    }
}
