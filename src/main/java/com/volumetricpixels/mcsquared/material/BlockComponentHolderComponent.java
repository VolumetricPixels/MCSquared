package com.volumetricpixels.mcsquared.material;

import com.google.common.base.Preconditions;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.logging.Level;
import org.spout.api.Spout;
import org.spout.api.component.Component;
import org.spout.api.component.ComponentHolder;
import org.spout.api.component.type.BlockComponent;
import org.spout.api.entity.Entity;
import org.spout.api.event.player.PlayerInteractEvent.Action;

public class BlockComponentHolderComponent extends BlockComponent implements ComponentHolder {

    /**
     * Map of class name, component
     */
    private final BiMap<Class<? extends Component>, Component> components = HashBiMap.create();
    private boolean set = false;

    public BlockComponentHolderComponent setComponents(Collection<Class<? extends BlockComponent>> toAdd) {
        if (set) {
            throw new IllegalStateException("Cannot set components twice!");
        }
        set = true;
        HashSet<Component> added = new HashSet<Component>();
        synchronized (components) {
            for (Class<? extends Component> type : toAdd) {
                if (!this.components.containsKey(type)) {
                    added.add(addPrivate(type, false));
                }
            }
        }
        for (Component type : added) {
            type.onAttached();
        }
        return this;
    }

    /**
     * Adds a component to the map
     *
     * @param type to addPrivate
     * @param attach whether to call the component onAttached
     * @return instantiated component
     */
    private <T extends Component> T addPrivate(Class<T> type, boolean attach) {
        return addPrivate(type, type, attach);
    }

    /**
     * Adds a component to the map
     *
     * @param key the component class used as the lookup key
     * @param type of component to instantiate
     * @param attach whether to call the component onAttached
     * @return instantiated component
     */
    @SuppressWarnings("unchecked")
    private final <T extends Component> T addPrivate(Class<T> key, Class<? extends Component> type, boolean attach) {
        if (type == null || key == null) {
            return null;
        }

        synchronized (components) {
            T component = (T) components.get(key);

            if (component != null) {
                return component;
            }

            try {
                component = (T) type.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

            if (component != null) {
                try {
                    if (component.attachTo(this)) {
                        components.put(key, component);
                        if (attach) {
                            try {
                                component.onAttached();
                            } catch (Exception e) {
                                // Remove the component from the component map if onAttached can't be
                                // called, pass exception to next catch block.
                                components.remove(key);
                                throw e;
                            }
                        }
                    }
                } catch (Exception e) {
                    Spout.getEngine().getLogger().log(Level.SEVERE, "Error while attaching component " + type + ": ", e);
                }
            }
            return component;
        }
    }

    /**
     * For use de-serializing a list of components all at once, without having
     * to worry about dependencies
     *
     * @param components
     */
    protected void add(Class<? extends Component>... components) {
        throw new IllegalStateException("Cannot add blockcomponents");
    }

    @Override
    public <T extends Component> T add(Class<T> type) {
        throw new IllegalStateException("Cannot add blockcomponents");
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T extends Component> T detach(Class<? extends Component> type) {
        throw new IllegalStateException("Cannot detach blockcomponents");

    }

    @SuppressWarnings("unchecked")
    @Override
    public <T extends Component> T get(Class<T> type) {
        Preconditions.checkNotNull(type);
        if (type == null) {
            return null;
        }
        Component component = components.get(type);

        if (component == null) {
            component = findComponent(type);
        }
        return (T) component;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T extends Component> T getExact(Class<T> type) {
        Preconditions.checkNotNull(type);
        synchronized (components) {
            return (T) components.get(type);
        }
    }

    @Override
    @Deprecated
    public boolean has(Class<? extends Component> type) {
        return get(type) != null;
    }

    @Override
    @Deprecated
    public boolean hasExact(Class<? extends Component> type) {
        return getExact(type) != null;
    }

    @Override
    public Collection<Component> values() {
        synchronized (components) {
            return new ArrayList<Component>(components.values());
        }
    }

    @SuppressWarnings("unchecked")
    private <T extends Component> T findComponent(Class<T> type) {
        Preconditions.checkNotNull(type);
        synchronized (components) {
            for (Component component : values()) {
                if (type.isAssignableFrom(component.getClass())) {
                    return (T) component;
                }
            }
        }

        return null;
    }

    @Override
    public void onTick(float dt) {
        for (Component c : components.values()) {
            if (c.canTick()) {
                c.tick(dt);
            }
        }
    }

    @Override
    public void onInteract(Entity entity, Action type) {
        for (Component c : components.values()) {
            if (c instanceof BlockComponent) {
                ((BlockComponent) c).onInteract(entity, type);
            }
        }
    }
}
