package com.volumetricpixels.mcsquared.api.energy.electricity;

import com.volumetricpixels.mcsquared.api.energy.EnergyNodeComponent;
import com.volumetricpixels.mcsquared.api.energy.EnergyReceiver;
import com.volumetricpixels.mcsquared.api.energy.EnergySource;
import com.volumetricpixels.mcsquared.api.energy.event.ElectricityCarrierOverloadEvent;
import com.volumetricpixels.mcsquared.api.utils.EnergyUtils;

import java.util.HashSet;
import java.util.Set;

import org.spout.api.Spout;
import org.spout.api.material.BlockMaterial;

public class ElectricityCarrier extends ElectricityNode implements EnergyReceiver<Electricity>, EnergySource<Electricity> {

	protected final Set<EnergyReceiver<Electricity>> receivers = new HashSet<>();
	protected Electricity maxEnergyTransfer = new Electricity(Float.MAX_VALUE);

	@Override
	public Electricity onReceive(EnergySource<Electricity> source, Set<EnergyNodeComponent<Electricity>> visited, Electricity energy) {
		if (maxEnergyTransfer.compareTo(energy) > 0) {
			ElectricityCarrierOverloadEvent event = new ElectricityCarrierOverloadEvent(energy, this);
			Spout.getEventManager().callEvent(event);
			if (!event.isCancelled()) {
				getBlock().getPosition().getBlock().setMaterial(BlockMaterial.AIR);
			}
			return energy;
		}
		visited.add(this);
		return EnergyUtils.safeSplit(source, energy, visited, receivers);
	}

	@Override
	public void addReceiver(EnergyReceiver<Electricity> receiver) {
		receivers.add(receiver);
	}

	@Override
	public void removeReceiver(EnergyReceiver<Electricity> receiver) {
		receivers.remove(receiver);
	}
}