package com.volumetricpixels.mcsquared.api.energy;

/**
 * @author thehutch
 */
public abstract class EnergyHolder implements EnergyTransferer {

    private double maximum_energy;

    public EnergyHolder(double maximum_energy) {
        this.maximum_energy = maximum_energy;
    }

    public double getMaximum_energy() {
        return maximum_energy;
    }

    public void setMaximum_energy(double maximum_energy) {
        this.maximum_energy=maximum_energy;
    }
    
    public abstract void onEnergyAccept(EnergySource source);
    
}