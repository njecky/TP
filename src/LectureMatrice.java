import java.io.*;

public class LectureMatrice {
    public static void main(String[] args) {
        try {
            FileReader fileReader = new FileReader("random.txt");
            // FileReader fileReader = new FileReader("src/moi.txt");
            BufferedReader reader = new BufferedReader(fileReader);
            while (reader.ready()) {
            String[] line = reader.readLine().split("");
            for (String s : line) {
                System.out.print(s);
            }
            System.out.println();
        }
        reader.close();
        fileReader.close();
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
    }
}
