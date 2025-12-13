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
	private String[] astistsList = new String[12]; //idx 13 - 25
	
	
	public Musique(String data) {
		//The first line should always be the parameters
		int n, i;
		String currentToken;
		 
		System.out.println(data);
		StringTokenizer tok = new StringTokenizer(data,",");
		
		n = tok.countTokens();
		for(i=1 ; i<n; i++) {
			// i=1 -> passer la premi�re ligne du fichier csv
			currentToken = tok.nextToken();
			System.out.print("\033[H\033[2J");

			System.out.println(currentToken);
			switch (i) {
		        case 0: trackName = currentToken;
		        	break;
		        	
		        case 1: trackId = currentToken;
		        	break;
		        	
		        case 3: duration = Integer.parseInt(currentToken); //oblig� de parse pour changer le type de currentToken pour faire correspondre au type de l'attribut
		        	break;
		        	
		        case 4:
		        	switch(currentToken) {
		        		case "single" : albumType = -1;
        					break;
		        		case "compilation" : albumType = 0;
	        				break;
		        		case "album" : albumType = 1;
		        			break;
		        	}
		        	break;
		        	
		        case 7: albumName = currentToken;
		        	break;
		        	
		        case 8: releaseDate = LocalDateTime.parse(currentToken, f).toLocalDate();
		        	break;
		        	
		        case 10: albumPopularity = Integer.parseInt(currentToken);
		        	break;

		        // artistes
		        default:
		            if (i >= 13 && i < 25)
		                astistsList[i - 13] = currentToken;
		    }
			
		}
		System.out.println("TOKEN");
		

	}
}


