package com.volumetricpixels.mcsquared.api;

import java.util.Set;

public interface Node<T> {

	/**
	 * Gets a Set of all the connected Nodes
	 *
	 * @return All neighbours connected to this block
	 */
	public Set<? extends Node<? extends T>> getNeighbors();

	/**
	 * Add a neighbour node to this node
	 *
	 * @param node - Node to be added
	 *
	 * @return If addition of neighbour was successful
	 */
	public boolean addNeighbor(Node<? extends T> node);

	/**
	 * Remove a neighbour from this node
	 *
	 * @param node - Node to be removed
	 *
	 * @return If removal if neighbour was successful
	 */
	public boolean removeNeighbor(Node<? extends T> node);

	public Class<T> getTClass();
}
