import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    // Defining variables and creating a new scanner.
    static Scanner _input = new Scanner(System.in);
    static ArrayList<Integer> _guessArray = new ArrayList<>();
    static String difficulty;
    static boolean _gameStarted;
    static int _currentGuess;
    static int _correctNumber;

    public static void main(String[] args) {
        mainMenu();
    }

    /**
     * This is the main menu, the first screen the user will see when you start the game. And is also the screen the user will return to.
     */
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

    /**
     * This method calls getValue and then checks if the value returned matches one of the options. It then proceeds to execute the code for that specific operator.
     */
    public static void getSelection(){
        switch(getUserInput()){
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
            default:
                mainMenu();
                break;
        }
    }

    /**
     * This method is called when the custom mode is chosen. It prompts the user to enter a value to be used as the max value for the randomizer.
     * @return Returns the value that the user entered.
     */
    public static int customMode(){
        System.out.print("Please enter the max value: ");
        return getUserInput();
    }

    /**
     * Prints the Talspelet ASCII-logo.
     */
    public static void printLogo(){
        System.out.printf("████████╗ █████╗ ██╗     ███████╗██████╗ ███████╗██╗     ███████╗████████╗\n" +
                "╚══██╔══╝██╔══██╗██║     ██╔════╝██╔══██╗██╔════╝██║     ██╔════╝╚══██╔══╝\n" +
                "   ██║   ███████║██║     ███████╗██████╔╝█████╗  ██║     █████╗     ██║   \n" +
                "   ██║   ██╔══██║██║     ╚════██║██╔═══╝ ██╔══╝  ██║     ██╔══╝     ██║   \n" +
                "   ██║   ██║  ██║███████╗███████║██║     ███████╗███████╗███████╗   ██║   \n" +
                "   ╚═╝   ╚═╝  ╚═╝╚══════╝╚══════╝╚═╝     ╚══════╝╚══════╝╚══════╝   ╚═╝   \n" +
                "");
    }

    /**
     * This method uses the Java.util.Random class in order to generate a random value, it also makes sure that the value won't become 0 as that is used as the exit key.
     * @param maxValue This is the maximum value that can be generated.
     */
    public static void randomNumberGenerator(int maxValue){
        if(!(maxValue < 2)) {
            _correctNumber = new Random().nextInt(maxValue - 1) + 1;
        } else {
            System.out.println("The specified value was too small, please try again");
            customMode();
        }
    }

    /**
     * This is the main screen that will be shown to the user during gameplay. It displays relevant game information by calling gameInfo() and is
     */
    public static void gameScreen(){
        printLogo();
        gameInfo();
        _currentGuess = getUserInput();
        if(_currentGuess == _correctNumber){
            guessCorrect();
        } else if(_currentGuess ==  0) {
            exitRun();
        } else {
            guessWrong();
        }
    }

    /**
     * This method contains the code that will be executed when the user manages to guess the correct value. It adds the current value to the array, clears the screen and then sends the user to the victory screen.
     */
    public static void guessCorrect(){
        _guessArray.add(_currentGuess);
        clearScreen();
        victoryScreen();
    }

    /**
     * This method contains the code that will be executed if the user decides to exit the current run. It clears any specific settings from the current run and then sends the user back to the main menu.
     */
    public static void exitRun(){
        System.out.println("Exit run");
        _guessArray.clear();
        _gameStarted = false;
        mainMenu();
    }

    /**
     * This methods contains the code that will be executed every time that the guess wasn't correct.
     */
    public static void guessWrong(){
        clearScreen();
        _guessArray.add(_currentGuess);
        _gameStarted = true;
        gameScreen();
    }

    /**
     * This method is used to get user input. In order to prevent crashes, it checks if the value entered can be stored in an integer. If not, it will prompt the user to enter a valid value.
     * @return Returns the input value.
     */
    public static int getUserInput(){
        while (!_input.hasNextInt()) {
            System.out.println("Enter a valid 32-bit integer value");
            _input.next();
        }
        return _input.nextInt();
    }

    /**
     * This method is used to display contextual information in the gameScreen.
     */
    public static void gameInfo(){
        if(_gameStarted){
            ingameInfo();
        } else {
            System.out.println("Current difficulty: " + difficulty);
            System.out.println("Guess by entering a number and pressing enter");
            System.out.println("You can exit at anytime by entering 0");
        }

    }

    /**
     * This method displays things like: previous guesses, the amount of guesses, if the guess was greater or smaller than the answer and if the difficulty is easy or medium it displays hints regarding proximity.
     */
    public static void ingameInfo(){
        System.out.println(_guessArray.toString());
        System.out.println(isGreaterOrSmaller());
        System.out.println("Amount of guesses: " + _guessArray.size());
        if(difficulty.equals("Easy")){
            System.out.println(proximityHint(10));
        } else if(difficulty.equals("Medium")){
            System.out.println(proximityHint(25));
        }
    }

    /**
     * This is the method that displays the information that the user will see upon guessing the correct value.
     */
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

    /**
     * This method will ask the user if it wants to play again, and will act according to what the user decides to do.
     */
    public static void playAgain(){
        System.out.println("Play again?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        switch (getUserInput()){
            case 1:
                _guessArray.clear();
                _gameStarted = false;
                mainMenu();
                break;
            case 2:
                System.exit(0);
                break;
            default:
                System.out.println("Please pick a valid option");
                playAgain();
        }
}

    /**
     * This method "clears" the screen by printing 10 empty lines into the console.
     */
    public static void clearScreen(){
        for(int i = 0; i < 10; i++){
            System.out.println();
        }
    }

    /**
     * This method is used to get a string that contains a hint regarding the proximity between the guess and answer. This string is later displayed in the game screen.
     * @param proximityWidth The width of proximity between the guess and answer.
     * @return Returns a string containing the hint.
     */
    public static String proximityHint(int proximityWidth) {
        if ((_correctNumber - (proximityWidth / 5)) < _currentGuess && _currentGuess < (_correctNumber + (proximityWidth / 5))) {
            return "You're very close";
        } else if ((_correctNumber - proximityWidth) < _currentGuess && _currentGuess < (_correctNumber + proximityWidth)) {
            return "You're fairly close";
        } else {
            return "You're pretty far away";
        }
    }

    /**
     * This method checks whether or not the correct number is greater or smaller than the current guess.
     * @return Returns a string containing the hint.
     */
    public static String isGreaterOrSmaller(){
        if(_correctNumber > _currentGuess){
            return "The correct number is greater than " + _currentGuess;
        } else {
            return "The correct number is smaller than " + _currentGuess;
        }
    }
}
