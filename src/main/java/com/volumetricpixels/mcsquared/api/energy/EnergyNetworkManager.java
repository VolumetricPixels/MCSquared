package com.volumetricpixels.mcsquared.api.energy;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author thehutch <th3hutch@yahoo.co.uk>
 */
public class EnergyNetworkManager {

    private final Set<EnergyNetwork> loadedNetworks = new HashSet<EnergyNetwork>();
    
    public EnergyNetworkManager() {
        
    }
    
    public Set<EnergyNetwork> getNetworks() {
        return Collections.synchronizedSet(loadedNetworks);
    }
    
    /**
     * Adds a EnergyNetwork to the server.
     * 
     * @param network EnergyNetwork to be added
     * 
     * @return If the network was added successfully
     */
    public boolean addNetwork(EnergyNetwork network) {
        return this.loadedNetworks.add(network);
    }
    
    /**
     * Removes a EnergyNetwork from the server
     * 
     * @param network EnergyNetwork to be removed
     * @return If the network was removed successfully
     */
    public boolean removeNetwork(EnergyNetwork network) {
        return this.loadedNetworks.remove(network);
    }
    
    public void updateNetworks() {
        Iterator iterator = getNetworks().iterator();
        EnergyNetwork network;
        while((network = (EnergyNetwork)iterator.next()) != null) {
            //TODO: Some sort of updating all networks...
        }
    }
}