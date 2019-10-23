public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(volume(1));
    }

    public static double volume(double radius){
        double volume = Math.PI * Math.pow(radius, 3) * 4/3;
        return volume;
    }
}
