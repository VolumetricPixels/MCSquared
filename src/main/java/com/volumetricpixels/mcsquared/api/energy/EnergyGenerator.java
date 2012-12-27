package com.volumetricpixels.mcsquared.api.energy;

import java.util.HashMap;
import java.util.Map;
import org.spout.api.material.block.BlockFace;
import org.spout.vanilla.component.substance.material.ViewedBlockComponent;
import org.spout.vanilla.inventory.Container;

/**
 * @author thehutch
 */
public abstract class EnergyGenerator extends ViewedBlockComponent implements Container, EnergyTransferer {

    private final Map<BlockFace, EnergyReceiver> receivers;

    public EnergyGenerator() {
        receivers = new HashMap<BlockFace, EnergyReceiver>();
    }

    public abstract void onEnergyGenerate(double energy_generated);

    public void transferTo(EnergyReceiver destination, double energy) {
        destination.onEnergyReceive(energy);
    }

    public void onConnect(BlockFace face, EnergyReceiver connector) {
        receivers.put(face, connector);
    }

    public void onDisconnect(BlockFace face) {
        receivers.remove(face.getOpposite());
    }
}