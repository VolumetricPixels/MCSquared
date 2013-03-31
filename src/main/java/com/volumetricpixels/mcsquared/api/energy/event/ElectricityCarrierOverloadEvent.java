package com.volumetricpixels.mcsquared.api.energy.event;

import com.volumetricpixels.mcsquared.api.energy.Energy;
import com.volumetricpixels.mcsquared.api.energy.electricity.ElectricityCarrier;
import org.spout.api.event.HandlerList;

public class ElectricityCarrierOverloadEvent extends EnergyEvent {

    private static HandlerList handlerList = new HandlerList();
    private final ElectricityCarrier carrier;

    public ElectricityCarrierOverloadEvent(Energy energy, ElectricityCarrier wire) {
        super(energy);
        this.carrier = wire;
    }

    public ElectricityCarrier getCarrier() {
        return carrier;
    }

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }
}