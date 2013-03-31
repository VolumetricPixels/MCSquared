package com.volumetricpixels.mcsquared.impl;

import com.volumetricpixels.mcsquared.api.ElectricityPacketFactory;
import com.volumetricpixels.mcsquared.api.electricity.IElectricityPacket;
import com.volumetricpixels.mcsquared.impl.electricity.ElectricityPacket;

public class MC2ElectricityPacketFactory extends ElectricityPacketFactory {
	public MC2ElectricityPacketFactory() {
		ElectricityPacketFactory.setFactory(this);
	}

	@Override
	public IElectricityPacket newElectricityPacket(double amps, double volts) {
		return new ElectricityPacket(amps, volts);
	}
}
