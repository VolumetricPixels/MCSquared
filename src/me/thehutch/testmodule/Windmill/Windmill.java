package me.thehutch.testmodule.Windmill;

import com.volumetricpixels.mcsquared.api.energy_matter.EnergyGenerator;
import me.thehutch.testmodule.TestData;
import org.spout.api.entity.Player;
import org.spout.api.inventory.Inventory;
import org.spout.api.math.MathHelper;
import org.spout.vanilla.component.inventory.WindowHolder;

/**
 * @author thehutch
 */
public class Windmill extends EnergyGenerator {
    
    public Windmill() {
        
    }
    
    @Override
    public void open(Player player) {
        player.get(WindowHolder.class).openWindow(null); //TODO: Add Windmill window
    }

    @Override
    public Inventory getInventory() {
        return getData().get(TestData.WIND_MILL_INVENTORY);
    }
    
    @Override
    public void onTick(float dt) {
        float height = this.getPosition().getBlockY();
        double energy = MathHelper.clamp((height / 32), 32, 1);
        onEnergyGenerate(energy);
    }
}