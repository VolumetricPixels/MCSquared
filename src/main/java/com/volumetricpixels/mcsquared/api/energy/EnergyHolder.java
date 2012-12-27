package com.volumetricpixels.mcsquared.api.energy;

import org.spout.api.component.type.BlockComponent;
import org.spout.api.material.block.BlockFace;

/**
 * @author thehutch
 */
public abstract class EnergyHolder extends BlockComponent implements EnergyReceiver {
    
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

    public double getEnergyHeld() {
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
        if (energy < 0) {
            throw new IllegalArgumentException("Cannot remove negative energy!");
        } else if (energyHeld - energy < 0) {
            energyHeld = 0;
        } else {
            energyHeld -= energy;
        }
    }

    public void onEnergyReceive(double energy) {
        if (energy + getEnergyHeld() > getMaxEnergy()) {
            //Do stuff for EnergyHolder is full
        } else {
            addEnergy(energy);
        }
    }

    public void onConnect(BlockFace face, EnergyReceiver connector) {
        
    }

    public void onDisconnect(BlockFace face) {
        
    }
}
