package com.volumetricpixels.mcsquared.api.energy_matter;

import org.spout.api.material.block.BlockFace;

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
    public void onConnect(BlockFace face, EnergyReceiver connector);

    /**
     * Called when this Connectable is destroyed
     * 
     * @param disconnected
     */
    public void onDisconnect(BlockFace face);
}