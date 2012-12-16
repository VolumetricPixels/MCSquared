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

    private final Map<BlockFace, EnergyReceiver> connected_receivers;
    
    public EnergyGenerator() {
        connected_receivers = new HashMap<BlockFace, EnergyReceiver>();
    }

    @Override
    public void onEnergyGenerate(double energy_generated) {
        //TODO: send energy to connected receivers
    }

    @Override
    public void transferTo(EnergyReceiver destination, double energy) {
        destination.onEnergyReceive(energy);
    }


    @Override
    public void onConnect() {
        
    }
    
    @Override
    public void onDisconnect() {
        
    }
}