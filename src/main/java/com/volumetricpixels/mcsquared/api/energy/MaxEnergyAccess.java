package com.volumetricpixels.mcsquared.api.energy;

public interface MaxEnergyAccess extends MaxEnergySource {

    /**
     * Sets the maximum energy able to be stored in this node.
     *
     * @param maxEnergy Energy value to set the maximum at
     */
    public void setMaxEnergy(Energy maxEnergy);
}