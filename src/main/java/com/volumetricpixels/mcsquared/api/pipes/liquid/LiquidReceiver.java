package com.volumetricpixels.mcsquared.api.pipes.liquid;

import com.volumetricpixels.mcsquared.api.energy.EnergySource;
import com.volumetricpixels.mcsquared.api.pipes.PipeNode;
import java.util.Set;
/**
 * @author thehutch <th3hutch@yahoo.co.uk>
 */
public interface LiquidReceiver extends PipeNode {
    
    public Liquid onReceive(EnergySource source, Set<PipeNode> visited, Liquid liquid);

}