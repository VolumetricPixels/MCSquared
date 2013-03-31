package com.volumetricpixels.mcsquared.api.energy.electricity;

import com.volumetricpixels.mcsquared.api.energy.EnergyHolder;

public abstract class ElectricityHolderImpl extends EnergyNodeImpl<Electricity> implements EnergyHolder<Electricity> {

    protected Electricity maxEnergy = new Electricity(Float.MAX_VALUE);
    protected Electricity energyHeld = Electricity.EMPTY;

    public Electricity getEnergyHeld() {
        return energyHeld;
    }

    /**
     *
     * @param energy
     * @return excess energy that couldn't be added
     */
    @Override
    public Electricity addEnergy(Electricity energy) {
        Electricity excess = energy.newEmpty();
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
    public Electricity removeEnergy(Electricity energy) {
        Electricity excess = energy.newEmpty();
        if (energy.getValue() < 0) {
            throw new IllegalArgumentException("Cannot remove negative energy!");
        } else if (energyHeld.subtract(energy).getValue() < 0) {
            excess = new Electricity(Math.abs(energyHeld.getValue() - energy.getValue()));
            energyHeld = energy.newEmpty();
        } else {
            energyHeld = energyHeld.subtract(energy);
        }
        return excess;
    }
}