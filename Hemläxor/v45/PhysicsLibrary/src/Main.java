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
        System.out.println(kineticEnergy(2,2));
        System.out.println(potentialEnergy(2,5));
        System.out.println(fallSpeed(2.5));
        System.out.println(delta(1,10));
        System.out.println(volumeToMass(FluidTable.WATER,1));
        System.out.println(volumeToMass(GasTable.AIR,1));
        System.out.println(volumeToMass(SolidTable.IRON,1));
        System.out.println(svtVelocity(10,5));
        System.out.println(svtDistance(10,5));
    }

    /**
     * Converts input value from Fahrenheit to Celsius.
     * @param fahrenheit Temperature input in Fahrenheit.
     * @return Returns the temperature in Celsius.
     */
    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32)/1.8;
    }

    /**
     * Converts input value from Kelvin to Celsius.
     * @param kelvin Temperature input in Kelvin.
     * @return Returns the temperature in Celsius.
     */
    public static double kelvinToCelsius(double kelvin) {
        return (kelvin - 273.15);
    }

    /**
     * Calculates the fluid pressure of specified fluid at a specifiedd depth.
     * @param fluid Specified fluid from enum.
     * @param deep which depth to calculate pressure at.
     * @return Returns the fluid pressure.
     */
    public static double fluidPressure(FluidTable fluid, double deep) {
        return (fluid.density * g_swe * deep);
    }

    /**
     * Calculates the pressure under water at specified depth.
     * @param deep The depth to calculate pressure at.
     * @return Returns the pressure under water at specified depth.
     */
    public static double pressureUnderWater(double deep) {
        return (FluidTable.WATER.density * g_swe * deep);
    }

    /**
     * Calculates the kinetic energy of an object using a specified mass and velocity.
     * @param mass Mass of specified object.
     * @param velocity Velocity of specified object.
     * @return Returns the kinetic energy.
     */
    public static double kineticEnergy(double mass, double velocity) {
        return (mass * Math.pow(velocity, 2))/2;
    }

    /**
     * Calculates potential energy of an object using specified mass and height.
     * @param mass Mass of specified object.
     * @param height Height of specified object.
     * @return Returns the potential energy of specified object.
     */
    public static double potentialEnergy(double mass, double height) {
        return (mass * g_swe * height);
    }

    /**
     * Calculates the speed that a falling object will reach just before hitting the ground after being dropped from a
     * specified height.
     * @param height The height that the object would be dropped from.
     * @return Returns the speed of the object.
     */
    public static double fallSpeed(double height) {
        return Math.sqrt(2*height*g_swe);
    }

    /**
     * Calculates the difference between two given values.
     * @param first First value.
     * @param last Second value.
     * @return Returns the difference between the two given values.
     */
    public static double delta(double first, double last) {
        return last - first;
    }

    /**
     * Calculates the mass of a specified volume of a specified fluid.
     * @param fluid Specified fluid from enum.
     * @param volume Volume of fluid.
     * @return Returns the mass of the fluid.
     */
    public static double volumeToMass(FluidTable fluid, double volume) {
        return fluid.density * volume;
    }

    /**
     * Calculates the mass of a specified volume of a specified gas.
     * @param gas Specified gas from enum.
     * @param volume Volume of gas.
     * @return Returns the mass of the gas.
     */
    public static double volumeToMass(GasTable gas, double volume) {
        return gas.density * volume;
    }

    /**
     * Calculates the mass of a specified volume of a specified solid.
     * @param solid Specified solid from enum.
     * @param volume Volume of solid.
     * @return Returns the mass of the solid.
     */
    public static double volumeToMass(SolidTable solid, double volume) {
        return solid.density * volume;
    }

    /**
     * Calculates the average velocity of an object using distance and time.
     * @param distance Specified distance traveled.
     * @param time The amount of time that it took to travel specified distance.
     * @return Returns the average velocity.
     */
    public static double svtVelocity(double distance, double time) {
        return distance / time;
    }

    /**
     * Calculates the distance traveled by an object using average velocity and time.
     * @param velocity The velocity of the object.
     * @param time Amount of time spent traveling.
     * @return Returns the distance traveled.
     */
    public static double svtDistance(double velocity, double time) {
        return velocity * time;
    }
}
