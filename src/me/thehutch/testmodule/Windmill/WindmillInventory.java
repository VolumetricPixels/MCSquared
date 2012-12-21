package me.thehutch.testmodule.Windmill;

import org.spout.api.inventory.Inventory;
import org.spout.api.inventory.ItemStack;

/**
 * @author thehutch
 */
public class WindmillInventory extends Inventory {

    private static final long serialVersionUID = 1L;
    
    public static final int SIZE = 1;
    
    public WindmillInventory() {
        super(SIZE);
    }
    
    public ItemStack getSlot() {
        return get(0);
    }
    
    public void setSlot(ItemStack item) {
        set(0, item);
    }
}