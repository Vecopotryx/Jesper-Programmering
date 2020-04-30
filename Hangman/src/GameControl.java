import java.util.ArrayList;

public class GameControl {
    public static void startGame(){
        HandleFile.randomFromFile("wordlist.txt");
        System.out.println(Model.get_answer());
        System.out.println(getAnswerLength());
        Interface.populateArray();
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

    public static void gameScreen(){
        Interface.printGameScreen();
        Interface.displayWord();
        String stringIn = Input.getStringInput();

        System.out.println(stringIn);
        if(stringIn.length() > 1){

        } else {
            Model.charGuess.add(stringIn.toCharArray()[0]);
        }
    }
}
