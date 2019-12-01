public class Main {

    static double g_swe = 9.82; // Acceleration of gravity in Sweden (m/s^2)
    static double G = 6.674E-11; // Gravitational constant (Nm^2 / kg^2)
    static double R = 8.3145; // Gas constant (J)
    static double p_0 = 1013.25; // Atmospheric pressure at sea-level (hPa)
    static double c = 2.99792458E8; // Speed of light in a vacuum (m/s)

    // All of the data in this assignment is determined with SI-units.
    // Air resistance is neglected in all methods.
    public static void main(String[] args) {
        System.out.println("1. 60 liters of iron weighs: ");
        System.out.println(volumeToMass(SolidTable.IRON,30) + " kg");
        System.out.println("2. If someone runs at an average of 2.7 m/s for 50 minutes they will have traveled approximately: ");
        System.out.println(svtDistance(2.7, 50*60) + " meters");
        System.out.println("3. The energy required to heat 4 liters of water from 22 degrees celsius to boiling is: ");
        System.out.println(heat(FluidTable.WATER, volumeToMass(FluidTable.WATER, 4), FluidTable.WATER.boilPoint-22) + " joules");
        System.out.println("4. The total pressure 75 meters below sea level is: ");
        System.out.println(pressureUnderWater(75) + " pascal");
        System.out.println("5. A ball weighing 250 grams that is thrown straight up at a speed of 60 km/h will reach a maximum height of: ");
        System.out.println(velocityToHeight(kmPerHourToMetersPerSecond(60)) + " meters");
        System.out.println("6. The power of an engine in an car with the mass 735 kg that has a constant acceleration and does 0-100 in 4.8 seconds will have reached: ");
        System.out.println(power(work(force(735, acceleration(kmPerHourToMetersPerSecond(100), 4.8)), distance(4.8, acceleration(kmPerHourToMetersPerSecond(100), 4.8))), 4.8) + " watt");
        System.out.println("7. A ball weighing 1kg that is dropped from 12 meters and that looses 1% of it's energy for every bounce will be able to bounce ");
        System.out.println(bounceCount(1,12) + " times before not being able to bounce to above 0.5 meters");
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

    /**
     * Calculates the time that it takes to travel a specified distance at a specified velocity.
     * @param distance Distance traveled.
     * @param velocity The velocity of the object.
     * @return Returns the time that it takes to travel a specified distance at a specified velocity.
     */
    public static double svtTime(double distance, double velocity) {
        return distance / velocity;
    }

    /**
     * Calculates work using force and distance.
     * @param force Specified force.
     * @param distance The distance traveled.
     * @return Returns the work for specified force and distance.
     */
    public static double work(double force, double distance) {
        return force * distance;
    }

    /**
     * Calculates power spent with a certain work under a certain time.
     * @param work The work performed.
     * @param time The amount of time the work was performed for.
     * @return Returns the power spent.
     */
    public static double power(double work, double time) {
        return work / time;
    }

    /**
     * Calculates the required energy to heat a certain material using heat capacity, mass and difference in temperature.
     * @param solid The material specified.
     * @param mass The mass of the material.
     * @param deltaT Difference in temperature.
     * @return Returns the energy needed.
     */
    public static double heat(SolidTable solid, double mass, double deltaT) {
        return solid.heatCapacity * mass * deltaT;
    }

    /**
     * Calculates the required energy to heat a certain fluid using heat capacity, mass and difference in temperature.
     * @param fluid The fluid specified.
     * @param mass The mass of the fluid.
     * @param deltaT Difference in temperature.
     * @return Returns the energy needed.
     */
    public static double heat(FluidTable fluid, double mass, double deltaT) {
        return fluid.heatCapacity * mass * deltaT;
    }

    /**
     * Calculates the required energy to heat a certain gas using heat capacity, mass and difference in temperature.
     * @param gas The gas specified.
     * @param mass The mass of the gas.
     * @param deltaT Difference in temperature.
     * @return Returns the energy needed.
     */
    public static double heat(GasTable gas, double mass, double deltaT) {
        return gas.heatCapacity * mass * deltaT;
    }

    /**
     * Calculates the maximum height an object will reach after being straight up in the air
     * on earth with the acceleration of gravity being 9.82 m/s^2 and also ignoring air resistance.
     * @param velocity The velocity that the object will be thrown up at.
     * @return Returns the maximum height an object will reach after being thrown straight up in the air.
     */
    public static double velocityToHeight(double velocity) {
        return Math.pow(velocity, 2) / (2*g_swe); // using formula H = V^2 / 2g
    }

    /**
     * Calculates density using mass and volume.
     * @param mass The mass to calculate density of.
     * @param volume The volume of the mass.
     * @return Returns the density.
     */
    public static double density(double mass, double volume) {
        return mass / volume;
    }

    /**
     * Converts speed from km/h to m/s.
     * @param kmPerHour The speed to convert from km/h to m/s.
     * @return Returns the speed in m/s.
     */
    public static double kmPerHourToMetersPerSecond(double kmPerHour) {
        return kmPerHour / 3.6;
    }

    /**
     * Converts speed from m/s to km/h.
     * @param metersPerSecond The speed to convert from m/s to km/h.
     * @return Returns the speed in km/h.
     */
    public static double metersPerSecondToKmPerHour(double metersPerSecond) {
        return metersPerSecond * 3.6;
    }

    /**
     * Calculates the momentum of an object using mass and velocity.
     * @param mass The mass of the object.
     * @param velocity The velocity of the object.
     * @return Returns the momentum of the object.
     */
    public static double momentum(double mass, double velocity) {
        return mass * velocity;
    }

    /**
     * Calculates the impulse of a object under a constant force during a specified time.
     * @param force The constant force on the object.
     * @param deltaT The difference in time.
     * @return Returns the impulse of the object.
     */
    public static double impulse(double force, double deltaT) {
        return force * deltaT;
    }

    /**
     * Calculates the impulse of an object using mass and difference in velocity.
     * @param mass The mass of the object.
     * @param originalVelocity The velocity before collision.
     * @param velocity The velocity after.
     * @return Returns the impulse of the object.
     */
    public static double impulseLaw(double mass, double originalVelocity, double velocity) {
        return (mass * velocity) - (mass * originalVelocity);
    }

    /**
     * Calculates the pressure by using the force applied to a certain area.
     * @param force The force applied.
     * @param area The area that the force is applied to.
     * @return Returns the pressure.
     */
    public static double pressure(double force, double area) {
        return force / area;
    }

    /**
     * Calculates force using mass and acceleration.
     * @param mass The mass of the object.
     * @param acceleration The acceleration of the object.
     * @return Returns the force.
     */
    public static double force(double mass, double acceleration) {
        return mass * acceleration;
    }

    /**
     * Calculates velocity after a constant acceleration.
     * @param originVelocity The velocity before acceleration.
     * @param acceleration The acceleration of the object.
     * @param time The time spent accelerating.
     * @return Returns velocity after the acceleration.
     */
    public static double velocityAfterAcceleration(double originVelocity, double acceleration, double time) {
        return originVelocity + (acceleration * time);
    }

    /**
     * Calculates the work required to lift an object with a certain mass to a certain height.
     * @param mass The mass of the object.
     * @param height The height that the object will be elevated to.
     * @return Returns the work required.
     */
    public static double workHeight(double mass, double height) {
        return mass * g_swe * height;
    }

    /**
     * Calculates acceleration using difference in velocity and difference in time.
     * @param deltaV Difference in velocity.
     * @param deltaT Difference in time.
     * @return Returns the acceleration.
     */
    public static double acceleration(double deltaV, double deltaT) {
        return deltaV / deltaT;
    }

    /**
     * Calculates distance traveled using acceleration and time.
     * @param time The time spent accelerating.
     * @param acceleration The speed of which the object is accelerating at.
     * @return Returns the distance traveled.
     */
    public static double distance(double time, double acceleration) {
        double distance = (acceleration * Math.pow(time, 2)) / 2;
        return distance;
    }

    public static double bounceCount(double mass, double height) {
        double energy = potentialEnergy(mass, height);
        int bounces = 0;
        double i = height;

        while(i >= 0.5) {
            energy *= 0.99;
            i = energy / g_swe;
            bounces++;
        }

        return bounces;
    }
}
