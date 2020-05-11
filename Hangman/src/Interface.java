import java.util.ArrayList;

public class Interface {
    public static void printMenu(){
        printLogo();
        System.out.println("Please press one of the following keys to select");
        System.out.println("1. Random game");
        System.out.println("2. Custom game");
        System.out.println("3. Leaderboard");
        System.out.println("4. Exit");
    }

    public static void printLogo(){
        System.out.printf("██   ██  █████  ███    ██  ██████  ███    ███  █████  ███    ██ \n" +
                "██   ██ ██   ██ ████   ██ ██       ████  ████ ██   ██ ████   ██ \n" +
                "███████ ███████ ██ ██  ██ ██   ███ ██ ████ ██ ███████ ██ ██  ██ \n" +
                "██   ██ ██   ██ ██  ██ ██ ██    ██ ██  ██  ██ ██   ██ ██  ██ ██ \n" +
                "██   ██ ██   ██ ██   ████  ██████  ██      ██ ██   ██ ██   ████ \n");
    }

    public static void printCustomSettings(){
        System.out.println("Please press one of the following keys to select");
        System.out.println("1. Easy (1-3 characters)");
        System.out.println("2. Medium (3-5 characters");
        System.out.println("3. Difficult (5-8 characters)");
        System.out.println("4. Custom");
    }

    public static void printPickCustomSpan(String type){
        System.out.print("Please enter the " + type +  " length: " );
    }


    public static void printLeaderboard(){
        clearScreen();
        HandleFile.readFile("leaderboard.txt");
        System.out.println("Press any key to continue");
    }

    public static void printGameScreen(){
        clearScreen();
        System.out.println();
        System.out.println("Hangman");
        Interface.displayHangman();
        System.out.println("Current guess: " + (Model._charGuess.size()));
        System.out.println(Model._displayWord);
        if(Model._infoForUser.length() > 0){
            System.out.println(Model._infoForUser);
        }
        if(Model._charGuess.size() > 0){
            System.out.println(Model._charGuess);
        }
    }

    public static void clearScreen(){
        for(int i = 0; i < 20; i++){
            System.out.println();
            System.out.flush();
        }
    }

    public static void printVictoryScreen(){
        clearScreen();
        System.out.println();
        System.out.println("-+Victory+-");
        System.out.println("You won");
        System.out.println("The answer was: " + Model.get_answer());
        System.out.println("Amount of guesses: " + (Model._charGuess.size()));
        System.out.println("Amount of incorrect guesses: " + Model._wrongGuessesAmount);
        if(Model._charGuess.size() > 0){
            System.out.println(Model._charGuess);
        }
        System.out.println("-----------------");
        System.out.println("1. Play again");
        System.out.println("2. Add to leaderboard");
        System.out.println("3. Exit");
    }

    public static void printGameOverScreen(){
        clearScreen();
        System.out.println();
        System.out.println("-+Game Over+-");
        System.out.println("You lost");
        System.out.println("The answer was: " + Model.get_answer());
        System.out.println("Your guess was: " + Model._displayWord);
        System.out.println("Amount of guesses: " + (Model._charGuess.size()));
        System.out.println("Amount of incorrect guesses: " + Model._wrongGuessesAmount);
        System.out.println(Model._charGuess);
        System.out.println("-----------------");
        System.out.println("1. Play again");
        System.out.println("2. Exit");
    }

    public static void displayHangman(){
        ArrayList<String> str = new ArrayList<String>();
        str.add("  +---+\n" +
                "  |   |\n" +
                "      |\n" +
                "      |\n" +
                "      |\n" +
                "      |\n" +
                "=========");
        str.add("  +---+\n" +
                "  |   |\n" +
                "  O   |\n" +
                "      |\n" +
                "      |\n" +
                "      |\n" +
                "=========");
        str.add("  +---+\n" +
                "  |   |\n" +
                "  O   |\n" +
                "  |   |\n" +
                "      |\n" +
                "      |\n" +
                "=========");
        str.add("  +---+\n" +
                "  |   |\n" +
                "  O   |\n" +
                " /|   |\n" +
                "      |\n" +
                "      |\n" +
                "=========");
        str.add("  +---+\n" +
                "  |   |\n" +
                "  O   |\n" +
                " /|\\  |\n" +
                "      |\n" +
                "      |\n" +
                "=========");
        str.add("  +---+\n" +
                "  |   |\n" +
                "  O   |\n" +
                " /|\\  |\n" +
                " /    |\n" +
                "      |\n" +
                "=========");
        str.add("  +---+\n" +
                "  |   |\n" +
                "  O   |\n" +
                " /|\\  |\n" +
                " / \\  |\n" +
                "      |\n" +
                "=========");
        System.out.println(str.get(Model._wrongGuessesAmount));
    }
}
