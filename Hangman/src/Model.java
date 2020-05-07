import java.util.ArrayList;

public class Model {
    private static String _answer;

    public static String get_answer() {
        return _answer;
    }

    public static void set_answer(String answerIn) {
        _answer = answerIn;
    }

    public static Integer getAnswerLength(){
        return _answer.length();
    }

    public static ArrayList<Character> _charGuess = new ArrayList<Character>();;

    public static String _displayWord = "";

    public static ArrayList<Character> _answerArray = new ArrayList<Character>();

    public static void populateArray(){
        for(char c : Model.get_answer().toCharArray()) {
            _answerArray.add(c);
        }
    }

    public static String _infoForUser = "";

    public static Integer _wrongGuessesAmount = 0;

}
