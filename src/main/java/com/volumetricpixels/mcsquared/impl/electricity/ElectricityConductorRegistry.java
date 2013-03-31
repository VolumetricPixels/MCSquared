package com.volumetricpixels.mcsquared.impl.electricity;

import java.util.*;

import org.spout.api.event.*;
import org.spout.api.event.world.*;

import com.volumetricpixels.mcsquared.api.electricity.*;
import com.volumetricpixels.mcsquared.api.energy.*;

public class ElectricityConductorRegistry implements IElectricityConductorRegistry, Listener {
	public static final Map<String, ElectricityConductorRegistry> map = new HashMap<String, ElectricityConductorRegistry>();

	private final List<IElectricityConductor> conductors;

	public ElectricityConductorRegistry() {
		conductors = new ArrayList<IElectricityConductor>();
	}

	@Override
	public void register(IElectricityConductor conductor) {
		cleanConductors();
		if (!conductors.contains(conductor)) {
			conductors.add(conductor);
		}
	}

	@Override
	public Collection<IElectricityConductor> getConductors() {
		return conductors;
	}

	@Override
	public void cleanConductors() {
		Iterator<IElectricityConductor> it = conductors.iterator();
		while (it.hasNext()) {
			IElectricityConductor conductor = it.next();
			if (conductor == null) {
				it.remove();
			}
		}
	}

	@Override
	public void resetConnections() {
		cleanConductors();

		Iterator<IElectricityConductor> it = conductors.iterator();
		while (it.hasNext()) {
			IElectricityConductor conductor = it.next();
			// TODO: Set to new network (networks aren't implemented yet)
			conductor.getAdjacentMembers(true);
		}
	}

	@EventHandler(order = Order.MONITOR)
	public void onWorldLoad(WorldLoadEvent event) {
		map.put(event.getWorld().getName(), new ElectricityConductorRegistry());
	}

	@EventHandler(order = Order.MONITOR)
	public void onWorldUnload(WorldUnloadEvent event) {
		map.remove(event.getWorld().getName());
	}
}
