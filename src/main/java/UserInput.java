import java.util.Scanner;

public class UserInput {
    public static int input() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Choisissez une option : ");
        // Tant que l'input n'est pas un int lire l'input suivant
        while (!scanner.hasNextInt()) {
            System.out.print("Entrée invalide, recommencez : ");
            scanner.next();
        }
        int variable = scanner.nextInt();
        System.out.println("USER INPUT ---> "+variable);
        return variable;
    }
}
