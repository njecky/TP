import java.io.*;
import java.util.Date;
public class EcritureDate {
    public static void main(String[] args) {
        try {
            File fichier = new File("random.dat");
            ObjectOutputStream flux = new ObjectOutputStream(new FileOutputStream(fichier));
            flux.writeObject(new Date());
            flux.close();
        } catch (IOException ioe) {
            System.err.println(ioe);
        }    
    }
}
