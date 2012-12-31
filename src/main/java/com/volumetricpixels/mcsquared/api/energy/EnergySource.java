package com.volumetricpixels.mcsquared.api.energy;

public interface EnergySource extends EnergyNode {

    /**
     * Adds the receiver to this node
     *
     * @param receiver Receiver to be added
     */
    public void addReceiver(EnergyReceiver receiver);

    /**
     * Removes the receiver from this node
     *
     * @param receiver Receiver to be removed
     */
    public void removeReceiver(EnergyReceiver receiver);
}