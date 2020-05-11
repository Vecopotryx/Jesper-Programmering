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
                GameControl.setCustomSettings();
                break;
            case 3:
                Interface.printLeaderboard();
                if(Input.getStringInput().length()>=0){
                    start();
                }
                break;
            case 4:
                System.out.println("Goodbye");
                System.exit(0);
            default:
                Interface.clearScreen();
                start();
        }
    }

}
