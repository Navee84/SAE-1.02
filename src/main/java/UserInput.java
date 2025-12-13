import java.io.*;
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

    public static String StringInput() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("STRING INPUT ---> "+reader.readLine());

        } catch (Exception e){
            System.out.println("ERROR STRING INPUT");
            System.out.println(e);
        }
        return "";
    }

    public static int attributeCriteria(int currentAttribute, int input) {
        if(input > 0 && input <= 6){
            System.out.println("Attribut sélectionné : "+input);
            return input;
        } else {
            System.out.println("Attribut non changé.");
            return currentAttribute;
        }

    }
}
