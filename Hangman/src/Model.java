import java.util.ArrayList;

public class Model {
    private static String _answer;
    private static char[] _incorrectCharGuesses;
    private static ArrayList _incorrectGuesses;

    public static String get_answer() {
        return _answer;
    }

    public static void set_answer(String answerIn) {
        _answer = answerIn;
    }

    public static ArrayList get_incorrectGuesses() {
        return _incorrectGuesses;
    }

    public static void set_incorrectGuesses(ArrayList incorrectGuessesIn) {
        _incorrectGuesses = incorrectGuessesIn;
    }

    public static char[] get_incorrectCharGuesses() {
        return _incorrectCharGuesses;
    }

    public static void set_incorrectCharGuesses(char[] _incorrectCharGuesses) {
        Model._incorrectCharGuesses = _incorrectCharGuesses;
    }
}
