package me.thehutch.mcsquared.api.energy;

/**
 * @author thehutch
 */
public interface EnergyTransferer {
    
    /**
     * Transfers the amount of energy from the current 
     * EnergyHolder into the destination.
     *
     * @param destination
     * @param energy 
     */
    public void transferTo(EnergyHolder destination, double energy);
    
    /**
     * Transfers the amount of energy from the source 
     * to the current EnergyHolder
     * 
     * @param source
     * @param energy 
     */
    public void transferFrom(EnergySource source, double energy);

}