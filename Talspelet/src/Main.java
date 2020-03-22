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
    static String _greaterOrSmaller;
    static boolean gameStarted;
    public static void gameScreen(int correctNumber){
        Scanner currentInput = new Scanner(System.in);

        printLogo();
        if(gameStarted){
            gameInfo();
        } else {
            System.out.println("Guess by entering a number and pressing enter");
        }
        int currentGuess = currentInput.nextInt();
        if(currentGuess == 5){
            guessArray.add(currentGuess);
            _greaterOrSmaller = "";
            clearScreen();
            victoryScreen();
            gameStarted = false;
        } else if(currentGuess ==  0) {
            System.out.println("Exit run");
            gameStarted = false;
            mainMenu();
        } else {
            clearScreen();
            isGreaterOrSmaller(currentGuess,correctNumber);
            guessArray.add(currentGuess);
            gameStarted = true;
            gameScreen(correctNumber);
        }
    }

    public static void gameInfo(){
        System.out.println(guessArray.toString());
        System.out.println(_greaterOrSmaller);
        System.out.println("Amount of guesses: " + guessArray.size());
    }

    public static void victoryScreen(){
        Scanner input = new Scanner(System.in);
        System.out.printf("██╗   ██╗██╗ ██████╗████████╗ ██████╗ ██████╗ ██╗   ██╗\n" +
                "██║   ██║██║██╔════╝╚══██╔══╝██╔═══██╗██╔══██╗╚██╗ ██╔╝\n" +
                "██║   ██║██║██║        ██║   ██║   ██║██████╔╝ ╚████╔╝ \n" +
                "╚██╗ ██╔╝██║██║        ██║   ██║   ██║██╔══██╗  ╚██╔╝  \n" +
                " ╚████╔╝ ██║╚██████╗   ██║   ╚██████╔╝██║  ██║   ██║   \n" +
                "  ╚═══╝  ╚═╝ ╚═════╝   ╚═╝    ╚═════╝ ╚═╝  ╚═╝   ╚═╝   \n" +
                "");
        System.out.println(guessArray.toString());
        System.out.println("Amount of guesses: " + guessArray.size());
        System.out.println("Play again?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        switch (input.nextInt()){
            case 1:
                guessArray.clear();
                mainMenu();
                break;
            case 2:
                System.exit(0);
                break;
        }
        mainMenu();
    }

    public static void clearScreen(){
        for(int i = 0; i < 10; i++){
            System.out.println();
        }
    }

    public static void isGreaterOrSmaller(int currentGuess, int correctNumber){
        if(correctNumber > currentGuess){
            _greaterOrSmaller = "The correct number is greater than " + currentGuess;
        } else {
            _greaterOrSmaller = "The correct number is smaller than " + currentGuess;
        }
    }
}
