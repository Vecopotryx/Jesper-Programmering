import java.util.ArrayList;

public class Model {
    private static String _answer;
    private ArrayList _incorrectGuesses;

    public static String get_answer() {
        return _answer;
    }

    public static void set_answer(String answerIn) {
        _answer = answerIn;
    }

    public ArrayList get_incorrectGuesses() {
        return _incorrectGuesses;
    }

    public void set_incorrectGuesses(ArrayList _incorrectGuesses) {
        this._incorrectGuesses = _incorrectGuesses;
    }
}
