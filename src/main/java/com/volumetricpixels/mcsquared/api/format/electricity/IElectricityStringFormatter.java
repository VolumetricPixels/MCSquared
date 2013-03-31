package com.volumetricpixels.mcsquared.api.format.electricity;


/**
 * Used for formatting values into easily human understandable strings based on
 * the electricity units and measurement types. These methods are mostly used
 * to send values to players
 */
public interface IElectricityStringFormatter {
	/**
	 * Formats a string for the given value, based on the unit and amount of
	 * decimal places. This method should use value <= MeasurementType.*.value
	 * to return a fully formatted string, such as 11.90 Microwatts, or in short
	 * format mode, 11.90 miW. This method is for strings that are to be sent to
	 * a player or admin
	 * 
	 * @param value The value to format a string for
	 * @param unit The ElectricityUnit the value is in
	 * @param dp The amount of decimal places in the string
	 * @param shortFormat Whether to use short formatting
	 * @return A formatted String for the given value and parameters
	 */
	String getFormattedString(double value, ElectricityUnit unit, int dp, boolean shortFormat);
}
