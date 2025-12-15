import javax.swing.*;
import java.io.*;
import java.util.*;

public class main {
    private static boolean isImplementationLinkedlist = false; // CHANGER CE PARAMÈTRE POUR CHANGER L'IMPLÉMENTATION UTLISÉE
    private static List<Musique> musicList;

    static {
        if (isImplementationLinkedlist) {
            musicList = new LinkedList<>();
        } else {
            musicList = new ArrayList<>();
        }
    }

	public static void main(String[] args) throws IOException {

//        FileWriter myWriter = new FileWriter("pathtest.txt");
//        myWriter.write("Les fichiers java sont trouvés ici par défaut !");
//        myWriter.close();


        int input;
        boolean mainLoop = true;
        boolean triLoop;
        int attributeCriteria = 1; // Valeur par défaut du critère d'attribut
        int triType = 1; // Valeur par défaut du type de tri


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

                    // Afficher tous les éléments présents dans la liste
                    Iterator<Musique> iterator = musicList.iterator();
                    while(iterator.hasNext()) {
                        iterator.next().afficher();
                        System.out.println("");
                    }
                    // attendre un input de l'utilisateur pour revenir au menu principal
                    input = UserInput.input();
                    break;

                // BOUCLE DES TRIS
                case 2:
                    UserInterface.clearScreen();
                    UserInterface.afficher("triSubMenu");
                    input = UserInput.input();
                    switch (input) {
                        case 1:
                            UserInterface.clearScreen();
                            UserInterface.afficher("tri");
                            System.out.println("Attribut de tri actif : " + attributeCriteria);
                            input = UserInput.input();

                            attributeCriteria = UserInput.attributeCriteria(attributeCriteria, input);
                            input = -1;

                            break;
                        case 2:
                            // Changer le type de tri
                                UserInterface.clearScreen();
                                UserInterface.afficher("triType");
                                System.out.println("Type de tri actif : " + triType);
                                input = UserInput.input();

                                triType = UserInput.triType(triType, input);
                                input = -1;
                            break;

                        default:
                            System.out.println("Entrée invalide, veuillez réessayer.");
                            break;
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
                    String path;
                    UserInterface.clearScreen();
                    UserInterface.afficher("chargement");
                    path = UserInput.StringInput();
                    while(!contructData(path)) {
                        path = UserInput.StringInput();
                    }
                    break;

                // fin du programme
                case 0:
                    mainLoop = false;
                    System.out.println("goobye ;)");
                    break;
            }

        }

	}
    public static boolean contructData(String path) throws IOException {
        try {
            BufferedReader dataFile = fileLoader.loadFile(path);
            dataFile.readLine(); //passer la première ligne du fichier
            while(dataFile.ready()) {
                Musique musicObject = new Musique((String) dataFile.readLine());
                musicList.add(musicObject);

            }

        } catch (FileNotFoundException fileError) {
            System.out.println("Le chemin spécifié n'est pas valide, veuillez en saisir un nouveau :");
            return false;
        } catch (Exception e) {
            System.out.println("Erreur -->"+ e);
        }

        return true;

    }

//    public void triSelection(Object criteria) {
//        Iterator<Musique> it1 = musicList.listIterator();
//
//        while (it1.hasNext()) {
//            int posMin = it1.hasNext().;
//            String[] min = it1.next();
//            ListIterator<String[]> it2 = table.listIterator(it1.nextIndex());
//
//            while (it2.hasNext()) {
//                String[] courant = it2.next();
//                int popCourant = Integer.parseInt(courant[col_popularite]);
//                int popMin = Integer.parseInt(min[col_popularite]);
//                if (popCourant < popMin) {
//                    min = courant;
//                    posMin = it2.previousIndex();}}
//            int posActuelle = it1.previousIndex();
//            if (posMin != posActuelle) {
//                String[] tmp = table.get(posActuelle);
//                table.set(posActuelle, min);
//                table.set(posMin, tmp);}}}

}
