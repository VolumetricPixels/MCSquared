package com.volumetricpixels.mcsquared.api.energy.impl;

import com.volumetricpixels.mcsquared.api.energy.Energy;
import com.volumetricpixels.mcsquared.api.energy.EnergyHolder;

public abstract class EnergyHolderImpl extends EnergyNodeImpl implements EnergyHolder {

    protected Energy maxEnergy = new Energy(Float.MAX_VALUE);
    protected Energy energyHeld = Energy.EMPTY;

    public Energy getEnergyHeld() {
        return energyHeld;
    }

    /**
     *
     * @param energy
     * @return excess energy that couldn't be added
     */
    @Override
    public Energy addEnergy(Energy energy) {
        Energy excess = Energy.EMPTY;
        if (energy.getValue() < 0) {
            throw new IllegalArgumentException("Cannot add negative energy!");
        } else if (energyHeld.add(energy).compareTo(maxEnergy) > 0) {
            excess = energyHeld.add(energy).subtract(maxEnergy);
            energyHeld = maxEnergy;
        } else {
            energyHeld = energyHeld.add(energy);
        }
        return excess;
    }

    /**
     *
     * @param energy
     * @return amount of energy that couldn't be removed
     */
    @Override
    public Energy removeEnergy(Energy energy) {
        Energy excess = Energy.EMPTY;
        if (energy.getValue() < 0) {
            throw new IllegalArgumentException("Cannot remove negative energy!");
        } else if (energyHeld.subtract(energy).getValue() < 0) {
            excess = new Energy(Math.abs(energyHeld.getValue() - energy.getValue()));
            energyHeld = Energy.EMPTY;
        } else {
            energyHeld = energyHeld.subtract(energy);
        }
        return excess;
    }
}