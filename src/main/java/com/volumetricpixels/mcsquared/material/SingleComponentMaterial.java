package com.volumetricpixels.mcsquared.material;

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
import org.spout.api.math.Vector3;

public abstract class SingleComponentMaterial extends BlockMaterial implements ComplexMaterial {

    private final Class<? extends BlockComponent> componentType;

    public SingleComponentMaterial(String name, Class<? extends BlockComponent> component, String model) {
        super((short) 0, name, model);
        this.componentType = component;
    }

    public SingleComponentMaterial(String name, int data, Material parent, String model, Class<? extends BlockComponent> component) {
        super(name, data, parent, model);
        this.componentType = component;
    }

    public SingleComponentMaterial(String name, Class<? extends BlockComponent> component) {
        super(name);
        this.componentType = component;
    }

    public SingleComponentMaterial(String name, short id, Class<? extends BlockComponent> component) {
        super(name, id);
        this.componentType = component;

    }

    @Override
    public void onInteractBy(Entity entity, Block block, PlayerInteractEvent.Action type, BlockFace clickedFace) {
        super.onInteract(entity, block, type, clickedFace);
        BlockComponent c = block.getComponent();
        c.onInteract(entity, type);
    }

    @Override
    public BlockComponent createBlockComponent() {
        try {
            return componentType.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}