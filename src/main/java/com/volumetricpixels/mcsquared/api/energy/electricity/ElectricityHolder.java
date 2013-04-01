package com.volumetricpixels.mcsquared.api.energy.electricity;

import com.volumetricpixels.mcsquared.api.energy.EnergyHolder;

public abstract class ElectricityHolder extends ElectricityNode<Electricity> implements EnergyHolder<Electricity> {

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
        Electricity excess = energyHeld.add(energy).subtract(maxEnergy);
        if (excess.getValue() > 0) {
            energyHeld = maxEnergy;
        } else {
            excess = Electricity.EMPTY;
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
        Electricity excess = Electricity.EMPTY;
        if (energyHeld.getValue() - energy.getValue() < 0) {
            excess = energy.subtract(energyHeld);
            energyHeld = Electricity.EMPTY;
        } else {
            energyHeld = energyHeld.subtract(energy);
        }
        return excess;
    }
}