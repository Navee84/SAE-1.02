import java.io.*;

public class fileLoader {
	public static BufferedReader load() throws IOException {
			BufferedReader entry = new BufferedReader(new FileReader("test.csv"));

			//entry.close();
			return entry;
		
	}
}
