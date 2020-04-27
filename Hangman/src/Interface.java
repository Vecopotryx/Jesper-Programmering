import java.lang.reflect.Array;
import java.util.ArrayList;

public class Interface {
    public static void printMenu(){
        printLogo();
        System.out.println("Please press one of the following keys to select");
        System.out.println("1. Start game");
        System.out.println("2. Leaderboard");
        System.out.println("3. Exit");
    }

    public static void printLogo(){
        System.out.printf("██   ██  █████  ███    ██  ██████  ███    ███  █████  ███    ██ \n" +
                "██   ██ ██   ██ ████   ██ ██       ████  ████ ██   ██ ████   ██ \n" +
                "███████ ███████ ██ ██  ██ ██   ███ ██ ████ ██ ███████ ██ ██  ██ \n" +
                "██   ██ ██   ██ ██  ██ ██ ██    ██ ██  ██  ██ ██   ██ ██  ██ ██ \n" +
                "██   ██ ██   ██ ██   ████  ██████  ██      ██ ██   ██ ██   ████ \n");
    }

    public static void printModeSelect(){

    }

    public static void printLeaderboard(){
        clearScreen();
        HandleFile.readFile("file.txt");
    }

    public static void printGameMenu(){

    }

    public static void printGameScreen(){
        System.out.println();
        System.out.println("Test123");
        System.out.println(Model.get_answer());
        displayWord();
        if(Model.charGuess.size() > 0){
            System.out.println(Model.charGuess);
        }
    }

    public static void clearScreen(){
        for(int i = 0; i < 20; i++){
            System.out.println();
            System.out.flush();
        }
    }

/*
    public static void displayWordBak(){
        String displayWord = "";
        char[] answerArray = Model.get_answer().toCharArray();
        char[] incorrectCharGuesses = Model.get_incorrectCharGuesses();
        for(int i = 0; i < GameControl.getAnswerLength(); i++){
            for(int c = 0; i < Model.get_incorrectGuesses().size(); i++){
                if(answerArray[i] == incorrectCharGuesses[c]){
                    displayWord += answerArray[i] + " ";
                } else {
                    displayWord += "_ ";
                }
            }
        }
        // I'm planning on reworking this entire thing. Just for testing atm
        System.out.println(displayWord);
    }
*/
    public ArrayList<Character> assembleWord;
    private static String displayWord = "";
    public static void displayWord(){
        //char[] answerArray = Model.get_answer().toCharArray();
        /* for(int i = 0; i < GameControl.getAnswerLength(); i++){
            for(int c = 0; i < Model.charGuess.size(); i++ ){
                if(Model.charGuess.size() < GameControl.getAnswerLength()) {
                    if (answerArray[i] == Model.charGuess.get(c)) {
                        displayWord += answerArray[i] + " ";
                        System.out.println("Yes");
                    } else {
                        displayWord += "_ ";
                    }
                }
            }
        }
        */

        ArrayList<Character> answerArray = new ArrayList<Character>();
        /*for(int i = 0; i < Model.get_answer().length(); i++){
            answerArray
        }*/
        for (char c : Model.get_answer().toCharArray()) {
            answerArray.add(c);
        }

        System.out.println(answerArray.toString());
        /*
            if(answerArray.contains())
            if(answerArray Model.charGuess
        if()
*/
        System.out.println(displayWord);
    }

    public static void displayHangman(){

    }
}
