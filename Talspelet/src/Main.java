import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static Scanner _input = new Scanner(System.in);
    static ArrayList<Integer> _guessArray = new ArrayList<>();
    static String difficulty;
    static String _greaterOrSmaller;
    static boolean _gameStarted;
    static int _currentGuess;
    static int _correctNumber;

    public static void main(String[] args) {
        mainMenu();
    }

    public static void mainMenu(){

        printLogo();
        System.out.println("Please press one of the following keys to select");
        System.out.println("1. Easy (1-100)   ");
        System.out.println("2. Medium (1-1000)");
        System.out.println("3. Difficult (1-100 000)");
        System.out.println("4. Custom");
        System.out.println("0. Exit");
        getSelection();
    }

    public static void getSelection(){
        switch(getValue()){
            case 1:
                difficulty = "Easy";
                clearScreen();
                randomNumberGenerator(100);
                gameScreen();
                break;
            case 2:
                difficulty = "Medium";
                clearScreen();
                randomNumberGenerator(1000);
                gameScreen();
                break;
            case 3:
                difficulty = "Difficult";
                clearScreen();
                randomNumberGenerator(100000);
                gameScreen();
                break;
            case 4:
                difficulty = "Custom";
                clearScreen();
                randomNumberGenerator(customMode());
                gameScreen();
                break;
            case 0:
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

    public static void randomNumberGenerator(int maxValue){
        if(!(maxValue < 2)) {
            _correctNumber = new Random().nextInt(maxValue - 1) + 1;
        } else {
            System.out.println("The specified value was too small, please try again");
            customMode();
        }
    }

    public static void gameScreen(){
        printLogo();
        gameInfo();
        _currentGuess = getValue();
        if(_currentGuess == _correctNumber){
            guessCorrect();
        } else if(_currentGuess ==  0) {
            exitRun();
        } else {
            guessWrong();
        }
    }

    public static void guessCorrect(){
        _guessArray.add(_currentGuess);
        clearScreen();
        victoryScreen();
    }

    public static void exitRun(){
        System.out.println("Exit run");
        _gameStarted = false;
        mainMenu();
    }

    public static void guessWrong(){
        clearScreen();
        isGreaterOrSmaller(_currentGuess,_correctNumber);
        _guessArray.add(_currentGuess);
        _gameStarted = true;
        gameScreen();
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
            ingameInfo();
        } else {
            System.out.println("Current difficulty: " + difficulty);
            System.out.println("Guess by entering a number and pressing enter");
            System.out.println("You can exit at anytime by entering 0");
        }

    }

    public static void ingameInfo(){
        System.out.println(_guessArray.toString());
        System.out.println(_greaterOrSmaller);
        System.out.println("Amount of guesses: " + _guessArray.size());
        if(difficulty.equals("Easy")){
            System.out.println(proximityHint(10));
        } else if(difficulty.equals("Medium")){
            System.out.println(proximityHint(25));
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
        System.out.println("The correct answer was " + _correctNumber);
        System.out.println(_guessArray.toString());
        System.out.println("Amount of guesses: " + _guessArray.size());
        playAgain();
    }

    public static void playAgain(){
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
    }

    public static void clearScreen(){
        for(int i = 0; i < 10; i++){
            System.out.println();
        }
    }

    public static String proximityHint(int proximityWidth) {
        if ((_correctNumber - (proximityWidth / 5)) < _currentGuess && _currentGuess < (_correctNumber + (proximityWidth / 5))) {
            return "You're very close";
        } else if ((_correctNumber - proximityWidth) < _currentGuess && _currentGuess < (_correctNumber + proximityWidth)) {
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
