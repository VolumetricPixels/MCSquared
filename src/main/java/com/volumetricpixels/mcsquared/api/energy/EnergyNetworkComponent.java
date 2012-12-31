package com.volumetricpixels.mcsquared.api.energy;

/**
 * @author thehutch <th3hutch@yahoo.co.uk>
 */
public interface EnergyNetworkComponent {
    
    /**
     * Gets the network which this node is connected to.
     * 
     * @return The network which this node is connected to.
     */
    public EnergyNetwork getNetwork();
    
    /**
     * Sets the network which this node is connected to.
     * 
     * @param network The network this node will be connected to.
     */
    public void setNetwork(EnergyNetwork network);

}