package com.volumetricpixels.mcsquared.impl.electricity;

import com.volumetricpixels.mcsquared.api.electricity.*;

public class ElectricityPacket implements IElectricityPacket {
	private double amps;
	private double volts;

	public ElectricityPacket(double amps, double volts) {
		this.amps = amps;
		this.volts = volts;
	}

	@Override
	public double getAmps() {
		return amps;
	}

	@Override
	public double getVolts() {
		return volts;
	}

	@Override
	public double getWatts() {
		return ElectricityPacketHelper.getWattsFromAV(amps, volts);
	}

	@Override
	public double getConductance() {
		return ElectricityPacketHelper.getConductance(amps, volts);
	}

	@Override
	public double getResistance() {
		return ElectricityPacketHelper.getResistance(amps, volts);
	}

	@Override
	public ElectricityPacket clone() {
		try {
			return (ElectricityPacket) super.clone();
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}

	@Override
	public boolean equals(Object o) {
		return false;
	}

	@Override
	public int hashCode() {
		return 0;
	}

	@Override
	public String toString() {
		return "ElectricityPacket[Amps=" + amps + "Volts=" + volts + "]";
	}
}
