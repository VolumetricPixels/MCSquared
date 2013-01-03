package com.volumetricpixels.mcsquared.material;

import org.spout.api.component.Component;
import org.spout.api.geo.cuboid.Block;

public class BlockUtils {

    public static <T extends Object> T hasInterface(Class<T> interfaceClass, Block block) {
        if (interfaceClass != null && interfaceClass.isAssignableFrom(block.getComponent().getClass())) {
            return (T) block.getComponent();
        }
        return null;
    }
    
    public static <T extends Component> T hasImplementation(Class<T> implClass, Block block) {
        if (implClass != null && implClass.isAssignableFrom(block.getComponent().getClass())) {
            BlockComponentHolderComponent comp = (BlockComponentHolderComponent) block.getComponent();
            if (comp.has(implClass)) {
                return comp.get(implClass);
            }
        }
        return null;
    }
    
    public static <T extends Object, U extends Component> T hasEither(Class<T> inte, Class<U> impl, Block block) {
        T has1 = hasInterface(inte, block);
        if (has1 != null) {
            return has1;
        }
        U has2 = hasImplementation(impl, block);
        if (has2 != null) {
            return (T) has2;
        }
        return null;
    }

}
