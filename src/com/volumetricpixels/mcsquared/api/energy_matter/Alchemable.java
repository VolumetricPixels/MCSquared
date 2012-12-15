package com.volumetricpixels.mcsquared.api.energy_matter;

import com.volumetricpixels.mcsquared.api.energy_matter.utils.EnergyMaths;

/**
 * @author thehutch
 */
public abstract class Alchemable {

    private double energy;
    private double mass;
    
    private EnergyPrefix energy_prefix;
    private MatterPrefix matter_prefix;
    
    public Alchemable(EnergyPrefix prefix, double energy) {
        this.energy = energy;
        this.mass = energy / EnergyMaths.SPEED_OF_LIGHT_SQUARED;
    }
    
    public Alchemable(MatterPrefix prefix, double mass) {
        this.mass = mass;
        this.energy = mass * EnergyMaths.SPEED_OF_LIGHT_SQUARED;
    }
    
    public double getEnergy() {
        return energy;
    }
    
    public double getMass() {
        return mass;
    }
    
    public EnergyPrefix getEnergyPrefix() {
        return energy_prefix;
    }
    
    public MatterPrefix getMatterPrefix() {
        return matter_prefix;
    }
}