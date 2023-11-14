import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Cliente> clientes = new ArrayList<>();
    private static List<Pedido> pedidos = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu de Opções:");
            System.out.println("a) Cadastrar um Cliente");
            System.out.println("b) Cadastrar um Pedido");
            System.out.println("c) Listar todos os Pedidos de um Cliente");
            System.out.println("d) Imprimir lista de Clientes cadastrados");
            System.out.println("e) Imprimir lista de todos os Pedidos cadastrados");
            System.out.println("f) Calcular valor total gasto por um Cliente");
            System.out.println("s) Sair");
            System.out.print("Escolha uma opção: ");

            String opcao = scanner.nextLine();

            switch (opcao) {
                case "a":
                    cadastrarCliente();
                    break;
                case "b":
                    cadastrarPedido();
                    break;
                case "c":
                    listarPedidosDeCliente();
                    break;
                case "d":
                    imprimirListaClientes();
                    break;
                case "e":
                    imprimirListaPedidos();
                    break;
                case "f":
                    calcularValorTotalGastoPorCliente();
                    break;
                case "s":
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void cadastrarCliente() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nome do Cliente: ");
        String nome = scanner.nextLine();
        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();
        System.out.print("Número de Telefone: ");
        String numeroTelefone = scanner.nextLine();

        Cliente cliente = new Cliente(nome, endereco, numeroTelefone);
        clientes.add(cliente);

        System.out.println("Cliente cadastrado com sucesso!");
    }

    private static void cadastrarPedido() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Número do Pedido: ");
        int numeroPedido = Integer.parseInt(scanner.nextLine());
        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();
        System.out.print("Valor Total: ");
        double valorTotal = Double.parseDouble(scanner.nextLine());

        System.out.print("Nome ou Número de Telefone do Cliente: ");
        String clienteReferencia = scanner.nextLine();

        Cliente clienteAssociado = buscarClientePorReferencia(clienteReferencia);

        if (clienteAssociado != null) {
            Pedido pedido = new Pedido(numeroPedido, descricao, valorTotal, clienteAssociado);
            pedidos.add(pedido);
            System.out.println("Pedido cadastrado com sucesso!");
        } else {
            System.out.println("Cliente não encontrado. Cadastre o cliente primeiro.");
        }
    }

    private static Cliente buscarClientePorReferencia(String referencia) {
        for (Cliente cliente : clientes) {
            if (cliente.getNome().equalsIgnoreCase(referencia) || cliente.getNumeroTelefone().equals(referencia)) {
                return cliente;
            }
        }
        return null;
    }

    private static void listarPedidosDeCliente() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nome ou Número de Telefone do Cliente: ");
        String clienteReferencia = scanner.nextLine();

        Cliente clienteAssociado = buscarClientePorReferencia(clienteReferencia);

        if (clienteAssociado != null) {
            System.out.println("Pedidos do Cliente: " + clienteAssociado.getNome());
            for (Pedido pedido : pedidos) {
                if (pedido.getCliente() == clienteAssociado) {
                    System.out.println("Número do Pedido: " + pedido.getNumeroPedido());
                    System.out.println("Descrição: " + pedido.getDescricao());
                    System.out.println("Valor Total: " + pedido.getValorTotal());
                    System.out.println("--------------------------");
                }
            }
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    private static void imprimirListaClientes() {
        System.out.println("Lista de Clientes Cadastrados:");
        for (Cliente cliente : clientes) {
            System.out.println("Nome: " + cliente.getNome());
            System.out.println("Endereço: " + cliente.getEndereco());
            System.out.println("Número de Telefone: " + cliente.getNumeroTelefone());
            System.out.println("--------------------------");
        }
    }

    private static void imprimirListaPedidos() {
        System.out.println("Lista de Pedidos Cadastrados:");
        for (Pedido pedido : pedidos) {
            System.out.println("Número do Pedido: " + pedido.getNumeroPedido());
            System.out.println("Descrição: " + pedido.getDescricao());
            System.out.println("Valor Total: " + pedido.getValorTotal());
            System.out.println("Cliente Associado: " + pedido.getCliente().getNome());
            System.out.println("--------------------------");
        }
    }

    private static void calcularValorTotalGastoPorCliente() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nome ou Número de Telefone do Cliente: ");
        String clienteReferencia = scanner.nextLine();

        Cliente clienteAssociado = buscarClientePorReferencia(clienteReferencia);

        if (clienteAssociado != null) {
            double totalGasto = 0;
            for (Pedido pedido : pedidos) {
                if (pedido.getCliente() == clienteAssociado) {
                    totalGasto += pedido.getValorTotal();
                }
            }
            System.out.println("Total gasto pelo Cliente " + clienteAssociado.getNome() + ": " + totalGasto);
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }
}