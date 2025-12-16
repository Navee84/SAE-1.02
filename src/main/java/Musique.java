import java.time.*;
import java.time.chrono.MinguoDate;
import java.time.format.*;

public class Musique {
	private DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss 'UTC'");
	
	private String trackName; //idx 0
	private String trackId; //idx 1
	private int duration; //milisecondes //idx 3
	private int albumType; //-1 = single, 0 = compilation, 1 = album //idx 4
	private String albumName; //idx 7
	private LocalDate releaseDate; //format : aaaa-mm-dd //idx 8
	private int albumPopularity; //idx 10
	private String[] artistsList = new String[12]; //idx 12 -> 24
	
	
	public Musique(String data) {
        // constructeur
		int i;
		String currentToken;

//		System.out.println(data);
        String[] values = data.split(",");

        // Assignation des valeurs
//        System.out.println("Trackname : "+values[0]);
        trackName = values[0];
        trackId = values[1];
        //System.out.println("indice 5 :"+values[5]);
        duration = Integer.parseInt(values[3]);

        switch(values[4]) {
            case "single":
                albumType = -1;
                break;
            case "compilation":
                albumType = 0;
                break;
            case "album":
                albumType = 1;
                break;
        }
        albumName = values[7];
        releaseDate = LocalDateTime.parse(values[8], f).toLocalDate();
        albumPopularity = Integer.parseInt(values[10]);
//        System.out.println(values[12]);


        for (i=13; i<24; i++){
//            System.out.println("Artiste N°"+(i-13)+" : "+values[i]);
            artistsList[i - 13] = values[i];

        }


		for(i=0 ; i<values.length; i++) {
			currentToken = values[i];
			
		}
	}
    public void afficher() {
        int minutes = duration / 60000;
        int seconde = (duration % 60000) / 1000;

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = releaseDate.format(dateFormatter);

        String type;
        // Affiche tous les attributs de l'objet musique
        System.out.printf("%-100s", trackName);
        System.out.print("  |  ");

        System.out.printf("%2d:%02d", minutes, seconde);
        System.out.print("  |  ");

        System.out.printf("  %-10s", formattedDate);
        System.out.print("  |  ");

        System.out.printf("  %-60s", albumName);
        System.out.print("  |  ");

        // Formatage du type d'album (se référer à l'initialisation de la variable)
        if(albumType == 0){
            type = "Compilation";
        } else if (albumType < 0) {
            type = "Single";
        } else {
            type = "Album";
        }
        System.out.printf("  %-30s", type);
        System.out.print("  |  ");

        System.out.printf("  %3d  |  ", albumPopularity);
        System.out.print("  |  ");

        for(int i = 0; i<12; i++){
            if(artistsList[i]!=null){
                System.out.print(artistsList[i]);
                System.out.print("  |  ");
            }
        }
    }

    // Getter
    public String gettrackName() {
        return trackName;
    }
    public String gettrackId() {
        return trackId;
    }
    public int getduration() {
        return duration;
    }
    public int getalbumType() {
        return albumType;
    }
    public String  getalbumName() {
        return albumName;
    }
    public LocalDate getreleaseDate() {
        return releaseDate;
    }
    public int getalbumPopularity() {
        return albumPopularity;
    }
    public String getartist(int artistIndex) {
        try {
            return artistsList[artistIndex];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new ArrayIndexOutOfBoundsException("Index artiste invalide. Doit être entre 0 et 11.");
        }
    }

    // Comparators
    public static java.util.Comparator<Musique> compareTrackName = new java.util.Comparator<Musique>() {
        public int compare(Musique m1, Musique m2) {
            return m1.gettrackName().compareToIgnoreCase(m2.gettrackName());
        }
    };
    public static java.util.Comparator<Musique> compareArtistName = new java.util.Comparator<Musique>() {
        public int compare(Musique m1, Musique m2) {
            return m1.getartist(0).compareTo(m2.getartist(0));
        }
    };
    public static java.util.Comparator<Musique> compareAlbumName = new java.util.Comparator<Musique>() {
        public int compare(Musique m1, Musique m2) {
            return m1.getalbumName().compareToIgnoreCase(m2.getalbumName());
        }
    };
    public static java.util.Comparator<Musique> compareReleaseDate = new java.util.Comparator<Musique>() {
        public int compare(Musique m1, Musique m2) {
            return m1.getreleaseDate().compareTo(m2.getreleaseDate());
        }
    };
    public static java.util.Comparator<Musique> compareDuration = new java.util.Comparator<Musique>() {
        public int compare(Musique m1, Musique m2) {
            return Integer.toString(m1.getduration()).compareToIgnoreCase(Integer.toString(m2.getduration()));
        }
    };
    public static java.util.Comparator<Musique> compareAlbumPopularity = new java.util.Comparator<Musique>() {
        public int compare(Musique m1, Musique m2) {
            return Integer.toString(m1.getalbumPopularity()).compareToIgnoreCase(Integer.toString(m2.getalbumPopularity()));
        }
    };


}
