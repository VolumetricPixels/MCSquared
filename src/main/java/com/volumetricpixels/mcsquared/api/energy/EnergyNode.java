package com.volumetricpixels.mcsquared.api.energy;

import java.util.Set;

public interface EnergyNode {

    /**
     * Gets a Set of all the connected EnergyNodes
     *
     * @return All neighbours connected to this block
     */
    public Set<EnergyNode> getNeighbours();

    /**
     * Add a neighbour node to this node
     *
     * @param node - Node to be added
     *
     * @return If addition of neighbour was successful
     */
    public boolean addNeighbour(EnergyNode node);

    /**
     * Remove a neighbour from this node
     *
     * @param node - Node to be removed
     *
     * @return If removal if neighbour was successful
     */
    public boolean removeNeighbour(EnergyNode node);
}