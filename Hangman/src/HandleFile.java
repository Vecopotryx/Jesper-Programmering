import java.io.*;
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
                String data = "java";
                Scanner reader = new Scanner(fileIn);
                for(int i = 0; i < random.nextInt(1000); i++){
                    data = reader.nextLine();
                }
                if(Model.customMinLength <= data.length() && data.length() <= Model.customMaxLength){
                    Model.set_answer(data);
                } else {
                    randomFromFile(fileName);
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

    // Utilizing https://howtodoinjava.com/java/io/java-append-to-file/
    public static void writeToFile(String fileName, String textIn) throws IOException {
        BufferedWriter writer = new BufferedWriter(
                new FileWriter(fileName, true)
        );
        writer.newLine();
        writer.write(textIn);
        writer.close();
    }
}
