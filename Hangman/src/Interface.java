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
        System.out.println(displayWord);
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

    public static ArrayList<Character> answerArray = new ArrayList<Character>();
    public static void populateArray(){
        for(char c : Model.get_answer().toCharArray()) {
            answerArray.add(c);
        }
    }

    public ArrayList<Character> assembleWord;
    private static String displayWord = "";

    public static void displayWord(){
        System.out.println(answerArray.toString());
        displayWord = "";
            for(int i = 0; i < answerArray.size(); i++){
                boolean isYes = false;
                for(int c = 0; c < Model.charGuess.size(); c++)
                    if(Model.get_answer().toCharArray()[i] == Model.charGuess.get(c)){
                        displayWord += Model.charGuess.get(c);
                        isYes = true;
                }
                if(!isYes){
                    displayWord += "_";
                }

            }
        System.out.println(displayWord);

        /*
        if(answerArray.contains(guessIn)){
            for(int i = 0; i < answerArray.size(); i++){
                if(guessIn == answerArray.get(i)){

                }
            }
        } else {
            displayWord += "_ ";
        }
        System.out.println(displayWordList.toString());
        System.out.println(answerArray.toString());
        System.out.println(displayWord);
         */
    }

    public static void displayHangman(){

    }
}
