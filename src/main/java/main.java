import java.io.*;

public class main {

	public static void main(String[] args) throws IOException {
        int input;
        boolean mainLoop = true;
        boolean triLoop;
        int attributeCriteria = 1; // Valeur par défaut du critère d'attribut

		//BufferedReader dataFile = fileLoader.loadFile();
		//while(dataFile.ready()) {
			//Musique testmusique = new Musique((String) dataFile.readLine());
        // UserInterface.afficher("tri");
        System.out.println("TEST");


        // BOUCLE PRINCIPALE
        while(mainLoop) {
            UserInterface.clearScreen();
            UserInterface.afficher("main");
            input = UserInput.input();

            switch (input) {

                // AFFICHAGE DES MUSIQUES
                case 1:
                    UserInterface.clearScreen();
                    UserInterface.afficher("affichage");
                    input = UserInput.input();
                    break;

                // BOUCLE DES TRIS
                case 2:
                    triLoop = true;
                    attributeCriteria = 1; //valeur par défaut
                    while (triLoop) {
                        UserInterface.clearScreen();
                        UserInterface.afficher("tri");
                        System.out.println("Attribut de tri actif : "+attributeCriteria);
                        input = UserInput.input();

                        attributeCriteria = UserInput.attributeCriteria(attributeCriteria, input);

                        // Retour au menu principal
                        if(input == 0) {
                            triLoop = false;
                        }
                    }
                    break;
                // BOUCLE DE FILTRE
                case 3:
                    UserInterface.clearScreen();
                    UserInterface.afficher("filtre");
                    System.out.println("Attribut de filtre actif : "+attributeCriteria);
                    input = UserInput.input();

                    attributeCriteria = UserInput.attributeCriteria(attributeCriteria, input);

                    // Retour au menu principal
                    if(input == 0) {
                        triLoop = false;
                    }
                    break;

                // RECHERCHE DE MUSIQUE
                case 4:
                    UserInterface.clearScreen();
                    UserInterface.afficher("recherche");
                    UserInput.StringInput();
                    break;

                // CHARGEMENT DU FICHIER
                case 5:

                    break;

                // fin du programme
                case 0:
                    mainLoop = false;
                    System.out.println("goobye ;)");
                    break;
            }

        }

	}

}
