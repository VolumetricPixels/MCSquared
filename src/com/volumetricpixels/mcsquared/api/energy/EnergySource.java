package com.volumetricpixels.mcsquared.api.energy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author thehutch
 */
public abstract class EnergySource implements EnergyTransferer {
    
    private List<EnergyHolder> connected_transferables;
    private double max_energy_generation;
    private double energy_generation;
    
    public EnergySource(double energy_generation, double max_energy_generation) {
        this.energy_generation = energy_generation;
        this.max_energy_generation = max_energy_generation;
        this.connected_transferables = new ArrayList<EnergyHolder>();
    }
    
    public double getEnergyGeneration() {
        return energy_generation;
    }
    
    public void setEnergyGeneration(double energy_generation) {
        if (energy_generation > max_energy_generation) {
            this.energy_generation = max_energy_generation;
        } else if (energy_generation < 0) {
            this.energy_generation = 0;
        } else {
            this.energy_generation = energy_generation;
        }
    }
    
    public double getMaxEnergyGeneration() {
        return max_energy_generation;
    }
    
    public List<EnergyHolder> getConnectedTransferables() {
        return connected_transferables;
    }
    
    public void onEnergyGenerate() {
        double energy_distribution = getEnergyGeneration() / getConnectedTransferables().size();
        for(EnergyHolder destination : getConnectedTransferables()) {
            transferTo(destination, energy_distribution);
        }
    }
}