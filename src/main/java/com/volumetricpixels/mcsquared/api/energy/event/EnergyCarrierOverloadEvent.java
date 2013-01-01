package com.volumetricpixels.mcsquared.api.energy.event;

import com.volumetricpixels.mcsquared.api.energy.Energy;
import com.volumetricpixels.mcsquared.api.energy.EnergyCarrier;
import org.spout.api.event.HandlerList;

public class EnergyCarrierOverloadEvent extends EnergyEvent {

    private static HandlerList handlerList = new HandlerList();
    private final EnergyCarrier carrier;

    public EnergyCarrierOverloadEvent(Energy energy, EnergyCarrier wire) {
        super(energy);
        this.carrier = wire;
    }

    public EnergyCarrier getCarrier() {
        return carrier;
    }

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }
}