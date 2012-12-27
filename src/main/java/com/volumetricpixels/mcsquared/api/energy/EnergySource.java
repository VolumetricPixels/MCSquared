package com.volumetricpixels.mcsquared.api.energy;

import java.util.EnumMap;
import java.util.Map;
import org.spout.api.component.type.BlockComponent;
import org.spout.api.material.block.BlockFace;

/**
 * @author thehutch
 */
public abstract class EnergySource extends BlockComponent implements EnergyTransferer {

    private final Map<BlockFace, EnergyTransferer> receivers;

    public EnergySource() {
        receivers = new EnumMap<BlockFace, EnergyTransferer>(BlockFace.class);
    }

    public abstract void onEnergyGenerate(double energy_generated);

    public void transferTo(EnergyTransferer destination, double energy) {
        destination.onReceive(energy);
    }

    public void onConnect(BlockFace face, EnergyTransferer connector) {
        receivers.put(face.getOpposite(), connector);
    }

    public void onDisconnect(BlockFace face) {
        receivers.remove(face.getOpposite());
    }
}