package com.volumetricpixels.mcsquared.api.pipes.liquid;

import com.volumetricpixels.mcsquared.api.Node;
import com.volumetricpixels.mcsquared.api.energy.EnergySource;
import com.volumetricpixels.mcsquared.api.pipes.Pipeable;
import java.util.Set;

public interface LiquidReceiver<T extends Liquid> extends Node<Pipeable> {

	public LiquidPacket<T> onReceive(EnergySource source, Set<Node<Pipeable>> visited, LiquidPacket<T> liquid);
}