package com.volumetricpixels.mcsquared.api.events;

import com.volumetricpixels.mcsquared.api.energy.EnergyNetwork;
import org.spout.api.event.HandlerList;

/**
 * @author thehutch <th3hutch@yahoo.co.uk>
 */
public class EnergyRequestEvent extends EnergyEvent {

    private static HandlerList handlers = new HandlerList();
    
    private double energyRequested;
    
    public EnergyRequestEvent(EnergyNetwork network, double energyRequested) {
        super(network);
        this.energyRequested = energyRequested;
    }
    
    public double getEnergyRequested() {
        return energyRequested;
    }
    
    public void setEnergyRequested(double energyRequested) {
        this.energyRequested = energyRequested;
    }
            
    @Override
    public HandlerList getHandlers() {
        return handlers;
    }
}