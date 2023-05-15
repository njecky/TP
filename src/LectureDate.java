import java.io.*;
import java.util.Date;
public class LectureDate {
    public static void main(String[] args) {
        try {
            File fichier = new File("random.dat");
            // File fichier = new File("src/moi.dat");
            ObjectInputStream flux = new ObjectInputStream(new FileInputStream(fichier));
            Date laDate = (Date) flux.readObject();
            System.out.println(laDate);
            flux.close();
            } catch (IOException ioe) {
            System.err.println(ioe);
            } catch (ClassNotFoundException cnfe) {
            System.err.println(cnfe);
            }
    }
}
