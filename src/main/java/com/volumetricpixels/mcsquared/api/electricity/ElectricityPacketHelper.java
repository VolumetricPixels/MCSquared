package com.volumetricpixels.mcsquared.api.electricity;

import com.volumetricpixels.mcsquared.api.ElectricityPacketFactory;

/**
 * Methods for helping with electricity 'packets'. This class mostly contains
 * conversions, bit it does contain some other helpful utilities for electricity
 * packets as well
 */
public class ElectricityPacketHelper {
	// TODO: We ideally need to write JavaDocs for all these methods, but it's
	// too much effort to do right now and they will take ages. I'm just gonna
	// try and get some actual API functionality done for now

	public static IElectricityPacket getPacket(double watts, double volts) {
		return ElectricityPacketFactory.newPacket(watts / volts, volts);
	}

	public static double getJoules(double watts, double seconds) {
		return watts * seconds;
	}

	public static double getJoules(double amps, double volts, double seconds) {
		return amps * volts * seconds;
	}

	public static double getWatts(double joules, double seconds) {
		return joules / seconds;
	}

	public static double getAmps(double watts, double volts) {
		return watts / volts;
	}

	public static double getAmps(double ampHours) {
		return ampHours * 3600;
	}

	public static double getAmpsFromWattHours(double wattHours, double volts) {
		return getWatts(wattHours) / volts;
	}

	public static double getWattHours(double ampHours, double volts) {
		return ampHours * volts;
	}

	public static double getAmpHours(double amps) {
		return amps / 3600;
	}

	public static double getWattsFromAV(double amps, double volts) {
		return amps * volts;
	}

	public static double getWatts(double wattHours) {
		return wattHours * 3600;
	}

	public static double getWattHours(double watts) {
		return watts / 3600;
	}

	public static double getWattHoursFromAmps(double amps, double voltage) {
		return getWattHours(getWattsFromAV(amps, voltage));
	}

	public static double getResistance(double amps, double voltage) {
		return voltage / amps;
	}

	public static double getConductance(double amps, double voltage) {
		return amps / voltage;
	}
}
