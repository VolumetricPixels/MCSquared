package com.volumetricpixels.mcsquared.api.pipes.liquid;

import com.volumetricpixels.mcsquared.api.energy.EnergySource;
import com.volumetricpixels.mcsquared.api.pipes.PipeNode;
import java.util.Set;

public interface LiquidReceiver<T extends Liquid> extends PipeNode {
    
    public LiquidPacket<T> onReceive(EnergySource source, Set<PipeNode> visited, LiquidPacket<T> liquid);

}