public class GameControl {
    public static void startGame(){
        HandleFile.randomFromFile("wordlist.txt");
        Model.populateArray();
        while(true){
            updateDisplayWord();
            if(Model._displayWord.equals(Model.get_answer())){
                victoryScreen();
                break;
            } else if(Model._wrongGuessesAmount == 6) {
                System.out.println("Game over");
                break;
            } else {
                gameScreen();
            }
        }
    }

    public static void victoryScreen(){
        System.out.println("Victory");
    }


    public static void gameScreen(){
        Interface.printGameScreen();
        String stringIn = Input.getStringInput();
        if(stringIn.length() > 1){
            Model._infoForUser = "This application only supports entering a valid char";
        } else {
            if(!stringIn.equals("")){
                if(Model._charGuess.contains((stringIn.toCharArray()[0]))){
                    Model._infoForUser = "You've already guessed that";
                    gameScreen();
                } else if(!(Model._answerArray.contains((stringIn.toCharArray()[0])))) {
                    Model._charGuess.add(stringIn.toCharArray()[0]);
                    Model._wrongGuessesAmount += 1;
                    Model._infoForUser = "";
                } else {
                    Model._charGuess.add(stringIn.toCharArray()[0]);
                    Model._infoForUser = "";
                }
            }
        }
    }



    public static void updateDisplayWord(){
        Model._displayWord = "";
        for(int i = 0; i < Model._answerArray.size(); i++){
            boolean isYes = false;
            for(int c = 0; c < Model._charGuess.size(); c++)
                if(Model.get_answer().toCharArray()[i] == Model._charGuess.get(c)){
                    Model._displayWord += Model._charGuess.get(c) + "";
                    isYes = true;
                }
            if(!isYes){
                Model._displayWord += "_";
            }

        }
    }
}
