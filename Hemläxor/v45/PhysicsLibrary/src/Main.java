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
        System.out.println(pressureUnderWater(10));
    }

    /**
     * Converts input value from Fahrenheit to Celsius.
     * @param fahrenheit Temperature input in Fahrenheit
     * @return Returns the temperature in Celsius
     */
    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32)/1.8;
    }

    /**
     * Converts input value from Kelvin to Celsius
     * @param kelvin Temperature input in Kelvin
     * @return Returns the temperature in Celsius
     */
    public static double kelvinToCelsius(double kelvin) {
        return (kelvin - 273.15);
    }

    /**
     * Calculates the fluid pressure of specified fluid at a specifiedd depth.
     * @param fluid Specified fluid from enum
     * @param deep which depth to calculate pressure at.
     * @return Returns the fluid pressure.
     */
    public static double fluidPressure(FluidTable fluid, double deep) {
        return (fluid.density * g_swe * deep);
    }

    /**
     * Calculates the pressure under water at specified depth
     * @param deep The depth to calculate pressure at.
     * @return Returns the pressure under water at specified depth
     */
    public static double pressureUnderWater(double deep) {
        return (FluidTable.WATER.density * g_swe * deep);
    }

    /**
     * Calculates the kinetic energy using a specified mass and velocity.
     * @param mass Mass of specified object
     * @param velocity Velocity of specified object
     * @return Returns the kinetic energy
     */
    public static double kineticEnergy(double mass, double velocity) {
        return (mass * velocity * velocity)/2;
    }
}
