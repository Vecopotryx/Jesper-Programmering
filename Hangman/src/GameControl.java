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
                lossScreen();
                break;
            } else {
                gameScreen();
            }
        }
    }

    public static void victoryScreen(){
        Interface.printVictoryScreen();
        switch(Input.getIntegerInput()){
            case 1:
                clearVariables();
                MenuControl.start();
                break;
            case 2:
                addToLeaderboard();
                break;
            case 3:
                System.out.println("Goodbye");
                System.exit(0);
        }
    }

    public static void lossScreen() {
        Interface.printGameOverScreen();
        switch (Input.getIntegerInput()) {
            case 1:
                clearVariables();
                MenuControl.menu();
                break;
            case 2:
                System.out.println("Goodbye");
                System.exit(0);
            default:
                clearVariables();
                MenuControl.start();
                break;
        }
    }

    public static void addToLeaderboard(){
        System.out.print("Enter name: ");
        String name = Input.getStringInput();
        try{
            HandleFile.writeToFile("file.txt", name + " - " + Model._wrongGuessesAmount + " wrong guesses");

        } catch(Exception E) {
            System.out.println("An error occurred");
        }
        System.out.println("1. Go again");
        System.out.println("2. Exit");
        switch(Input.getIntegerInput()) {
            case 1:
                clearVariables();
                MenuControl.start();
                break;
            case 2:
                System.out.println("Goodbye");
                System.exit(0);
                break;
        }
    }

    public static void clearVariables(){
        Model.set_answer("");
        Model._wrongGuessesAmount = 0;
        Model._answerArray.clear();
        Model._charGuess.clear();
        Model._infoForUser = "";
        Model._displayWord = "";
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
                Model._displayWord += "_ ";
            }

        }
    }

    public static void setCustomSettings(){

    }
}
