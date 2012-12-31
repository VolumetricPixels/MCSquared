package com.volumetricpixels.mcsquared.api.energy;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.spout.api.component.type.BlockComponent;

public abstract class EnergyNode extends BlockComponent {

    private final Set<EnergyNode> neightbours = new HashSet<EnergyNode>();
    
    /**
     * Gets a Set of all the connected EnergyNodes
     * 
     * @return All neighbours connected to this block
     */
    public Set<EnergyNode> getNeighbours() {
        return Collections.unmodifiableSet(neightbours);
    }
    
    /**
     * Add a neighbour node to this node
     * 
     * @param node - Node to be added
     * 
     * @return If addition of neighbour was successful
     */
    public boolean addNeighbour(EnergyNode node) {
        return getNeighbours().add(node);
    }
    
    /**
     * Remove a neighbour from this node
     * 
     * @param node - Node to be removed
     * 
     * @return If removal if neighbour was successful
     */
    public boolean removeNeighbour(EnergyNode node) {
        return getNeighbours().remove(node);
    }    
}