package com.volumetricpixels.mcsquared.api.energy;

/**
 * @author thehutch
 */
public abstract class Transformable {
    private double energy;
    private double mass;

    /*public Transformable(double energy) {
        this.energy = energy;
        this.mass = EnergyMaths.calculateMass(energy);
    }

    public Transformable(double mass) {
        this.mass = mass;
        this.energy = EnergyMaths.calculateEnergy(mass);
    }*/

    public double getEnergy() {
        return energy;
    }

    public double getMass() {
        return mass;
    }
}