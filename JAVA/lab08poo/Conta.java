import java.util.ArrayList;
import java.util.List;

public class Conta {
    private int numeroConta;
    private String nomeTitular;
    protected double saldo;
    protected List<Transacao> transacoes;

    public Conta(int numeroConta, String nomeTitular, double saldo) {
        this.numeroConta = numeroConta;
        this.nomeTitular = nomeTitular;
        this.saldo = saldo;
        this.transacoes = new ArrayList<>();
    }

    public void deposito(double valor, String descricao) {
        saldo += valor;
        transacoes.add(new Transacao(valor, descricao));
    }

    public void saque(double valor, String descricao) {
        if (valor <= saldo) {
            saldo -= valor;
            transacoes.add(new Transacao(-valor, descricao));
        } else {
            System.out.println("Saldo insuficiente para saque.");
        }
    }

    public void gerarExtrato() {
        System.out.println("Número da Conta: " + numeroConta);
        System.out.println("Nome do Titular: " + nomeTitular);
        System.out.println("Saldo: " + saldo);
        System.out.println("Transações:");
        for (Transacao transacao : transacoes) {
            System.out.println(transacao);
        }
    }
}
