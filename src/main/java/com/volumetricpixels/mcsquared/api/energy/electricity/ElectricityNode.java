package com.volumetricpixels.mcsquared.api.energy.electricity;

import com.volumetricpixels.mcsquared.api.energy.EnergyNodeComponent;

public abstract class ElectricityNode extends EnergyNodeComponent<Electricity> {

	@Override
	public Class<Electricity> getTClass() {
		return Electricity.class;
	}
}