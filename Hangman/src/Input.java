import java.util.Scanner;

public class Input {
    public static Integer getIntegerInput(){
        Scanner input = new Scanner(System.in);
        while (!input.hasNextInt()) {
            System.out.println("Enter a valid 32-bit integer value");
            input.next();
        }
        return input.nextInt();
    }

    public static String getStringInput(){
        Scanner input = new Scanner(System.in);
        while (!input.hasNextLine()) {
            System.out.println("Enter a valid value");
            input.next();
        }
        return input.nextLine();
    }
}
