public class GameControl {
    public static void startGame(){
        System.out.println(Model.get_answer());
    }

    private static void getRandomAnswer(){
        Model.set_answer("Test");
    }
}
