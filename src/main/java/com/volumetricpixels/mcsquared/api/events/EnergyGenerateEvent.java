package com.volumetricpixels.mcsquared.api.events;

import com.volumetricpixels.mcsquared.api.energy.EnergyNetwork;
import org.spout.api.event.HandlerList;

/**
 * @author thehutch <th3hutch@yahoo.co.uk>
 */
public class EnergyGenerateEvent extends EnergyEvent {

    private static HandlerList handlers = new HandlerList();
    
    private double energyGenerated;
    
    public EnergyGenerateEvent(EnergyNetwork network, double energyGenerated) {
        super(network);
        this.energyGenerated = energyGenerated;
    }
    
    public double getEnergyGenerated() {
        return energyGenerated;
    }
    
    public void setEnergyGenerated(double energy) {
        this.energyGenerated = energy;
    }
    
    @Override
    public HandlerList getHandlers() {
        return handlers;
    }
}