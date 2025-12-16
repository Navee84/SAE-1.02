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

        long start,stop;  //sert pour calculer le temps des tris


        int input;
        boolean mainLoop = true;
        boolean triLoop;
        int attributeCriteria = 1; // Valeur par défaut du critère d'attribut
        int triType = 1; // Valeur par défaut du type de tri
        int searchType = 1; // Valeur par défaut du type de recherche
        int filterType = 1; // Valeur par défaut du type de filtre


        System.out.println("TEST");


        // BOUCLE PRINCIPALE
        while(mainLoop) {
            UserInterface.clearScreen();
            UserInterface.afficher("main");
            System.out.println("Dernier temps d'exécution : "+(execTime.lastExecTime)/1000000 +" ms");
            execTime.lastExecTime = -1;
            input = UserInput.input();

            switch (input) {

                // AFFICHAGE DES MUSIQUES
                case 1:
                    UserInterface.clearScreen();
                    UserInterface.afficher("affichage");
                    System.out.printf("%-100s", "Titre");
                    System.out.print("  |  ");

                    System.out.printf("%4s", "Durée");
                    System.out.print("  |  ");

                    System.out.printf("  %-8s", "Date de sortie");
                    System.out.print("  |  ");

                    System.out.printf("  %-60s", "Nom de l'album");
                    System.out.print("  |  ");
                    System.out.printf("  %-30s", "Type de l'album");
                    System.out.print("  |  ");

                    System.out.printf("  %3s  |  ", "Popularité de l'album");
                    System.out.print("  |  ");
                    for(int i = 0; i<12; i++){
                        System.out.print("Artiste "+i);
                        System.out.print("  |  ");
                    }

                    // Afficher tous les éléments présents dans la liste
                    Iterator<Musique> iterator = musicList.iterator();
                    int i = 1;
                    if(musicList.size()>=10000) {
                        while (iterator.hasNext()) {
                            if(i%1000==0) {
                                System.out.print(i + " - ");
                                iterator.next().afficher();
                                System.out.println("");
                            } else {
                                iterator.next();
                            }
                            i++;
                        }
                    } else {
                        while(iterator.hasNext()) {
                            System.out.print(i + " - ");
                            iterator.next().afficher();
                            System.out.println("");
                            i++;
                        }
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
                    // TRI DES MUSIQUES SELON LES PARAMÈTRES CHOISIS
                    switch (triType) {
                        case 1:
                            // Tri sélection
                            triSelection(musicList);
                            break;
                        case 2:
                            // Tri fusion
                            triFusion(musicList);
                            break;
                        case 3:
                            // Tri Java
                            triJava(attributeCriteria);
                    }

                    break;
                // BOUCLE DE FILTRE
                case 3:
                    UserInterface.clearScreen();
                    UserInterface.afficher("filtreSubMenu");
                    System.out.println("Type de filtre actif : "+filterType);
                    input = UserInput.input();

                    switch(input) {
                        case 1:
                            // Filtre manuel
                            UserInterface.clearScreen();
                            System.out.println("Entrez la valeur de l'année : ");
                            String valueManual = UserInput.StringInput();
                            filtreManuel(valueManual);
                            break;
                        case 2:
                            // Filtre java
                            UserInterface.clearScreen();
                            UserInterface.afficher("filtre");
                            attributeCriteria = UserInput.input();
                            System.out.println("Entrez la valeur de filtre : ");
                            String value = UserInput.StringInput();
                            filtre(attributeCriteria, value);
                            break;

                        default:
                            System.out.println("Entrée invalide, veuillez réessayer.");
                            break;
                    }

                    attributeCriteria = UserInput.attributeCriteria(attributeCriteria, input);
                    break;

                // RECHERCHE DE MUSIQUE
                case 4:
                    String title;
                    UserInterface.clearScreen();
                    UserInterface.afficher("searchSubMenu");
                    System.out.println("type de recherche active : " + searchType);
                    searchType = UserInput.input();

                    UserInterface.clearScreen();
                    UserInterface.afficher("recherche");
                    title = UserInput.StringInput();


                    switch (searchType) {
                        case 1:
                            rechercheLineaire(title);
                            break;
                        case 2:
                            rechercheDichotomique(title);
                            break;

                        default:
                            System.out.println("Entrée invalide, veuillez réessayer.");
                            break;

                    }
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
                case 6 :
                    supression();
                    break;

                // fin du programme
                case 0:
                    mainLoop = false;
                    System.out.println("goobye ;)");
                    break;
            }

        }

	}

    public static boolean contructData(String path) {
        musicList.clear();
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
    public static void supression() {
        execTime.startProfiling();
        while (musicList.size() > 0)  {
                musicList.remove(0);
        }
        execTime.stopProfiling();
    }
    public static void filtreManuel(String value) {
        execTime.startProfiling();
        Iterator it = musicList.iterator();
        while (it.hasNext()) {
            Musique music = (Musique) it.next();
//            String date = music.getreleaseDate().toString();
//            date = date.substring(0,4);
            if(!music.getreleaseDate().toString().substring(0,4).contains(value)) {
                it.remove();
            }
        }
        execTime.stopProfiling();

    }
    public static void filtre(int criteria, String value) {
        execTime.startProfiling();
        switch (criteria) {
            case 1:
                musicList.removeIf(f -> !f.gettrackName().toLowerCase().contains(value.toLowerCase()));
                break;
            case 2:
                musicList.removeIf(f -> !f.getartist(0).contains(value));
                break;
            case 3:
                musicList.removeIf(f -> !f.getalbumName().contains(value));
                break;
            case 4:
                musicList.removeIf(f -> !f.getreleaseDate().equals(value));
                break;
            case 5:
                musicList.removeIf(f -> !(f.getduration() == Integer.parseInt(value)));
                break;
            case 6:
                musicList.removeIf(f -> !(f.getalbumPopularity() == Integer.parseInt(value)));
                break;

        }
        execTime.stopProfiling();
    }

    public static void triSelection(List<Musique> musicList) {
        execTime.startProfiling();
        int i, j;
        int minIndex;
        for (i = 0; i < musicList.size() - 1; i++) {
            minIndex = i;
            //recherche minimum
            for (j = i + 1; j < musicList.size(); j++) {
                if (musicList.get(j).getalbumPopularity() < musicList.get(minIndex).getalbumPopularity()) {
                    minIndex = j;
                }
            }
            //echange
            if (minIndex != i) {
                Musique temp = musicList.get(i);
                musicList.set(i, musicList.get(minIndex));
                musicList.set(minIndex, temp);
            }

            if(i%10000==0) {
                System.out.println("Tri en cours... (" + i + ")/" + musicList.size());
            }
        }
        execTime.stopProfiling();
    }

    public static void triFusion(List<Musique> list) {
        execTime.startProfiling();
        if (list.size() <= 1) {
            return;
        }

        int milieu = list.size() / 2;

        List<Musique> gauche = new ArrayList<>(list.subList(0, milieu));
        List<Musique> droite = new ArrayList<>(list.subList(milieu, list.size()));

        triFusion(gauche);
        triFusion(droite);

        triFusionFusionner(list, gauche, droite);

        execTime.stopProfiling();
    }

    public static void triFusionFusionner(List<Musique> resultat, List<Musique> gauche, List<Musique> droite) {
            Iterator<Musique> itG = gauche.iterator();
            Iterator<Musique> itD = droite.iterator();
            ListIterator<Musique> itR = resultat.listIterator();

            Musique mG = null;
            Musique mD = null;

            if (itG.hasNext()) {
                mG = itG.next();
            }

            if (itD.hasNext()) {
                mD = itD.next();
            }

            while (mG != null && mD != null) {

                // comparaison
                if (mG.getalbumPopularity() <= mD.getalbumPopularity()) {
                    itR.next();
                    itR.set(mG);

                    if (itG.hasNext()) {
                        mG = itG.next();
                    } else {
                        mG = null;
                    }

                } else {
                    itR.next();
                    itR.set(mD);

                    if (itD.hasNext()) {
                        mD = itD.next();
                    } else {
                        mD = null;
                    }
                }
            }

            // reste de la liste gauche
            while (mG != null) {
                itR.next();
                itR.set(mG);

                if (itG.hasNext()) {
                    mG = itG.next();
                } else {
                    mG = null;
                }
            }

            // reste de la liste droite
            while (mD != null) {
                itR.next();
                itR.set(mD);

                if (itD.hasNext()) {
                    mD = itD.next();
                } else {
                    mD = null;
                }
            }
    }

    public static void triJava(int criteria) {
        execTime.startProfiling();
        Comparator<Musique> comparator;

        switch (criteria) {
            case 1:
                musicList.sort(Musique.compareTrackName);
                break;
            case 2:
                musicList.sort(Musique.compareAlbumName);
                break;
            case 3:
                musicList.sort(Musique.compareArtistName);
                break;
            case 4:
                musicList.sort(Musique.compareReleaseDate);
                break;
            case 5:
                musicList.sort(Musique.compareAlbumPopularity);
                break;
            case 6:
                musicList.sort(Musique.compareDuration);
                break;
            default:
                throw new IllegalArgumentException("Critère de tri inconnu : " + criteria);
        }
        execTime.stopProfiling();
    }

    public static void rechercheLineaire(String title) {
        execTime.startProfiling();
        Iterator it = musicList.iterator();

        while(it.hasNext()) {
            Musique music = (Musique) it.next();
            if(music.gettrackName().toLowerCase().contains(title.toLowerCase())) {
                music.afficher();
                execTime.stopProfiling();
                return;
            }
        }
        execTime.stopProfiling();
        System.out.println("Aucun résultat trouvé pour le titre : " + title);
    }

    public static void rechercheDichotomique(String title) {
        triJava(1); // Trier avant la  dichotomie

        execTime.startProfiling();
        int left = 0;
        int right = musicList.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            Musique midMusic = musicList.get(mid);
            int comparison = midMusic.gettrackName().compareToIgnoreCase(title);

            if (comparison == 0) {
                midMusic.afficher();
                execTime.stopProfiling();
                System.out.println("");
                return;
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println("Aucun résultat trouvé pour le titre : " + title);
    }
}
