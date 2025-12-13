public class UserInterface {
	
	public static void afficher(String menu) {
		// Valeurs autoriées pour menu
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

				
			case "tri":
				System.out.println("TRI DES MUSIQUES\n________________________");
				System.out.println("Choisissez un critère de tri :\n");
				System.out.println("1 - Titre");
				System.out.println("2 - Nom de l'artiste");
				System.out.println("3 - Nom de l'album");
				System.out.println("4 - Date de sortie");
				System.out.println("5 - Durée");
				System.out.println("6 - Popularité");
				System.out.println("");
				System.out.println("0 - Menu principal");
                break;

            case "artiste":
                System.out.println("Entrez le numéro de l'artiste : (1 - 12");
		}
	}
	
	public static void clearScreen() {
		int i;
		
		for(i=0; i<50; i++) {
			System.out.println("");
		}
	}

}
