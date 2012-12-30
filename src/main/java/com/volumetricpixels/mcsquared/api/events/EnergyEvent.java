package com.volumetricpixels.mcsquared.api.events;

import com.volumetricpixels.mcsquared.api.energy.EnergyNetwork;
import org.spout.api.event.Event;

/**
 * @author thehutch <th3hutch@yahoo.co.uk>
 */
public abstract class EnergyEvent extends Event {
    
    private final EnergyNetwork network;
    
    public EnergyEvent(EnergyNetwork network) {
        this.network = network;
    }
    
    public final EnergyNetwork getNetwork() {
        return network;
    }
}