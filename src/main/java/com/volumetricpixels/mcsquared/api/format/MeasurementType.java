package com.volumetricpixels.mcsquared.api.format;

public enum MeasurementType {
	/** Micro* (e.g micrometer) */
	MICRO("Micro", "mi", 0.000001),
	/** Milli* (e.g millilitres) */
	MILLI("Milli", "m", 0.001),
	/** Kilo* (e.g kilowatts) */
	KILO("Kilo", "k", 1000),
	/** Mega* (e.g megajoules) */
	MEGA("Mega", "M", 1000000);

	public String name;
	public String symbol;
	public double value;

	private MeasurementType(String name, String symbol, double value) {
		this.name = name;
		this.symbol = symbol;
		this.value = value;
	}

	public String getName(boolean symbol) {
		if (symbol) {
			return this.symbol;
		} else {
			return name;
		}
	}

	public double process(double value) {
		return value / this.value;
	}
}
