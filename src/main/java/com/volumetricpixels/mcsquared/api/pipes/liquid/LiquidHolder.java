package com.volumetricpixels.mcsquared.api.pipes.liquid;

import com.volumetricpixels.mcsquared.api.pipes.PipeNode;

public interface LiquidHolder extends PipeNode {
    
    public Liquid getLiquidHeld();
    
    public Liquid addLiquid();
    
    public Liquid removeLiquid();

}