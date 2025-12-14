import java.io.*;

public class fileLoader {
	public static BufferedReader loadFile(String filePath) throws IOException {
        System.out.println("Chosen path : "+filePath);
        BufferedReader entry = new BufferedReader(new FileReader(filePath));

			//entry.close();
			return entry;
	}

}
