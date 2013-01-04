package com.volumetricpixels.mcsquared.api.energy.impl;

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

public abstract class EnergyNodeImpl extends BlockComponent implements EnergyNode {

    private final Set<Node<Energy>> neighbours = new HashSet<Node<Energy>>();

    @Override
    public void onAttached() {
        Block neighbour;
        for (BlockFace face : BlockFaces.NESWBT) {
            neighbour = getPosition().getBlock().translate(face);
            Node<Energy> node = BlockUtils.hasEitherNode(EnergyNode.class, EnergyNodeImpl.class, neighbour);
            if (node != null) {
                addNeighbor(node);
                node.addNeighbor(this);
            }
        }
    }
    
    @Override
    public Set<Node<Energy>> getNeighbors() {
        return Collections.unmodifiableSet(neighbours);
    }

    @Override
    public boolean addNeighbor(Node<Energy> node) {
        if ((node instanceof EnergyReceiver) && (this instanceof EnergySource)) {
            ((EnergySource) this).addReceiver((EnergyReceiver) node);
        }
        return neighbours.add(node);
    }

    @Override
    public boolean removeNeighbor(Node<Energy> node) {
        if ((node instanceof EnergyReceiver) && (this instanceof EnergySource)) {
            ((EnergySource) this).removeReceiver((EnergyReceiver) node);
        }
        return neighbours.remove(node);
    }
}