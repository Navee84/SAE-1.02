public class UserInterface {
	
	public static void afficher(String menu) {
        // Les conventions de critères de sélections sont définis dans cette fonction
        // Lors de l'utilisation de variables de critères, se référer au case correspondant

        /*
         * Permet l'affichage d'un panneau spécifique.
         * Arguments : String, valeurs possibles
         * — main
         * — affichage
         * — triSubMenu
         * — tri
         * — filtre
         * — recherche
         * — chargement
         */
		switch (menu){
			case "main":
				System.out.println("GESTIONNAIRE DE MUSIQUES\n________________________\n");
                    System.out.println("1 - Afficher les musiques");
                    System.out.println("2 - Trier les musiques");
                    System.out.println("3 - Filtrer les musiques");
                    System.out.println("4 - Rechercher une musique");
                    System.out.println("5 - Charger un fichier de musiques");
				System.out.println("");
				System.out.println("0 - Quitter l'application");
				break;

            case "affichage":
                System.out.println("AFFICHAGE DES MUSIQUES\n______________________");
                System.out.println("Entrez n'importe quelle touche pour revenir au menu principal.");
                break;

            case "triSubMenu":
                System.out.println("TRI DES MUSIQUES - SOUS MENU\n________________________");
                System.out.print("1 - Changer le critère de tri ");
                System.out.println("(Ne fonctionne qu'avec le tri Java)");
                System.out.println("2 - Changer le type de tri");
                System.out.println("");
                System.out.println("0 - Menu principal");
                break;

				
			case "tri":
				System.out.println("TRI DES MUSIQUES\n________________________");
				System.out.println("Choisissez un critère de tri :\n");
                displayAttributes();
				System.out.println("");
				System.out.println("0 - Menu principal");
                break;

            case "triType":
                System.out.println("TYPE DE TRI\n________________________");
                System.out.println("1 - Tri sélection");
                System.out.println("2 - Tri fusion");
                System.out.println("3 - Tri java");
                System.out.println("");
                break;

			case "filtre":
				System.out.println("FILTRER LES MUSIQUES\n________________________");
				System.out.println("Choisissez un critère de filtre :\n");
                displayAttributes();
				System.out.println("");
				System.out.println("0 - Menu principal");
                break;

			case "recherche":
				System.out.println("RECHERCHE\n________________________");
				System.out.println("Entrez un titre à chercher :");
				System.out.println("");
				System.out.println("0 - Menu principal");
                break;

            case "searchSubMenu":
                System.out.println("TYPE DE RECHERCHE\n________________________");
                System.out.println("1 - Recherche naïve");
                System.out.println("2 - Recherche dichotomique (triera la liste automatiquement)");
                System.out.println("");
                break;

			case "chargement":
				System.out.println("CHARGER UN FICHIER\n________________________");
				System.out.println("Entrez le chemin RELATIF du fichier à charger :");
				System.out.println("");
                System.out.print("Chemin : ");
                break;

            default:
                System.out.println("Erreur lors de l'affichage de '"+menu+"'");

		}
	}

    public static void displayAttributes() {
        System.out.println("1 - Titre");
        System.out.println("2 - Nom de l'artiste");
        System.out.println("3 - Nom de l'album");
        System.out.println("4 - Date de sortie");
        System.out.println("5 - Durée");
        System.out.println("6 - Popularité");

    }
	
	public static void clearScreen() {
        int i;

        for (i = 0; i < 50; i++) {
            System.out.println("");
        }
    }

}
