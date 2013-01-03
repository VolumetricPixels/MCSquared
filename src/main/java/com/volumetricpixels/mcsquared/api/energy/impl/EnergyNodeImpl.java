package com.volumetricpixels.mcsquared.api.energy.impl;

import com.volumetricpixels.mcsquared.BlockUtils;
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

    private final Set<EnergyNode> neighbours = new HashSet<EnergyNode>();

    @Override
    public void onAttached() {
        Block neighbour;
        for (BlockFace face : BlockFaces.NESWBT) {
            neighbour = getPosition().getBlock().translate(face);
            EnergyNode node = BlockUtils.hasEither(EnergyNode.class, EnergyNodeImpl.class, neighbour);
            if (node != null) {
                addNeighbour(node);
                node.addNeighbour(this);
            }
        }
    }

    @Override
    public Set<EnergyNode> getNeighbours() {
        return Collections.unmodifiableSet(neighbours);
    }

    @Override
    public boolean addNeighbour(EnergyNode node) {
        if ((node instanceof EnergyReceiver) && (this instanceof EnergySource)) {
            ((EnergySource) this).addReceiver((EnergyReceiver) node);
        }
        return neighbours.add(node);
    }

    @Override
    public boolean removeNeighbour(EnergyNode node) {
        if ((node instanceof EnergyReceiver) && (this instanceof EnergySource)) {
            ((EnergySource) this).removeReceiver((EnergyReceiver) node);
        }
        return neighbours.remove(node);
    }
}