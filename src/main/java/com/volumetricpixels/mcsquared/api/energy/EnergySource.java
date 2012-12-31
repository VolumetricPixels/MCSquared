package com.volumetricpixels.mcsquared.api.energy;

public interface EnergySource extends EnergyNode {
    /**
     * Adds the receiver
     *
     * @param destination
     */
    public void addReceiver(EnergyReceiver destination);

}