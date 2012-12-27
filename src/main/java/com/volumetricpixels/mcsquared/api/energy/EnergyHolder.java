package com.volumetricpixels.mcsquared.api.energy;

import org.spout.api.component.type.BlockComponent;
import org.spout.api.material.block.BlockFace;

/**
 * @author thehutch
 * @author kitskub
 */
public abstract class EnergyHolder extends BlockComponent implements EnergyTransferer {
    
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

    /**
     * 
     * @param energy
     * @return excess energy that couldn't be added
     */
    public double addEnergy(double energy) {
        double excess = 0;
        if (energy < 0) {
            throw new IllegalArgumentException("Cannot add negative energy!");
        } else if (energyHeld + energy > maxEnergy) {
            excess = energyHeld + energy - maxEnergy;
            energyHeld = maxEnergy;
        } else {
            energyHeld += energy;
        }
        return excess;
    }

    /**
     * 
     * @param energy
     * @return amount of energy that couldn't be removed
     */
    public double removeEnergy(double energy) {
        double excess = 0;
        if (energy < 0) {
            throw new IllegalArgumentException("Cannot remove negative energy!");
        } else if (energyHeld - energy < 0) {
            excess = Math.abs(energyHeld - energy);
            energyHeld = 0;
        } else {
            energyHeld -= energy;
        }
        return excess;
    }

    public double onReceive(EnergySource source, double energy) {
        return addEnergy(energy);
    }

    public double onTransmit(EnergyReceiver destination, double energy) {
        return removeEnergy(energy);
    }

    
    public void onConnect(BlockFace face, EnergyTransferer connector) {
        
    }

    public void onDisconnect(BlockFace face) {
        
    }
}
