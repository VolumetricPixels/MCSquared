package com.volumetricpixels.mcsquared.api.energy;

import java.util.ArrayList;
import java.util.List;
import org.spout.api.component.Component;

/**
 * @author thehutch
 * @author kitskub
 */
public abstract class EnergyHolder extends Component implements EnergyTransferer {
    private double maxEnergy;
    private double energyHeld;
    protected List<EnergyReceiver> receivers = new ArrayList<EnergyReceiver>();

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
    
    public void addReceiver(EnergyReceiver receiver) {
        receivers.add(receiver);
    }
}
