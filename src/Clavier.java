import java.io.*;

public class Clavier{
    public static void main(String[] args) {
        try {
            BufferedReader flux = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Entre votre prénom : ");
            String prenom = flux.readLine();
            System.out.println("Bonjour " + prenom);
            flux.close();
        } catch (Exception ioe) {
            System.err.println(ioe);
        }
    }
}