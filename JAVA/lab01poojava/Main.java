import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            boolean italico = false;
            boolean negrito = false;

            for (char caracter : line.toCharArray()) {
                if (caracter == '_') {
                    System.out.print(italico ? "</i>" : "<i>");
                    italico = !italico;
                } else if (caracter == '*') {
                    System.out.print(negrito ? "</b>" : "<b>");
                    negrito = !negrito;
                } else {
                    System.out.print(caracter);
                }
            }

            System.out.println();
        }
    }
}
