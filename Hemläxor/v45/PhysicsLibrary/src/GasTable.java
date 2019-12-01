public enum GasTable{

	AIR(1.29, 1.01), 
	O2(1.43, 0.92), 
	OXYGEN(1.43, 0.92),
	XENON(5.89,0.16),
	CYANOGEN(2.32,1.71),
	NEON(0.900,1.03),
	HYDROGEN(0.0899,14.2),
	NITROGEN(1.250,1.04),
	HELIUM(0.178,5.2),
	CO2(1.98,0.82)
	;

	double density;
	double heatCapacity;

	GasTable(double d, double hc) {
		density = d;
		heatCapacity = hc * 1E3; // 1E3 = 1*10^3
	}

}