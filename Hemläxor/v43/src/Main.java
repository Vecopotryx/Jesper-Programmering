public class Main {

    public static void main(String[] args) {
	// Detta är en lektionsuppgift, hamnade i hemläxor då jag inte tänkte särskilt mycket när jag skapade filen.
        lol();

        min(2, 4);
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

    public static void ageControl(int age){
    }
}
