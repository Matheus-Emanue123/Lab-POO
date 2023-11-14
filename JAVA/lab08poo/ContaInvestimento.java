public class ContaInvestimento extends Conta {
    private double taxaRetornoAnual;

    public ContaInvestimento(int numeroConta, String nomeTitular, double saldo, double taxaRetornoAnual) {
        super(numeroConta, nomeTitular, saldo);
        this.taxaRetornoAnual = taxaRetornoAnual;
    }

    public void gerarExtrato() {
        super.gerarExtrato();
        System.out.println("Taxa de Retorno Anual: " + taxaRetornoAnual);
    }
}
