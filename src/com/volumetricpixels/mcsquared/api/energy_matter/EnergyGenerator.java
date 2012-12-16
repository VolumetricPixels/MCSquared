package com.volumetricpixels.mcsquared.api.energy_matter;

import org.spout.vanilla.component.substance.material.ViewedBlockComponent;
import org.spout.vanilla.inventory.Container;

/**
 * @author thehutch
 */
public abstract class EnergyGenerator extends ViewedBlockComponent implements Container, EnergySource {

    private double energy_generation;

    public EnergyGenerator(double energy_generation) {
        this.energy_generation = energy_generation;
    }

    public double getEnergyGeneration() {
        return energy_generation;
    }

    @Override
    public void onEnergyGenerate() {
        
    }

    @Override
    public void transferTo(EnergyReceiver destination, double energy) {
        destination.onEnergyReceive(energy);
    }


    @Override
    public void onConnect() {
        
    }
    
    @Override
    public void onDisconnect() {
        
    }
}