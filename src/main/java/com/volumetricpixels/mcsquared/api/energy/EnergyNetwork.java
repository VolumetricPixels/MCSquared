package com.volumetricpixels.mcsquared.api.energy;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import org.spout.api.geo.discrete.Point;

/**
 * @author thehutch
 */
public class EnergyNetwork {
    
    private final LinkedHashMap<Point, EnergyNetworkNode> network;
    
    private double energyInNetwork;
    private double maxEnergyInNetwork;
    
    public EnergyNetwork() {
        this.network = new LinkedHashMap<Point, EnergyNetworkNode>();
        energyInNetwork = 0;
    }
    
    public Map<Point, EnergyNetworkNode> getNetwork() {
        return Collections.unmodifiableMap(network);
    }
    
    public EnergyNetworkNode getNode(Point point) {
        return network.get(point);
    }
    
    public void addNode(Point point, EnergyNetworkNode node) {
        this.network.put(point, node);
    }
    
    public void removeNode(Point point) {
        this.network.remove(point);
    }
    
    public void cleanNetwork() {
        this.network.clear();
    }
    
    public double getEnergyInNetwork() {
        return energyInNetwork;
    }
    
    public double getMaxEnergyInNetwork() {
        return maxEnergyInNetwork;
    }
    
    /**
     * Adds the amount of energy to the network
     * 
     * @param energy - Amount of energy to add
     * @return Excess energy
     */
    public double addEnergyToNetwork(double energy) {
        double excessEnergy = 0;
        if (energy < 0) {
            throw new IllegalArgumentException("Cannot add negative energy to network!");
        } else if (getEnergyInNetwork() + energy > getMaxEnergyInNetwork()) {
            energyInNetwork = getMaxEnergyInNetwork();
            excessEnergy = getEnergyInNetwork() + energy - getMaxEnergyInNetwork();
        } else {
            energyInNetwork += energy;
        }
        return excessEnergy;
    }
    
    /**
     * Removes the amount of energy from the network.
     * @param energy - Amount of energy removed
     * @return The amount of energy overdrawn
     */
    public double removeEnergyFromNetwork(double energy) {
        double overdrawnEnergy = 0;
        if (energy < 0) {
            throw new IllegalArgumentException("Cannot remove negative energy from network!");
        } else if (getEnergyInNetwork() - energy < 0) {
            energyInNetwork = 0;
            overdrawnEnergy = getEnergyInNetwork() - energy;
        } else {
            energyInNetwork -= energy;
        }
        return overdrawnEnergy;
    }
}