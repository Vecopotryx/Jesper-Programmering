public class Main {

    static double g_swe = 9.82; // Acceleration of gravity in Sweden (m/s^2)
    static double G = 6.674E-11; // Gravitational constant (Nm^2 / kg^2)
    static double R = 8.3145; // Gas constant (J)
    static double p_0 = 1013.25; // Atmospheric pressure at sea-level (hPa)
    static double c = 2.99792458E8; // Speed of light in a vacuum (m/s)

    public static void main(String[] args) {
        System.out.println(fahrenheitToCelsius(50));
        System.out.println(kelvinToCelsius(0));
        System.out.println(fluidPressure(FluidTable.WATER, 10));
    }

    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32)/1.8;
    }

    public static double kelvinToCelsius(double kelvin) {
        return (kelvin - 273.15);
    }

    public static double fluidPressure(FluidTable fluid, double deep) {
        return (fluid.density * g_swe * deep);
    }
}
