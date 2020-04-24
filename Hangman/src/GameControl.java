import java.util.ArrayList;

public class GameControl {
    public static void startGame(){
        HandleFile.randomFromFile("wordlist.txt");
        System.out.println(Model.get_answer());
        System.out.println(getAnswerLength());
        while(true){
            gameScreen();
        }
        // char[] guesses = {'b', 'j', 'c'};
        // Model.set_incorrectCharGuesses(guesses);
        // Interface.displayWord();
    }

    private static void getRandomAnswer(){
        Model.set_answer("Test");
    }

    public static Integer getAnswerLength(){
        return Model.get_answer().length();
    }

    public static ArrayList<Character> charGuess = new ArrayList<Character>();;
    public static void gameScreen(){
        Interface.printGameScreen();
        String stringIn = Input.getStringInput();
        System.out.println(stringIn);
        if(stringIn.length() > 1){

        } else {
            charGuess.add(stringIn.toCharArray()[0]);
        }
        System.out.println(charGuess);
    }
}
