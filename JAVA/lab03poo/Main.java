import java.util.Scanner;

public class Main {
    
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int opcao = 1;
        String nome, dataNascimento, titulo, ISBN;
        Biblioteca b1 = new Biblioteca();

        while(opcao!=0){
            
            System.out.println("\n\n==========MENU==========\n\n");
            System.out.println("1 - Adicionar Livro à Biblioteca");
            System.out.println("2 - Buscar Livro na Biblioteca");
            System.out.println("3 - Mostrar Livro da Biblioteca");
            System.out.println("0 - ENCERRAR SISTEMA");
            System.out.println("\n\n========================");

            opcao = scanner.nextInt();

      

            switch(opcao){

                case 1:

                 System.out.println("---------- A D I C I O N A R  L I V R O----------");
                 scanner.nextLine();
                 System.out.println("Digite o título do livro a ser adicionado à biblioteca: ");
                 titulo = scanner.nextLine();

                 System.out.println("Digite o ISBN do livro a ser adicionado à biblioteca: ");
                 ISBN = scanner.nextLine();

                 System.out.println("Digite o nome do autor do livro a ser adicionado à biblioteca: ");
                 nome = scanner.nextLine();

                 System.out.println("Digite a data de nascimento do autor do livro: ");
                 dataNascimento = scanner.nextLine();

                 Autor autorLivro = new Autor(nome, dataNascimento);


                 Livro livro = new Livro(titulo, ISBN, autorLivro);

                 b1.addLivro(livro);
                 break;
                 
                
                case 2:

                System.out.println("---------- B U S C A R  L I V R O----------");

                scanner.nextLine();
                System.out.println("Digite o título do livro a ser buscado: ");
                titulo = scanner.nextLine();

                System.out.println("Digite o nome do autor do livro: ");
                nome = scanner.nextLine();

                System.out.println("Digite a data de nascimento do autor do livro: ");
                dataNascimento = scanner.nextLine();

                Autor autorBusca = new Autor(nome, dataNascimento);

                b1.buscarLivro(titulo, autorBusca);

                break;
                
                case 3: 

                System.out.println("---------- L I S T A N D O  L I V R O S  D A  B I B L I O T E C A  ----------");
                b1.mostrarLivros();
                break;

                case 0: 

                System.out.println("---------- S A I N D O ----------");
                System.exit(0);
                
            }
        }
         scanner.close();
    }
   
}