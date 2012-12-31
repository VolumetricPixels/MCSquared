package com.volumetricpixels.mcsquared.api.energy;

public interface MaxEnergySource {

    /**
     * Gets the maximum energy able to be stored in this node.
     *
     * @return Maximum energy
     */
    public Energy getMaxEnergy();
}