package com.volumetricpixels.mcsquared.api.energy.electricity;

import com.volumetricpixels.mcsquared.api.Node;
import com.volumetricpixels.mcsquared.api.energy.Energy;
import com.volumetricpixels.mcsquared.material.BlockUtils;
import com.volumetricpixels.mcsquared.api.energy.EnergyNode;
import com.volumetricpixels.mcsquared.api.energy.EnergyReceiver;
import com.volumetricpixels.mcsquared.api.energy.EnergySource;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.spout.api.component.type.BlockComponent;
import org.spout.api.geo.cuboid.Block;
import org.spout.api.material.block.BlockFace;
import org.spout.api.material.block.BlockFaces;

public abstract class EnergyNodeImpl<T extends Energy<T>> extends BlockComponent implements EnergyNode<T> {

    private final Set<Node<T>> neighbours = new HashSet<Node<T>>();

    @Override
    public void onAttached() {
        Block neighbour;
        for (BlockFace face : BlockFaces.NESWBT) {
            neighbour = getPosition().getBlock().translate(face);
            Node<T> node = BlockUtils.getInterfaceOrComponent(EnergyNode.class, neighbour);
            if (node != null) {
                addNeighbor(node);
                node.addNeighbor(this);
            }
        }
    }

    @Override
    public Set<Node<T>> getNeighbors() {
        return Collections.unmodifiableSet(neighbours);
    }

    @Override
    public boolean addNeighbor(Node<T> node) {
        if ((node instanceof EnergyReceiver) && (this instanceof EnergySource)) {
            ((EnergySource<T>) this).addReceiver((EnergyReceiver<T>) node);
        }
        return neighbours.add(node);
    }

    @Override
    public boolean removeNeighbor(Node<T> node) {
        if ((node instanceof EnergyReceiver) && (this instanceof EnergySource)) {
            ((EnergySource<T>) this).removeReceiver((EnergyReceiver<T>) node);
        }
        return neighbours.remove(node);
    }
}