package com.volumetricpixels.mcsquared.material;

import java.util.Collection;
import java.util.List;
import org.spout.api.component.type.BlockComponent;
import org.spout.api.entity.Entity;
import org.spout.api.event.player.PlayerInteractEvent;
import org.spout.api.geo.cuboid.Block;
import org.spout.api.material.BlockMaterial;
import org.spout.api.material.ComplexMaterial;
import org.spout.api.material.Material;
import org.spout.api.material.block.BlockFace;

public abstract class MultipleComponentMaterial extends BlockMaterial implements ComplexMaterial {

    private final Collection<Class<? extends BlockComponent>> componentTypes;

    public MultipleComponentMaterial(String name, List<Class<? extends BlockComponent>> component, String model) {
        super((short) 0, name, model);
        this.componentTypes = component;
    }

    public MultipleComponentMaterial(String name, int data, Material parent, String model, List<Class<? extends BlockComponent>> component) {
        super(name, data, parent, model);
        this.componentTypes = component;
    }

    public MultipleComponentMaterial(String name, List<Class<? extends BlockComponent>> component) {
        super(name);
        this.componentTypes = component;
    }

    public MultipleComponentMaterial(String name, short id, List<Class<? extends BlockComponent>> component) {
        super(name, id);
        this.componentTypes = component;

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
            return BlockComponentHolderComponent.class.newInstance().setComponents(componentTypes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
