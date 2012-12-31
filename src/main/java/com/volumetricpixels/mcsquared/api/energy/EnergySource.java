package com.volumetricpixels.mcsquared.api.energy;

public interface EnergySource extends EnergyNode {
    /**
     * Adds the receiver to this node
     *
     * @param destination Receiver to be added
     */
    public void addReceiver(EnergyReceiver destination);

}