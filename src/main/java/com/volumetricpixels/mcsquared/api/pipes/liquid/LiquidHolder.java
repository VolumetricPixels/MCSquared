package com.volumetricpixels.mcsquared.api.pipes.liquid;

import com.volumetricpixels.mcsquared.api.Node;
import com.volumetricpixels.mcsquared.api.pipes.Pipeable;

public interface LiquidHolder<T extends Liquid> extends Node<Pipeable> {

	public LiquidPacket<? extends T> getLiquidHeld();

	public LiquidPacket<T> addLiquid(LiquidPacket<T> amount);

	public LiquidPacket<T> removeLiquid(LiquidPacket<T> amount);
}