public class GameControl {
    public static void startGame(){
        HandleFile.randomFromFile("wordlist.txt");
        System.out.println(Model.get_answer());
    }

    private static void getRandomAnswer(){
        Model.set_answer("Test");
    }
}
