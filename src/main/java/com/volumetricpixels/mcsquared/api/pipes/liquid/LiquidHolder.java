package com.volumetricpixels.mcsquared.api.pipes.liquid;

import com.volumetricpixels.mcsquared.api.pipes.PipeNode;

public interface LiquidHolder<T extends Liquid> extends PipeNode {
    
    public LiquidPacket<? extends T> getLiquidHeld();
    
    public LiquidPacket<T> addLiquid(LiquidPacket<T> amount);
    
    public LiquidPacket<T> removeLiquid(LiquidPacket<T> amount);

}