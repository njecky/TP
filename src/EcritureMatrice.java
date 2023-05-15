import java.io.*;
import java.util.Random;
public class EcritureMatrice {
    public static void main(String[] args) {
        try {
            FileWriter writer = new FileWriter("random.txt");
            Random generator = new Random(System.currentTimeMillis());
            for (int i = 0 ; i < 9 ; i++) {
                for (int j = 0 ; j < 9 ; j++)
                writer.write(generator.nextInt() + " ");
                writer.write("\n");
            }
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }    
    }
}
