import java.io.*;

public class main {

	public static void main(String[] args) throws IOException {
        int input;
        boolean mainLoop = true;
        boolean triLoop;
		//BufferedReader dataFile = fileLoader.load();
		//while(dataFile.ready()) {
			//Musique testmusique = new Musique((String) dataFile.readLine());
        // UserInterface.afficher("tri");
        System.out.println("TEST");
        while(mainLoop) {
            UserInterface.afficher("main");
            input = UserInput.input();

            switch (input) {
                case 1:
                    UserInterface.afficher("affichage");
                    input = UserInput.input();


                    break;

                case 2:
                    triLoop = true;
                    while (triLoop) {
                        UserInterface.afficher("tri");
                        input = UserInput.input();

                        switch (input) {
                            case 0:
                                triLoop = false;
                                break;
                        }
                    }
                    break;
                case 0:
                    mainLoop = false;
            }

        }

	}

}
