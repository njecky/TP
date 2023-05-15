import java.io.*;

public class LectureFichier {
    public static void main(String[] args) {
        try {
            File fichier = new File("src/moi.txt");
            FileInputStream flux = new FileInputStream(fichier);
            int c;
            while ((c = flux.read()) > -1) {
                System.out.write(c);
            }
            flux.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }       
    }
}
