import java.util.ArrayList;

public class Model {
    private String _answer;
    private ArrayList _incorrectGuesses;

    public String get_answer() {
        return _answer;
    }

    public void set_answer(String _answer) {
        this._answer = _answer;
    }

    public ArrayList get_incorrectGuesses() {
        return _incorrectGuesses;
    }

    public void set_incorrectGuesses(ArrayList _incorrectGuesses) {
        this._incorrectGuesses = _incorrectGuesses;
    }
}
