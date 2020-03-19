import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        mainMenu();
    }

    public static void mainMenu(){
        Scanner input = new Scanner(System.in);

        System.out.printf("████████╗ █████╗ ██╗     ███████╗██████╗ ███████╗██╗     ███████╗████████╗\n" +
                "╚══██╔══╝██╔══██╗██║     ██╔════╝██╔══██╗██╔════╝██║     ██╔════╝╚══██╔══╝\n" +
                "   ██║   ███████║██║     ███████╗██████╔╝█████╗  ██║     █████╗     ██║   \n" +
                "   ██║   ██╔══██║██║     ╚════██║██╔═══╝ ██╔══╝  ██║     ██╔══╝     ██║   \n" +
                "   ██║   ██║  ██║███████╗███████║██║     ███████╗███████╗███████╗   ██║   \n" +
                "   ╚═╝   ╚═╝  ╚═╝╚══════╝╚══════╝╚═╝     ╚══════╝╚══════╝╚══════╝   ╚═╝   \n" +
                "");
        System.out.println("Please press one of the following keys");
        System.out.println("1. Easy (0-100)   ");
        System.out.println("2. Medium (0-100)");
        System.out.println("3. Difficult (0-100 000)");
        System.out.println("0. Exit");
        switch(input.nextInt()){
            case 1:
                System.out.println("Easy selected");
                System.out.println(randomNumberGenerator(100));
                break;
            case 2:
                System.out.println("Medium selected");
                break;
            case 3:
                System.out.println("Diffcult selected");
                break;
            case 0:
                System.out.println("Exit selected");
                System.exit(0);
                break;

        }
    }

    public static int randomNumberGenerator(int maxValue){
        return new Random().nextInt(maxValue);
    }
}
