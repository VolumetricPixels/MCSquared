package com.volumetricpixels.mcsquared.api.energy.source;

import org.spout.api.component.type.BlockComponent;

import com.volumetricpixels.mcsquared.api.energy.EnergyNetwork;
import com.volumetricpixels.mcsquared.api.energy.EnergyNetworkNode;

public abstract class EnergySource extends BlockComponent implements EnergyNetworkNode {
    private EnergyNetwork connectedNetwork;

    @Override
    public EnergyNetwork getNetwork() {
        return connectedNetwork;
    }

    @Override
    public void setNetwork(EnergyNetwork network) {
        this.connectedNetwork = network;
    }
}
