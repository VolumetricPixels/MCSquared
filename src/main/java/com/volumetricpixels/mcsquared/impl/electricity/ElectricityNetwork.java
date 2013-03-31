package com.volumetricpixels.mcsquared.impl.electricity;

import com.volumetricpixels.mcsquared.api.electricity.*;
import com.volumetricpixels.mcsquared.api.energy.*;

public class ElectricityNetwork implements IEnergyNetwork {
	@Override
	public void startProduction(IEnergyNetworkMember member, IElectricityPacket packet) {
	}

	@Override
	public void startProduction(IEnergyNetworkMember member, double amps, double volts) {
	}

	@Override
	public void stopProduction(IEnergyNetworkMember member) {
	}

	@Override
	public boolean isProducing(IEnergyNetworkMember member) {
		return false;
	}

	@Override
	public void startRequesting(IEnergyNetworkMember member, IElectricityPacket packet) {
	}

	@Override
	public void startRequesting(IEnergyNetworkMember member, double amps, double volts) {
	}

	@Override
	public void stopRequesting(IEnergyNetworkMember member) {
	}

	@Override
	public boolean isRequesting(IEnergyNetworkMember member) {
		return false;
	}

	@Override
	public IElectricityPacket getProduced(IEnergyNetworkMember... excluded) {
		return null;
	}

	@Override
	public IElectricityPacket getProducedBy(IEnergyNetworkMember... members) {
		return null;
	}
}
