import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class HandleFile {
    // inspired by https://www.w3schools.com/java/java_files_read.asp
    public static void readFile(String fileName){
        File fileIn = new File(fileName);
        if(fileIn.exists()){
            try {
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
        } else {
            System.out.println("File doesn't exist");
        }
    }

    public static void randomFromFile(String fileName) {
        Random random = new Random();
        File fileIn = new File(fileName);
        if(fileIn.exists()){
            try {
                String data = null;
                Scanner reader = new Scanner(fileIn);
                for(int i = 0; i < random.nextInt(1000); i++){
                    data = reader.nextLine();
                }
                Model.set_answer(data);
                reader.close();
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        } else {
            System.out.println("File doesn't exist");
        }
    }
}
