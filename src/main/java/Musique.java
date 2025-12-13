import java.time.*;
import java.time.format.*;
import java.util.*;

public class Musique {
	private DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss 'UTC'");
	
	private String trackName; //idx 0
	private String trackId; //idx 1
	//private int trackNumber;
	private int duration; //milisecondes //idx 3
	private int albumType; //-1 = single, 0 = compilation, 1 = album //idx 4 
	//private String artists;
	//private int totalTracks;
	private String albumName; //idx 7
	private LocalDate releaseDate; //idx 8
	//private String label;
	private int albumPopularity; //idx 10
	//private String albumId;
	//private String artistId;
	private String[] astistsList = new String[12]; //idx 12 - 24
	
	
	public Musique(String data) {
        // constructeur
		int i;
		String currentToken;

		System.out.println(data);
        String[] values = data.split(",");

        // Assignation des valeurs
        System.out.println("Trackname : "+values[0]);
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
        System.out.println(values[12]);


        for (i=13; i<24; i++){
            System.out.println("Artiste N°"+(i-13)+" : "+values[i]);
            astistsList[i - 13] = values[i];

        }


		for(i=0 ; i<values.length; i++) {
			currentToken = values[i];
			
		}
		System.out.println("TOKEN");
	}
}


