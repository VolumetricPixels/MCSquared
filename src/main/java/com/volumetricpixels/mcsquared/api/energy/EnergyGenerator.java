package com.volumetricpixels.mcsquared.api.energy;

import java.util.EnumMap;
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
        receivers = new EnumMap<BlockFace, EnergyReceiver>(BlockFace.class);
    }

    public abstract void onEnergyGenerate(double energy_generated);

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