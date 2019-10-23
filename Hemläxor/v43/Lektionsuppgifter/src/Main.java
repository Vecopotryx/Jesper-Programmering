public class Main {

    public static void main(String[] args) {
	// Detta är en lektionsuppgift, hamnade i hemläxor då jag inte tänkte särskilt mycket när jag skapade filen.
        lol();

        min(2, 4);

        count(4);

        kelvin(20);

        ageControl(99);

        stair(4);
    }

    /**
     * Task 1, prints "HAHAHAHAHAHAHA"
     */
    public static void lol() {
        System.out.println("HAHAHAHAHAHAHA");
    }

    /**
     * Prints the smallest value out of a and b.
     * @param a - An integer
     * @param b - An integer
     * @return Returns the smallest value of a and b.
     */
    public static int min(int a, int b) {
        if(a < b){
            return a;
        }
        else {
            return b;
        }
    }

    /**
     *
     * @param n
     */
    public static void count(int n){
        for(int i = 1; i <= n; i++){
            System.out.println(i);
        }
    }

    /**
     *
     * @param celsius
     * @return
     */
    public static double kelvin(double celsius){
        double kelvin = celsius + 273.15;
        return kelvin;
    }

    /**
     * Don't judge me please, this is what the task tolddd me to do.
     * @param age
     */
    public static void ageControl(int age){
        if(0 < age && age <= 5) {
            System.out.println("Småbarn får inte göra något.");
        }
            else if(6 <= age && age <= 12) {
              System.out.println("Du får spela Fortnite.");
        }
            else if(13 <= age && age <= 14){
              System.out.println("Du är tonåring.");
        }
           else if(15 <= age && age <= 17){
                System.out.println("Du får köra moppe.");
        }
            else if(18 <= age && age <= 20){
                System.out.println("Du får köra bil.");
        }
            else if(21 <= age && age <= 64){
                System.out.println("Du får vuxenstraff om du gör något dumt.");
        }
           else if(65 <= age && age <= 99){
               System.out.println("Du är pensionär.");
        }
           else if(100 < age){
              System.out.println("R.I.P?");
        }
    }

    /**
     *
     * @param steps
     */
    public static void stair(int steps){
        for(int i = 1; i <= steps; i++) {
            for(int j = 0; j < i; j++) {
                System.out.print("X");
            }
            System.out.println();
        }
    }
}
