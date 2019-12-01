public enum FluidTable {

	H20(0.998, 4.19, 0, 100, 2260), 
	WATER(0.998, 4.19, 0, 100, 2260),
	H2SO4(1.84, 1.38, 10, 336, 511),
	ETHANOL(0.789,2.43,-117,78, 841),
	METHANOL(0.791,1.9,-94,65,1100),
	ACETONE(0.790,2.20,-95,56,509),
	GLYCOL(1.109,2.43,-12,199,800),
	CS2(1.263,1.0,-112,46,351)
	;

	double density;
	double heatCapacity;
	double meltPoint;
	double boilPoint;
	double steamEntalpy;
	
	FluidTable(double d, double hc, double sp, double bp, double se) {
		density = d * 1E3;
		heatCapacity = hc * 1E3;
		meltPoint = sp;
		boilPoint = bp;
		steamEntalpy = se * 1E3;
	}

}