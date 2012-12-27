package com.volumetricpixels.mcsquared.api.energy;

import org.spout.api.geo.discrete.Point;

/**
 * @author thehutch
 * @author kitskub
 */
public interface Connectable {
    /**
     * Called when a connectable is placed
     * and tries to connect to another
     * connectable.
     * 
     * @param location 
     */
    public void onConnect(Point location);

    /**
     * Called when this Connectable is destroyed
     * 
     * @param location 
     */
    public void onDisconnect(Point location);
}