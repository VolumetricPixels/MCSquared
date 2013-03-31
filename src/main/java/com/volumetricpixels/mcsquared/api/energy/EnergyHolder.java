package com.volumetricpixels.mcsquared.api.energy;

public interface EnergyHolder<T extends Energy<T>> extends EnergyNode<T> {

    /**
     * Gets the energy held inside on this node
     *
     * @return Energy held
     */
    public T getEnergyHeld();

    /**
     * Adds the specified energy to the given
     * <code>EnergyHold</code>
     *
     * @param energy
     * @return excess energy that couldn't be added
     */
    public T addEnergy(T energy);

    /**
     * Removes the specified energy to the given
     * <code>EnergyHold</code>
     *
     * @param energy
     * @return amount of energy that couldn't be removed
     */
    public T removeEnergy(T energy);
}