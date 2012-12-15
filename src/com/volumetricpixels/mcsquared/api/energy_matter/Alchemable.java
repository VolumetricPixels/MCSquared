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
        this.mass = EnergyMaths.calculateMass(energy);
    }
    
    public Alchemable(MatterPrefix prefix, double mass) {
        this.mass = mass;
        this.energy = EnergyMaths.calculateEnergy(mass);
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