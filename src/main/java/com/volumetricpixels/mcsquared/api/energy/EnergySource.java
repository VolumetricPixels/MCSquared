package com.volumetricpixels.mcsquared.api.energy;

import com.volumetricpixels.mcsquared.api.Node;

public interface EnergySource extends Node<Energy> {

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