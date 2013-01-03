package com.volumetricpixels.mcsquared;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.spout.api.component.type.BlockComponent;
import org.spout.api.entity.Entity;
import org.spout.api.event.Cause;
import org.spout.api.event.player.PlayerInteractEvent;
import org.spout.api.geo.LoadOption;
import org.spout.api.geo.cuboid.Block;
import org.spout.api.geo.discrete.Point;
import org.spout.api.material.BlockMaterial;
import org.spout.api.material.ComplexMaterial;
import org.spout.api.material.Material;
import org.spout.api.material.block.BlockFace;

public abstract class BlockEntityMaterial extends BlockMaterial implements ComplexMaterial {
    private final Collection<Class<? extends BlockComponent>> componentTypes;

    public BlockEntityMaterial(String name, List<Class<? extends BlockComponent>> component, String model) {
        super((short) 0, name, model);
        this.componentTypes = component;
    }

    public BlockEntityMaterial(String name, int data, Material parent, String model, List<Class<? extends BlockComponent>> component) {
        super(name, data, parent, model);
        this.componentTypes = component;
    }

    public BlockEntityMaterial(String name, List<Class<? extends BlockComponent>> component) {
        super(name);
        this.componentTypes = component;
    }

    public BlockEntityMaterial(String name, short id, List<Class<? extends BlockComponent>> component) {
        super(name, id);
        this.componentTypes = component;
        
    }

    public BlockComponentHolderComponent spawn(Point pos) {
        return pos.getWorld().createAndSpawnEntity(pos, BlockComponentHolderComponent.class, LoadOption.NO_LOAD).get(BlockComponentHolderComponent.class);
    }

    @Override
    public void onInteractBy(Entity entity, Block block, PlayerInteractEvent.Action type, BlockFace clickedFace) {
        super.onInteract(entity, block, type, clickedFace);
        BlockComponent c = block.getComponent();
        Point pos = block.getPosition();
        if (c == null || !c.getClass().equals(BlockComponentHolderComponent.class)) {
            c = spawn(pos);
        }

        if (c == null) {
            throw new IllegalStateException("Failed to spawn " + "a component" + " at (" + pos.getX() + "," + pos.getY() + "," + pos.getZ() + ")");
        }
        c.onInteract(entity, type);
    }

    @Override
    public void onCreate(Block block, short data, Cause<?> cause) {
        super.onCreate(block, data, cause);
        spawn(block.getPosition());
    }

    @Override
    public BlockComponent createBlockComponent() {
        try {
            return BlockComponentHolderComponent.class.newInstance().setComponents(componentTypes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
