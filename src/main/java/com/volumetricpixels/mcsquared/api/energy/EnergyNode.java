package com.volumetricpixels.mcsquared.api.energy;

import java.util.Set;

public interface EnergyNode {

    /**
     * Gets a Set of all the connected EnergyNodes
     * @return 
     */
    public Set<EnergyNode> getNeighbors();
    
    public boolean addNeighbor(EnergyNode node);
    
    public boolean removeNeighbor(EnergyNode node);
    
}