import java.time.*;
import java.time.format.*;

public class Musique {
	private DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss 'UTC'");
	
	private String trackName; //idx 0
	private String trackId; //idx 1
	private int duration; //milisecondes //idx 3
	private int albumType; //-1 = single, 0 = compilation, 1 = album //idx 4 
	private String albumName; //idx 7
	private LocalDate releaseDate; //idx 8
	private int albumPopularity; //idx 10
	private String[] artistsList = new String[12]; //idx 12 - 24
	
	
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
//		System.out.println("TOKEN");
	}

    public void afficher() {

        System.out.print(trackName);
        System.out.print("   ");

        System.out.print(duration);
        System.out.print("   ");

        System.out.print(releaseDate);
        System.out.print("   ");

        System.out.print(albumName);
        System.out.print("   ");

        if(albumType == 0){
            System.out.print("Compilation");
        } else if (albumType < 0) {
            System.out.print("Single");
        } else {
            System.out.print("Album");
        }
        System.out.print("   ");

        System.out.print(albumPopularity);
        System.out.print("   ");

        for(int i = 0; i<12; i++){
            System.out.print(artistsList[i]);
            System.out.print("   ");
        }

    }
}


