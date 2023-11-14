import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao Banco Digital Habib LTDA!");


        System.out.println("= = = = = = = = = = M E N U  D O  H A B I B  B A N C O  D I G I T A L  L T D A");
        System.out.println("Escolha o tipo de conta a ser criada:");
        System.out.println("1. Conta Corrente Comum (CCC)");
        System.out.println("2. Conta Corrente Premium (CCP)");
        System.out.println("3. Conta Poupança (CP)");
        System.out.println("4. Conta de Investimento (CI)");
        System.out.println("5. Opções de uma conta");
        System.out.println("5. Sair");
        System.out.print("Digite o número da opção desejada: ");
        int opcao = scanner.nextInt();
        scanner.nextLine(); 

       
        System.out.print("Digite o número da conta: ");
        int numeroConta = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Digite o nome do titular: ");
        String nomeTitular = scanner.nextLine();

        System.out.print("Digite o saldo inicial: ");
        double saldoInicial = scanner.nextDouble();
        scanner.nextLine(); 

        switch (opcao) {

            case 1:

                ContaCorrenteComum ccc = new ContaCorrenteComum(numeroConta, nomeTitular, saldoInicial);
                operacoesConta(ccc);
                break;

            case 2:

                System.out.print("Digite o limite de crédito: ");
                double limiteCredito = scanner.nextDouble();
                scanner.nextLine(); 
                ContaCorrentePremium ccp = new ContaCorrentePremium(numeroConta, nomeTitular, saldoInicial, limiteCredito);
                operacoesConta(ccp);
                break;

            case 3:
                
                Date aniversarioCP = new Date();
                ContaPoupanca cp = new ContaPoupanca(numeroConta, nomeTitular, saldoInicial, aniversarioCP);
                operacoesConta(cp);
                break;

            case 4:

                System.out.print("Digite a taxa de retorno anual: ");
                double taxaRetornoAnual = scanner.nextDouble();
                scanner.nextLine(); 
                ContaInvestimento ci = new ContaInvestimento(numeroConta, nomeTitular, saldoInicial, taxaRetornoAnual);
                operacoesConta(ci);
                break;
                
            default:
                System.out.println("Opção inválida.");
        }

        scanner.close();
    }

    public static void operacoesConta(Conta conta) {

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("\nEscolha uma operação para a conta:");
                System.out.println("1. Depósito");
                System.out.println("2. Saque");
                System.out.println("3. Gerar Extrato");
                System.out.print("Digite o número da operação desejada: ");
                int operacao = scanner.nextInt();
                scanner.nextLine(); 

                switch (operacao) {

                    case 1:

                        System.out.print("Digite o valor do depósito: ");
                        double valorDeposito = scanner.nextDouble();
                        scanner.nextLine(); 
                        System.out.print("Digite a descrição do depósito: ");
                        String descricaoDeposito = scanner.nextLine();
                        conta.deposito(valorDeposito, descricaoDeposito);
                        break;

                    case 2:

                        System.out.print("Digite o valor do saque: ");
                        double valorSaque = scanner.nextDouble();
                        scanner.nextLine(); 
                        System.out.print("Digite a descrição do saque: ");
                        String descricaoSaque = scanner.nextLine();
                        conta.saque(valorSaque, descricaoSaque);
                        break;

                    case 3:

                        conta.gerarExtrato();
                        break;

                    case 4:

                        System.out.println("Saindo.");
                        return;
                    default:
                        System.out.println("Opção inválida.");
                }
            }
        }
    }
}
