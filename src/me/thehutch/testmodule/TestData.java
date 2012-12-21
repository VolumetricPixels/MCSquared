package me.thehutch.testmodule;

import me.thehutch.testmodule.Windmill.WindmillInventory;
import org.spout.api.map.DefaultedKey;
import org.spout.api.map.DefaultedKeyFactory;

/**
 * @author thehutch
 */
public class TestData {
    
    private TestData() {
    }
    
    public static final DefaultedKey<WindmillInventory> WIND_MILL_INVENTORY = new DefaultedKeyFactory<WindmillInventory>("windmill_inventory", WindmillInventory.class);
    
}