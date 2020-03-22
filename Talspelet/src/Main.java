import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static Scanner _input = new Scanner(System.in);
    static ArrayList _guessArray = new ArrayList();
    static String difficulty;
    static String _greaterOrSmaller;
    static boolean _gameStarted;
    static int _currentGuess;

    public static void main(String[] args) {
	// write your code here
        mainMenu();
    }

    public static void mainMenu(){

        printLogo();
        System.out.println("Please press one of the following keys");
        System.out.println("1. Easy (1-100)   ");
        System.out.println("2. Medium (1-1000)");
        System.out.println("3. Difficult (1-100 000)");
        System.out.println("4. Custom");
        System.out.println("0. Exit");
        switch(_input.nextInt()){
            case 1:
                difficulty = "Easy";
                clearScreen();
                gameScreen(randomNumberGenerator(100));
                break;
            case 2:
                difficulty = "Medium";
                clearScreen();
                gameScreen(randomNumberGenerator(1000));
                break;
            case 3:
                difficulty = "Difficult";
                clearScreen();
                gameScreen(randomNumberGenerator(100000));
                break;
            case 4:
                difficulty = "Custom";
                clearScreen();
                gameScreen(randomNumberGenerator(customMode()));
                break;
            case 0:
                System.out.println("Exit selected");
                System.exit(0);
                break;

        }
    }

    public static int customMode(){
        System.out.print("Please enter the max value: ");
        return getValue();
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

    static int _correctNumber;
    public static int randomNumberGenerator(int maxValue){
        if(!(maxValue < 2)) {
            _correctNumber = new Random().nextInt(maxValue - 1) + 1;
        } else {
            System.out.println("The specified value was too small, please try again");
            customMode();
        }
        return _correctNumber;
    }

    public static void gameScreen(int correctNumber){
        printLogo();
        gameInfo();
        _currentGuess = getValue();

        if(_currentGuess == correctNumber){
            _guessArray.add(_currentGuess);

            clearScreen();
            victoryScreen();
        } else if(_currentGuess ==  0) {
            System.out.println("Exit run");
            _gameStarted = false;
            mainMenu();
        } else {
            clearScreen();
            isGreaterOrSmaller(_currentGuess,correctNumber);
            _guessArray.add(_currentGuess);
            _gameStarted = true;
            gameScreen(correctNumber);
        }
    }

    public static int getValue(){
        while (!_input.hasNextInt()) {
            System.out.println("Enter a valid 32-bit Integer value");
            _input.next();
        }
        return _input.nextInt();
    }

    public static void gameInfo(){
        if(_gameStarted){
            System.out.println(_guessArray.toString());
            System.out.println(_greaterOrSmaller);
            System.out.println("Amount of guesses: " + _guessArray.size());
            if(difficulty.equals("Easy")){
                System.out.println(proximityHint(20));
            } else if(difficulty.equals("Medium")){
                System.out.println(proximityHint(50));
            }
        } else {
            System.out.println("Current difficulty: " + difficulty + " (1-" + maxValue + ")");
            System.out.println("Guess by entering a number and pressing enter");
            System.out.println("You can exit at anytime by entering 0");
        }

    }

    public static void victoryScreen(){
        System.out.printf("██╗   ██╗██╗ ██████╗████████╗ ██████╗ ██████╗ ██╗   ██╗\n" +
                "██║   ██║██║██╔════╝╚══██╔══╝██╔═══██╗██╔══██╗╚██╗ ██╔╝\n" +
                "██║   ██║██║██║        ██║   ██║   ██║██████╔╝ ╚████╔╝ \n" +
                "╚██╗ ██╔╝██║██║        ██║   ██║   ██║██╔══██╗  ╚██╔╝  \n" +
                " ╚████╔╝ ██║╚██████╗   ██║   ╚██████╔╝██║  ██║   ██║   \n" +
                "  ╚═══╝  ╚═╝ ╚═════╝   ╚═╝    ╚═════╝ ╚═╝  ╚═╝   ╚═╝   \n" +
                "");
        System.out.println(_guessArray.toString());
        System.out.println("Amount of guesses: " + _guessArray.size());
        System.out.println("The correct answer was " + _correctNumber);
        System.out.println("Play again?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        switch (_input.nextInt()){
            case 1:
                _guessArray.clear();
                _greaterOrSmaller = "";
                _gameStarted = false;
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

    public static String proximityHint(int proximityWidth){
            if((_correctNumber - proximityWidth) < _currentGuess && _currentGuess < (_correctNumber + proximityWidth)){
                return "You're fairly close";
            } else {
                return "You're pretty far away";
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
