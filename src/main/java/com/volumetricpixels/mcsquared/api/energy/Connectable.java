package com.volumetricpixels.mcsquared.api.energy;

import org.spout.api.material.block.BlockFace;

/**
 * @author thehutch
 */
public interface Connectable {
    
    /**
     * Called when 
     * @param face
     * @param connector 
     */
    public void onConnect(BlockFace face, EnergyReceiver connector);

    /**
     * Called when this Connectable is destroyed
     * 
     * @param disconnected
     */
    public void onDisconnect(BlockFace face);
}