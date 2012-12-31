package com.volumetricpixels.mcsquared.api.energy.impl;

import com.volumetricpixels.mcsquared.api.energy.EnergyNode;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.spout.api.component.type.BlockComponent;

public abstract class EnergyNodeImpl extends BlockComponent implements EnergyNode {

    private final Set<EnergyNode> neightbours = new HashSet<EnergyNode>();
    
    @Override
    public Set<EnergyNode> getNeighbours() {
        return Collections.unmodifiableSet(neightbours);
    }
    
    @Override
    public boolean addNeighbour(EnergyNode node) {
        return getNeighbours().add(node);
    }
    
    @Override
    public boolean removeNeighbour(EnergyNode node) {
        return getNeighbours().remove(node);
    }    
}