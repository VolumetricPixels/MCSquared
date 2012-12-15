package com.volumetricpixels.mcsquared.api.energy_matter;

/**
 * @author thehutch
 */
public interface Connectable {

    /**
     * Called when a connectable is placed
     * and tries to connect to another
     * connectable.
     * 
     * @param connected
     */
    public void onConnect();
    
    /**
     * Called when this Connectable is destroyed
     * 
     * @param disconnected
     */
    public void onDisconnect();

}