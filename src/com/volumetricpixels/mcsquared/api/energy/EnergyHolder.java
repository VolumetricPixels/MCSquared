package com.volumetricpixels.mcsquared.api.energy;

/**
 * @author thehutch
 */
public abstract class EnergyHolder implements EnergyTransferer {

    private double maximum_energy;
    private double energy_stored;

    public EnergyHolder(double maximum_energy) {
        this.maximum_energy = maximum_energy;
    }

    public double getMaximum_energy() {
        return maximum_energy;
    }

    public void setMaximum_energy(double maximum_energy) {
        this.maximum_energy=maximum_energy;
    }
    
    public double getEnergyStored() {
        return energy_stored;
    }
    
    public void addEnergy(double energy) {
        if (energy_stored + energy <= maximum_energy && energy > 0) {
            energy_stored += energy;
        }
    }
    
    public void removeEnergy(double energy) {
        if (energy_stored - energy >= 0 && energy > 0) {
            energy_stored -= energy;
        }
    }
    
    @Override
    public void transferTo(EnergyHolder destination, double energy) {
        destination.onEnergyReceive(energy);
    }
    
    @Override
    public void onEnergyReceive(double energy) {
        if (energy + getEnergyStored() > this.getMaximum_energy()) {
            //Do stuff for wire is full
        } else {
            addEnergy(energy);
        }
    }
}