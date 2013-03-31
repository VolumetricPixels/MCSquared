package com.volumetricpixels.mcsquared.api.format.electricity;

/**
 * Represents any unit of electricity measurement
 */
public enum ElectricityUnit {
	/** Amps */
	AMPS("Amp", "I"),
	/** Amp hours */
	AMP_HOUR("Amp Hour", "Ah"),
	/** Volts */
	VOLTS("Volt", "V"),
	/** Watts */
	WATT("Watt", "W"),
	/** Watt hours */
	WATT_HOUR("Watt Hour", "Wh"),
	/** Joules */
	JOULES("Joule", "J"),
	/** Resistance */
	RESISTANCE("Ohm", "R"),
	/** Conductance */
	CONDUCTANCE("Siemen", "S");

	private String name;
	private String symbol;

	private ElectricityUnit(String name, String symbol) {
		this.name = name;
		this.symbol = symbol;
	}

	/**
	 * Gets the singular name of this ElectricityUnit
	 * 
	 * @return This ElectricityUnit's name in singular
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets the symbol for this ElectricityUnit
	 * 
	 * @return This ElectricityUnit's symbol
	 */
	public String getSymbol() {
		return symbol;
	}

	/**
	 * Gets the plural name of this ElectricityUnit
	 * 
	 * @return This ElectricityUnit's name in plural
	 */
	public String getPlural() {
		return this.name + "s";
	}
}
