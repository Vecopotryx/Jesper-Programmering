import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HandleFile {
    // inspired by https://www.w3schools.com/java/java_files_read.asp
    public static void readFile(String fileName){
        try {
            File fileIn = new File(fileName);
            Scanner reader = new Scanner(fileIn);
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                System.out.println(data);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
