package com.volumetricpixels.mcsquared.api.energy;

import com.volumetricpixels.mcsquared.api.energy.event.EnergyCarrierOverloadEvent;
import com.volumetricpixels.mcsquared.api.energy.impl.EnergyNodeImpl;
import com.volumetricpixels.mcsquared.api.utils.EnergyUtils;
import java.util.HashSet;
import java.util.Set;
import org.spout.api.Spout;
import org.spout.api.material.BlockMaterial;

public class EnergyCarrier extends EnergyNodeImpl implements EnergyReceiver, EnergySource {

    protected final Set<EnergyReceiver> receivers = new HashSet<EnergyReceiver>();
    protected Energy maxEnergyTransfer = new Energy(Float.MAX_VALUE);

    ;

    @Override
    public Energy onReceive(EnergySource source, Set<EnergyNode> visited, Energy energy) {
        if (maxEnergyTransfer.compareTo(energy) > 0) {
            EnergyCarrierOverloadEvent event = new EnergyCarrierOverloadEvent(energy, this);
            Spout.getEventManager().callEvent(event);
            if (!event.isCancelled()) {
                getPosition().getBlock().setMaterial(BlockMaterial.AIR);
            }
            return energy;
        }
        visited.add(this);
        return EnergyUtils.safeSplit(source, energy, visited, receivers);
    }

    @Override
    public void addReceiver(EnergyReceiver receiver) {
        receivers.add(receiver);
    }

    @Override
    public void removeReceiver(EnergyReceiver receiver) {
        receivers.remove(receiver);
    }
}