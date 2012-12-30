package com.volumetricpixels.mcsquared.api.energy.source;

public abstract class EnergyReserve extends EnergySource {
    private double energyReserve;
    private double maxEnergyReserve;

    public double getEnergyReserve() {
        return energyReserve;
    }

    public double getMaxEnergyReserve() {
        return maxEnergyReserve;
    }

    protected void setMaxEnergyReserve(double maxEnergyReserve) {
        this.maxEnergyReserve = maxEnergyReserve;
    }

    /**
     * Add the amount of energy to the reserve.
     * 
     * @param energy - Amount of energy to add
     * @return Excess energy
     */
    public double addEnergyToReserve(double energy) {
        double excessEnergy = 0;
        if (energy < 0) {
            throw new IllegalArgumentException("Cannot add negative energy to reserve!");
        } else if (getEnergyReserve() + energy > maxEnergyReserve) {
            energyReserve = getMaxEnergyReserve();
            excessEnergy = getEnergyReserve() + energy - getMaxEnergyReserve();
        } else {
            energyReserve += energy;
        }
        return excessEnergy;
    }

    /**
     * Remove the amount of energy from the reserve.
     * 
     * @param energy - Amount of energy to remove
     * @return Overdrawn energy
     */
    public double removeEnergyFromReserve(double energy) {
        double overdrawnEnergy = 0;
        if (energy < 0) {
            throw new IllegalArgumentException("Cannot remove negative energy from network!");
        } else if (getEnergyReserve() - energy < 0) {
            energyReserve = 0;
            overdrawnEnergy = getEnergyReserve() - energy;
        } else {
            energyReserve -= energy;
        }
        return overdrawnEnergy;
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
