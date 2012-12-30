package com.volumetricpixels.mcsquared.api.energy;

import org.spout.api.component.type.BlockComponent;

public abstract class EnergyReserve extends BlockComponent implements EnergyNetworkNode {

    private EnergyNetwork connectedNetwork;
    private double energyReserve;
    private double maxEnergyReserve;
    
    public EnergyReserve(double maxEnergyReserved) {
        this.maxEnergyReserve = maxEnergyReserved;
    }
    
    public double getEnergyReserve() {
        return energyReserve;
    }
    
    public double getMaxEnergyReserve() {
        return maxEnergyReserve;
    }

    @Override
    public EnergyNetwork getNetwork() {
        return connectedNetwork;
    }

    @Override
    public void setNetwork(EnergyNetwork network) {
        this.connectedNetwork = network;
    }
    
    /**
     * Add the amount of energy to the reserve.
     * 
     * @param energy - Amount of energy to add
     * 
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
        //TODO
        return true;
    }

    @Override
    public boolean sendEnergy(double amount) {
        //TODO
        return true;
    }
}