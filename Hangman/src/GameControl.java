public class GameControl {
    public static void startGame(){
        HandleFile.randomFromFile("wordlist.txt");
        System.out.println(Model.get_answer());
        System.out.println(getAnswerLength());
        populateArray();
        while(true){
            updateDisplayWord();
            if(Model.displayWord.equals(Model.get_answer())){
                victoryScreen();
                break;
            } else {
                gameScreen();
            }
        }
    }

    public static void victoryScreen(){
        System.out.println("Victory");
    }

    public static Integer getAnswerLength(){
        return Model.get_answer().length();
    }

    public static void gameScreen(){
        Interface.printGameScreen();
        String stringIn = Input.getStringInput();

        System.out.println(stringIn);
        if(stringIn.length() > 1){
            System.out.println("This application only supports entering a valid char");
        } else {
            if(Model.charGuess.contains((stringIn.toCharArray()[0]))){
                System.out.println("You've already guessed that");
                gameScreen();
            } else {
                Model.charGuess.add(stringIn.toCharArray()[0]);
            }
        }
    }

    public static void populateArray(){
        for(char c : Model.get_answer().toCharArray()) {
            Model.answerArray.add(c);
        }
    }

    public static void updateDisplayWord(){
        Model.displayWord = "";
        for(int i = 0; i < Model.answerArray.size(); i++){
            boolean isYes = false;
            for(int c = 0; c < Model.charGuess.size(); c++)
                if(Model.get_answer().toCharArray()[i] == Model.charGuess.get(c)){
                    Model.displayWord += Model.charGuess.get(c) + "";
                    isYes = true;
                }
            if(!isYes){
                Model.displayWord += "_";
            }

        }
    }
}
