public class MenuControl {
    public static void start(){
        menu();
    }

    public static void menu(){
        Interface.printMenu();
        switch(Input.getIntegerInput()){
            case 1:
                System.out.println("Start game selected");
                GameControl.startGame();
                break;
            case 2:
                System.out.println("Leaderboard selected");
                break;
            case 3:
                System.out.println("Exit selected");
                break;
        }
    }

    public static Integer getAnswerLength(){
        return null;
    }
}
