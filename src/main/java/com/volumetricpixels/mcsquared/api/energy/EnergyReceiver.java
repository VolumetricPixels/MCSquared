package com.volumetricpixels.mcsquared.api.energy;

import java.util.Set;

public interface EnergyReceiver<T extends Energy<T>> extends EnergyNode<T> {

    /**
     * Called when energy is received from a source
     *
     * @param source Source of energy
     * @param visited Nodes which have already been visited this tick
     * @param energy Amount of energy received
     * @return Energy that couldn't be received
     */
    public T onReceive(EnergySource<T> source, Set<EnergyNode<T>> visited, T energy);
}