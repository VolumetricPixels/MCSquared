package com.volumetricpixels.mcsquared.api.electricity;

import java.util.Collection;

public interface IElectricityConductorRegistry {
	void register(IElectricityConductor conductor);

	Collection<IElectricityConductor> getConductors();

	void clearConductors();

	void resetConnections();
}
