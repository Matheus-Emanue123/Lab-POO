import java.util.Date;

public class ContaPoupanca extends Conta {
    private Date aniversario;

    public ContaPoupanca(int numeroConta, String nomeTitular, double saldo, Date aniversario) {
        super(numeroConta, nomeTitular, saldo);
        this.aniversario = aniversario;
    }

    public void gerarExtrato() {
        super.gerarExtrato();
        System.out.println("Dia do Aniversário: " + aniversario);
    }
}
