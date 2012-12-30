package com.volumetricpixels.mcsquared.api.energy;

import org.spout.api.component.type.BlockComponent;

/**
 * @author thehutch
 */
public abstract class EnergySource extends BlockComponent implements EnergyNetworkNode  {
    
    private EnergyNetwork connectedNetwork;
    protected double energyGeneration;
    
    public EnergySource(double energyGeneration) {
        this.energyGeneration = energyGeneration;
    }
    
    public double getEnergyGeneration() {
        return energyGeneration;
    }
    
    public void setEnergyGeneration(double energyGeneration) {
        this.energyGeneration = energyGeneration;
    }

    @Override
    public EnergyNetwork getNetwork() {
        return connectedNetwork;
    }

    @Override
    public void setNetwork(EnergyNetwork network) {
        this.connectedNetwork = network;
    }
    
    @Override
    public boolean requestEnergy(double amount) {
        return true;
    }

    @Override
    public boolean sendEnergy(double amount) {
        return true;
    }
}
