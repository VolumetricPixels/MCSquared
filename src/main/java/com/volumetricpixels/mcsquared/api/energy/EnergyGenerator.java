package com.volumetricpixels.mcsquared.api.energy;

import java.util.EnumMap;
import java.util.Map;
import org.spout.api.material.block.BlockFace;
import org.spout.vanilla.component.substance.material.VanillaBlockComponent;

/**
 * @author thehutch
 */
public abstract class EnergyGenerator extends VanillaBlockComponent implements EnergyTransferer {

    private final Map<BlockFace, EnergyReceiver> receivers;

    public EnergyGenerator() {
        receivers = new EnumMap<BlockFace, EnergyReceiver>(BlockFace.class);
    }

    public abstract void onEnergyGenerate(double energy_generated);

    public void transferTo(EnergyReceiver destination, double energy) {
        destination.onEnergyReceive(energy);
    }

    public void onConnect(BlockFace face, EnergyReceiver connector) {
        receivers.put(face.getOpposite(), connector);
    }

    public void onDisconnect(BlockFace face) {
        receivers.remove(face.getOpposite());
    }
}