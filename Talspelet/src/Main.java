import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static ArrayList guessArray = new ArrayList();

    public static void main(String[] args) {
	// write your code here
        mainMenu();
    }

    public static void mainMenu(){
        Scanner input = new Scanner(System.in);

        printLogo();
        System.out.println("Please press one of the following keys");
        System.out.println("1. Easy (0-100)   ");
        System.out.println("2. Medium (0-1000)");
        System.out.println("3. Difficult (0-100 000)");
        System.out.println("0. Exit");
        switch(input.nextInt()){
            case 1:
                System.out.println("Easy selected");
                System.out.println();
                gameScreen(randomNumberGenerator(100));
                break;
            case 2:
                System.out.println("Medium selected");
                break;
            case 3:
                System.out.println("Difficult selected");
                break;
            case 0:
                System.out.println("Exit selected");
                System.exit(0);
                break;

        }
    }

    public static void printLogo(){
        System.out.printf("████████╗ █████╗ ██╗     ███████╗██████╗ ███████╗██╗     ███████╗████████╗\n" +
                "╚══██╔══╝██╔══██╗██║     ██╔════╝██╔══██╗██╔════╝██║     ██╔════╝╚══██╔══╝\n" +
                "   ██║   ███████║██║     ███████╗██████╔╝█████╗  ██║     █████╗     ██║   \n" +
                "   ██║   ██╔══██║██║     ╚════██║██╔═══╝ ██╔══╝  ██║     ██╔══╝     ██║   \n" +
                "   ██║   ██║  ██║███████╗███████║██║     ███████╗███████╗███████╗   ██║   \n" +
                "   ╚═╝   ╚═╝  ╚═╝╚══════╝╚══════╝╚═╝     ╚══════╝╚══════╝╚══════╝   ╚═╝   \n" +
                "");
    }
    public static int randomNumberGenerator(int maxValue){
        return new Random().nextInt(maxValue);
    }

    public static void gameScreen(int correctNumber){
        Scanner currentInput = new Scanner(System.in);
        clearScreen();
        printLogo();
        System.out.println("Amount of guesses: " + guessArray.size());
        int currentGuess = currentInput.nextInt();
        if(currentGuess == correctNumber){
            System.out.println("Correct guess");
        } else if(currentGuess ==  0) {
            System.out.println("Exit run");
            mainMenu();
        } else {
            guessArray.add(currentGuess);
            gameScreen(correctNumber);
        }
    }

    public static void clearScreen(){
        for(int i = 0; i < 10; i++){
            System.out.println();
        }
    }
}
