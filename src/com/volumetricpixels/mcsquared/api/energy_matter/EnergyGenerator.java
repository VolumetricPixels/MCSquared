package com.volumetricpixels.mcsquared.api.energy_matter;

import java.util.HashMap;
import java.util.Map;
import org.spout.api.material.block.BlockFace;
import org.spout.vanilla.component.substance.material.ViewedBlockComponent;
import org.spout.vanilla.inventory.Container;

/**
 * @author thehutch
 */
public abstract class EnergyGenerator extends ViewedBlockComponent implements Container, EnergySource {

    private final Map<BlockFace, EnergyReceiver> receivers;

    public EnergyGenerator() {
        receivers = new HashMap<BlockFace, EnergyReceiver>();
    }

    @Override
    public void onEnergyGenerate(double energy_generated) {
        double energy_distribution = energy_generated / receivers.size();
        for (BlockFace face : receivers.keySet()) {
            transferTo(receivers.get(face), energy_distribution);
        }
    }

    @Override
    public void transferTo(EnergyReceiver destination, double energy) {
        destination.onEnergyReceive(energy);
    }

    @Override
    public void onConnect(BlockFace face, EnergyReceiver connector) {
        receivers.put(face, connector);
    }

    @Override
    public void onDisconnect(BlockFace face) {
        receivers.remove(face.getOpposite());
    }
}