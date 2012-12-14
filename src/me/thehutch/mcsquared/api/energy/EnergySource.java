package me.thehutch.mcsquared.api.energy;

/**
 * @author thehutch
 */
public abstract class EnergySource implements EnergyTransferer {
    
    private double energy_generation;
    
    public EnergySource(double energy_generation) {
        this.energy_generation = energy_generation;
    }
    
    public final double getEnergyGeneration() {
        return energy_generation;
    }
    
    public final void setEnergyGeneration(double energy_generation) {
        this.energy_generation = energy_generation;
    }
    
    public abstract void onEnergyGenerate();

}