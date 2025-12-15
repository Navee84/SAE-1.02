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
        String input = "";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            input = reader.readLine();
            System.out.println("STRING INPUT ---> "+input);

        } catch (Exception e){
            System.out.println("ERROR STRING INPUT");
            System.out.println(e);
        }
        return input;
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

    public static int triType(int currentTri, int input) {
        if(input > 0 && input <= 3){
            System.out.println("Type de tri sélectionné : "+input);
            return input;
        } else {
            System.out.println("Type de tri non changé.");
            return currentTri;
        }
    }
}
