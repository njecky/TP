import java.io.*;;
 public class EcritureFichier {
    public static void main(String[] args) {
        try {
                File fichier = new File("src/ecrire.txt");
                FileOutputStream flux = new FileOutputStream(fichier);
                String texte = "Hello World Njecky Felix Desire!" ;

                for (int i = 0 ; i < texte.length(); i++) {
                    flux.write(texte.charAt(i));
                }
                
                flux.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
            
    }
}
