package com.volumetricpixels.mcsquared.api.energy;

import com.volumetricpixels.mcsquared.api.Node;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.spout.api.component.block.BlockComponent;
import org.spout.api.geo.cuboid.Block;
import org.spout.api.material.block.BlockFace;
import org.spout.api.material.block.BlockFaces;

// TODO this needs work; generics aren't beautiful at all
public abstract class EnergyNodeComponent<T extends Energy<?>> extends BlockComponent implements Node<T> {//TODO make it an abstract class if Spout ever allows multiple block components

	private final Set<Node<? extends T>> neighbours = new HashSet<Node<? extends T>>();

	@Override
	@SuppressWarnings("unchecked")
	public void onAttached() {
		Block neighbour;
		for (BlockFace face : BlockFaces.NESWBT) {
			neighbour = getBlock().getPosition().getBlock().translate(face);
			EnergyNodeComponent<?> node = neighbour.get(EnergyNodeComponent.class);
			if (node != null) {
				addNeighbor((Node<T>) node);
				node.addNeighbor((Node<? extends T>) this);
			}
		}
	}

	@Override
	public Set<Node<? extends T>> getNeighbors() {
		return Collections.unmodifiableSet(neighbours);
	}

	@Override
	@SuppressWarnings("unchecked")
	public boolean addNeighbor(Node node) {
		if (!node.getTClass().isAssignableFrom(this.getTClass())) {
			return false;
		}
		if (node instanceof EnergyReceiver && this instanceof EnergySource) {
			((EnergySource) this).addReceiver((EnergyReceiver) node);
		}
		return neighbours.add(node);
	}

	@Override
	@SuppressWarnings("unchecked")
	public boolean removeNeighbor(Node node) {
		if (!node.getTClass().isAssignableFrom(this.getTClass())) {
			return false;
		}
		if (node instanceof EnergyReceiver && this instanceof EnergySource) {
			((EnergySource) this).removeReceiver((EnergyReceiver) node);
		}
		return neighbours.remove(node);
	}
}