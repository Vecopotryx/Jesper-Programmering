public class Main {

    public static void main(String[] args) {
        volume(1);
        reverse("Hello");
        count("Hello", 'l');
        sjorovare("Hej på dig där");

    }

    /**
     *
     * @param radius Radius of the sphere
     * @return Returns the volume of the sphere
     */
    public static double volume(double radius){
        double volume = Math.PI * Math.pow(radius, 3) * 4/3;
        return volume;
    }

    /**
     *
     * @param str Input
     * @return Returns the input string reversed
     */
    public static String reverse(String str){
        String result = "";
        for(int i=str.length() - 1; i >= 0; i--){
            result = result + str.charAt(i);
        }
        return result;
    }

    /**
     *
     * @param str Input String
     * @param c Which character to look for
     * @return  Returns the amount of times the character specified appear in the string.
     */
    public static int count(String str, char c){
        char[] charArray = str.toCharArray();
        int count = 0;
        for(int i = 0; i < str.length(); i++){
            if (charArray[i] == c){
                count++;
            }
        }
        return count;
    }

    public static String sjorovare(String str){
        String returnSentence = "";
        for(int i=0; i < str.length(); i++) {
            if (!(str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'o' || str.charAt(i) == 'u')) {
                returnSentence += str.charAt(i);
            } else
                returnSentence += "o";
        }
        System.out.println(returnSentence);
        return str;
    }
}

