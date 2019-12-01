public enum SolidTable {

	ICE(0.92, 2.2, 0, 334),
	IRON(7.87, 0.45, 1538, 276),
	CARBON(2.25,0.71,3600,1700),
	GOLD(19.3,0.13,1064,63),
	TITANIUM(4.51,0.52,1668,390),
	ALUMINUM(2.70,0.90,660,397),
	COBALT(8.86,0.42,1495,275),
	MAGNESIUM(1.74,1.02,650,358),
	PLATINUM(21.5,0.13,1768,103),
	URANIUM(19.1,0.12,1135,59)
	;

	double density;
	double heatCapacity;
	double meltPoint;
	double meltEntalpy;
	
	SolidTable(double d, double hc, double sp, double se) {
		density = d * 1E3;
		heatCapacity = hc * 1E3;
		meltPoint = sp;
		meltEntalpy = se * 1E3;
	}

	
}