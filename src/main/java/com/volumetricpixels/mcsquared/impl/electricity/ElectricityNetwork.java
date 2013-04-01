package com.volumetricpixels.mcsquared.impl.electricity;

import java.util.*;
import java.util.Map.Entry;

import org.spout.api.math.Vector3;

import com.volumetricpixels.mcsquared.api.ElectricityPacketFactory;
import com.volumetricpixels.mcsquared.api.electricity.*;
import com.volumetricpixels.mcsquared.api.energy.*;

public class ElectricityNetwork implements IElectricityNetwork {
	private final Map<IEnergyNetworkMember, IElectricityPacket> producers = new HashMap<IEnergyNetworkMember, IElectricityPacket>();
	private final Map<IEnergyNetworkMember, IElectricityPacket> consumers = new HashMap<IEnergyNetworkMember, IElectricityPacket>();
	private final Set<IElectricityConductor> conductors = new HashSet<IElectricityConductor>();

	public ElectricityNetwork() {
	}

	@Override
	public void startProduction(IEnergyNetworkMember member, IElectricityPacket packet) {
		if (member != null && packet != null) {
			producers.put(member, packet);
		} else {
			if (member == null) {
				throw new IllegalArgumentException("member cannot be null!");
			} else {
				throw new IllegalArgumentException("packet cannot be null!");
			}
		}
	}

	@Override
	public void startProduction(IEnergyNetworkMember member, double amps, double volts) {
		startProduction(member, ElectricityPacketFactory.newPacket(amps, volts));
	}

	@Override
	public void stopProduction(IEnergyNetworkMember member) {
		if (member != null) {
			producers.remove(member);
		} else {
			throw new IllegalArgumentException("member cannot be null!");
		}
	}

	@Override
	public boolean isProducing(IEnergyNetworkMember member) {
		if (member != null) {
			return producers.containsKey(member);
		} else {
			throw new IllegalArgumentException("member cannot be null!");
		}
	}

	@Override
	public void startConsumption(IEnergyNetworkMember member, IElectricityPacket packet) {
		if (member != null && packet != null) {
			consumers.put(member, packet);
		} else {
			if (member == null) {
				throw new IllegalArgumentException("member cannot be null!");
			} else {
				throw new IllegalArgumentException("packet cannot be null!");
			}
		}
	}

	@Override
	public void startConsumption(IEnergyNetworkMember member, double amps, double volts) {
		startConsumption(member, ElectricityPacketFactory.newPacket(amps, volts));
	}

	@Override
	public void stopConsumption(IEnergyNetworkMember member) {
		if (member != null) {
			consumers.remove(member);
		} else {
			throw new IllegalArgumentException("member cannot be null!");
		}
	}

	@Override
	public boolean isConsuming(IEnergyNetworkMember member) {
		if (member != null) {
			return consumers.containsKey(member);
		} else {
			throw new IllegalArgumentException("member cannot be null!");
		}
	}

	@Override
	public IElectricityPacket getProduced(IEnergyNetworkMember... excluded) {
		List<IEnergyNetworkMember> excl = Arrays.asList(excluded);
		double amps = 0;
		double volts = 0;
		for (Entry<IEnergyNetworkMember, IElectricityPacket> entry : producers.entrySet()) {
			if (!excl.contains(entry.getKey())) {
				amps += entry.getValue().getAmps();
				volts += entry.getValue().getVolts();
			}
		}
		return ElectricityPacketFactory.newPacket(amps, volts);
	}

	@Override
	public IElectricityPacket getProducedBy(IEnergyNetworkMember... members) {
		List<IEnergyNetworkMember> incl = Arrays.asList(members);
		double amps = 0;
		double volts = 0;
		for (Entry<IEnergyNetworkMember, IElectricityPacket> entry : producers.entrySet()) {
			if (incl.contains(entry.getKey())) {
				amps += entry.getValue().getAmps();
				volts += entry.getValue().getVolts();
			}
		}
		return null;
	}

	@Override
	public IElectricityPacket getDemand(IEnergyNetworkMember... ignored) {
		List<IEnergyNetworkMember> ign = Arrays.asList(ignored);
		double amps = 0;
		double volts = 0;
		for (Entry<IEnergyNetworkMember, IElectricityPacket> entry : consumers.entrySet()) {
			if (!ign.contains(entry.getKey())) {
				amps += entry.getValue().getAmps();
				volts += entry.getValue().getVolts();
			}
		}
		return ElectricityPacketFactory.newPacket(amps, volts);
	}

	@Override
	public IElectricityPacket onConsumption(IEnergyNetworkMember member) {
		IElectricityPacket total = ElectricityPacketFactory.newPacket(0, 0);
		IElectricityPacket demandPacket = consumers.get(member);
		if (consumers.containsKey(member) && demandPacket != null && (total = getProduced()).getWatts() > -0) {
			IElectricityPacket demand = getDemand();
			total.setAmps(total.getAmps() * (demandPacket.getAmps() / demand.getAmps()));
			double ampsReceived = total.getAmps() - (total.getAmps() * total.getAmps() * getTotalResistance()) / total.getVolts();
			double voltsReceived = total.getVolts() - (total.getAmps() * getTotalResistance());
			total.setAmps(ampsReceived);
			total.setVolts(voltsReceived);
		}
		return total;
	}

	@Override
	public Map<IEnergyNetworkMember, IElectricityPacket> getProducers() {
		return producers;
	}

	@Override
	public Map<IEnergyNetworkMember, IElectricityPacket> getConsumers() {
		return consumers;
	}

	@Override
	public Set<IElectricityConductor> getConductors() {
		return conductors;
	}

	@Override
	public double getTotalResistance() {
		double result = 0;
		for (IElectricityConductor conductor : conductors) {
			result += conductor.getResistance();
		}
		return result;
	}

	@Override
	public double getMinimumContainedEnergy() {
		double min = -1;
		for (IElectricityConductor conductor : conductors) {
			if (min == -1 || conductor.getCapacity() < min) {
				min = conductor.getCapacity();
			}
		}
		return min == -1 ? 0 : min;
	}

	@Override
	public void cleanup() {
		Iterator<IElectricityConductor> it = conductors.iterator();
		while (it.hasNext()) {
			IElectricityConductor conductor = it.next();
			if (conductor == null) {
				it.remove();
			}
		}
	}

	@Override
	public void refresh() {
		cleanup();

		Iterator<IElectricityConductor> it = conductors.iterator();
		while (it.hasNext()) {
			it.next().getAdjacentMembers(true);
		}
	}

	@Override
	public void merge(IElectricityNetwork other) {
		if (other == null) {
			throw new IllegalArgumentException("Cannot merge with a null network!");
		} else if (other == this) {
			throw new IllegalArgumentException("Cannot merge a network with itself!");
		}

		ElectricityNetwork merged = new ElectricityNetwork();
		merged.getConductors().addAll(getConductors());
		merged.getConductors().addAll(other.getConductors());
		merged.refresh();
	}

	@Override
	public void split(IEnergyNetworkMember point) {
		IEnergyNetworkMember[] adjacent = point.getAdjacentMembers(false);
		for (int i = 0; i < adjacent.length; i++) {
			IEnergyNetworkMember adj = adjacent[i];
			for (int ii = 0; ii < adjacent.length; ii++) {
				IEnergyNetworkMember adja = adjacent[ii];
				if (adj == adja || !(adja instanceof IElectricityConductor)) {
					continue;
				}
				// TODO: need pathfinding for this (maybe use A*?)
			}
		}
		if (getConductors().contains(point)) {
			getConductors().remove(point);
		}
	}
}
