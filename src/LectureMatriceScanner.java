import java.io.*;
import java.util.*;
public class LectureMatriceScanner {
    public static void main(String[] args) {
        try {
            Scanner fileScanner = new Scanner(new File("src/moi.txt"));
            while (fileScanner.hasNextLine()) {
            Scanner lineScanner = new Scanner(fileScanner.nextLine());
            while (lineScanner.hasNext())
            System.out.print(lineScanner.next());
            System.out.println();
            }
            } catch (FileNotFoundException e) {
            e.printStackTrace();
            }
    }
}
