
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class TrainerPersistens {

    private ArrayList<Trainer> traeners;

    public TrainerPersistens(ArrayList<Trainer> traeners) {
        this.traeners = traeners;
    }

    // Skriv trænere til fil
    public void writeTraenerToFile() {
        File traenerFile = new File("C:/Users/isabe/OneDrive/IJ/Delfinen/src/traenerPersistens.txt");

        try (FileWriter writer = new FileWriter(traenerFile)) {
            writer.write("LISTE OVER TRÆNERE\n\n");
            for (Trainer t : traeners) {
                writer.write(t.toString() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
