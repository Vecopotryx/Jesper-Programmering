public class MenuControl {
    public static void start(){
        menu();
    }

    public static void menu(){
        Interface.printMenu();
        switch(Input.getIntegerInput()){
            case 1:
                GameControl.startGame();
                break;
            case 2:
                Interface.printLeaderboard();
                break;
            case 3:
                System.out.println("Multiplayer selected");
                break;
            case 4:
                System.out.println("Exit selected");
                break;
        }
    }

}
