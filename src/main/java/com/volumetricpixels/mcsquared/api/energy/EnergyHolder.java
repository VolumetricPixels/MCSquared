package com.volumetricpixels.mcsquared.api.energy;

public interface EnergyHolder extends EnergyNode {

    /**
     * Gets the energy held inside on this node
     * 
     * @return Energy held
     */
    public Energy getEnergyHeld();
    
    
    /**
     * Adds the specified energy to the given <code>EnergyHold</code>
     * 
     * @param energy
     * @return excess energy that couldn't be added
     */
    public Energy addEnergy(Energy energy) ;

    /**
     * Removes the specified energy to the given <code>EnergyHold</code>
     * 
     * @param energy
     * @return amount of energy that couldn't be removed
     */
    public Energy removeEnergy(Energy energy) ;

}