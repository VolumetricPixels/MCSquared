package com.volumetricpixels.mcsquared.api.energy;

import java.util.Set;

public interface EnergyNode {

    /**
     * Gets a Set of all the connected EnergyNodes
     * @return 
     */
    public Set<EnergyNode> getNeighbours();
    
    public boolean addNeighbour(EnergyNode node);
    
    public boolean removeNeighbour(EnergyNode node);
    
}