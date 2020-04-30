import java.util.ArrayList;

public class Model {
    private static String _answer;

    public static String get_answer() {
        return _answer;
    }

    public static void set_answer(String answerIn) {
        _answer = answerIn;
    }

    public static ArrayList<Character> charGuess = new ArrayList<Character>();;

    public static String displayWord = "";

    public static ArrayList<Character> answerArray = new ArrayList<Character>();

}
