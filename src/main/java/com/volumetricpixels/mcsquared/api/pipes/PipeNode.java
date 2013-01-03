package com.volumetricpixels.mcsquared.api.pipes;

import java.util.Set;

public interface PipeNode {

    public Set<PipeNode> getNeighbours();

    public boolean addNeighbour(PipeNode node);

    public boolean removeNeighbour(PipeNode node);
}