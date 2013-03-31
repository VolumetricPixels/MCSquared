package com.volumetricpixels.mcsquared.material;

import org.spout.api.geo.cuboid.Block;

public class BlockUtils {

    public static <T> T getInterfaceOrComponent(Class<T> inte, Block block) {//TODO this sometimes creates infinite loops
        if (inte == null || block.getComponent() == null) {
            return null;
        }
        if (inte.isAssignableFrom(block.getComponent().getClass())) {
            System.out.println("Found interface");
            return (T) block.getComponent();
        }
        if (inte.isAssignableFrom(BlockComponentHolderComponent.class)) {
            BlockComponentHolderComponent comp = (BlockComponentHolderComponent) block.getComponent();
            System.out.println("Found blockcompoenentholdercomponent class");
            return (T) comp.findComponent(inte);
        }
        return null;
    }
}
