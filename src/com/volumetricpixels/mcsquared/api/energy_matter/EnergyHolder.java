package com.volumetricpixels.mcsquared.api.energy_matter;

import org.spout.api.material.block.BlockFace;

/**
 * @author thehutch
 */
public abstract class EnergyHolder implements EnergyReceiver {
    private double maxEnergy;
    private double energyHeld;

    public EnergyHolder(double maxEnergy) {
        this.maxEnergy = maxEnergy;
    }

    public double getMaxEnergy() {
        return maxEnergy;
    }

    public void setMaxEnergy(double maxEnergy) {
        this.maxEnergy = maxEnergy;
    }

    public double getEnergyStored() {
        return energyHeld;
    }

    public void addEnergy(double energy) {
        if (energyHeld + energy > maxEnergy) {
            energyHeld = maxEnergy;
        } else if (energy < 0) {
            throw new IllegalArgumentException("Cannot add negative energy!");
        } else {
            energyHeld += energy;
        }
    }

    public void removeEnergy(double energy) {
        if (energyHeld - energy < 0) {
            energyHeld = 0;
        } else if (energy < 0) {
            throw new IllegalArgumentException("Cannot remove negative energy!");
        } else {
            energyHeld -= energy;
        }
    }

    @Override
    public void onEnergyReceive(double energy) {
        if (energy + getEnergyStored() > getMaxEnergy()) {
            //Do stuff for EnergyHolder is full
        } else {
            addEnergy(energy);
        }
    }

    @Override
    public void onConnect(BlockFace face, EnergyReceiver connector) {

    }

    @Override
    public void onDisconnect(BlockFace face) {

    }
}