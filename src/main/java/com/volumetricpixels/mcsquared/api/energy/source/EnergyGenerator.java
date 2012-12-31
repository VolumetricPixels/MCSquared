package com.volumetricpixels.mcsquared.api.energy.source;

public abstract class EnergyGenerator extends EnergySource {
    protected double energyGeneration;

    public double getEnergyGeneration() {
        return energyGeneration;
    }

    public void setEnergyGeneration(double energyGeneration) {
        this.energyGeneration = energyGeneration;
    }

    @Override
    public boolean requestEnergy(double amount) {
        return true; // TODO
    }

    @Override
    public boolean sendEnergy(double amount) {
        return true; // TODO
    }
}