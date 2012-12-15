package com.volumetricpixels.mcsquared.api.energy_matter;

/**
 * @author thehutch
 */
public abstract class EnergyHolder implements EnergyReceiver {

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
        if (energy_stored + energy > maximum_energy) {
            energy_stored = maximum_energy;
        } else if (energy < 0) {
            throw new IllegalArgumentException("Cannot add negative energy!");
        } else {
            energy_stored += energy;
        }
    }
    
    public void removeEnergy(double energy) {
        if (energy_stored - energy < 0) {
            energy_stored = 0;
        } else if (energy < 0) {
            throw new IllegalArgumentException("Cannot remove negative energy!");
        } else {
            energy_stored -= energy;
        }
    }
    
    @Override
    public void onEnergyReceive(double energy) {
        if (energy + getEnergyStored() > this.getMaximum_energy()) {
            //Do stuff for EnergyHolder is full
        } else {
            addEnergy(energy);
        }
    }

    @Override
    public void onConnect() {
        
    }

    @Override
    public void onDisconnect() {
        
    }
}