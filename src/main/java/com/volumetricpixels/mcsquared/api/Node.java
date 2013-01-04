package com.volumetricpixels.mcsquared.api;

import java.util.Set;

public interface Node<T> {
	
	/**
     * Gets a Set of all the connected Nodes
	 * @return 
     *
     * @return All neighbors connected to this block
     */
    public Set<Node<T>> getNeighbors();

    /**
     * Add a neighbor node to this node
     *
     * @param node - Node to be added
     *
     * @return If addition of neighbor was successful
     */
    public boolean addNeighbor(Node<T> node);

    /**
     * Remove a neighbor from this node
     *
     * @param node - Node to be removed
     *
     * @return If removal if neighbor was successful
     */
    public boolean removeNeighbor(Node<T> node);
}
