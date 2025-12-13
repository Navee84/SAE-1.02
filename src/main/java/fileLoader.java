import java.io.*;

public class fileLoader {
	public static BufferedReader loadFile(String filePath) throws IOException {
			BufferedReader entry = new BufferedReader(new FileReader("src/main/java/spotify_100.csv"));

			//entry.close();
			return entry;
	}

}
