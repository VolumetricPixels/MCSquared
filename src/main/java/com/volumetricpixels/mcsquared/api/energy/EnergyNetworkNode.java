package com.volumetricpixels.mcsquared.api.energy;

/**
 * @author User
 */
public interface EnergyNetworkNode extends Connectable {

    /**
     * Used to request energy from the network
     * 
     * @param amount - Amount of energy requested
     * 
     * @return Whether the request was successful
     */
    public boolean requestEnergy(double amount);
    
    /**
     * Used to send energy into the network
     * 
     * @param amount - Amount of energy sent into the network
     * 
     * @return Whether the transfer was successful
     */
    public boolean sendEnergy(double amount);
    
}