package com.volumetricpixels.mcsquared.api.utils;

import com.volumetricpixels.mcsquared.api.energy.Energy;
import com.volumetricpixels.mcsquared.api.energy.EnergyNode;
import com.volumetricpixels.mcsquared.api.energy.EnergyReceiver;
import com.volumetricpixels.mcsquared.api.energy.EnergySource;
import java.util.HashSet;
import java.util.Set;

public class EnergyUtils {
    
    /**
     * Safely splits the given energy across all the receivers and returns what is left.
     * NOTE: The calling node should add itself to the visited list
     * @param from 
     * @param toGive
     * @param visited
     * @param receivers
     * @return leftover energy that none of the receivers wanted
     */
    public static Energy safeSplit(EnergySource from, Energy toGive, Set<EnergyNode> visited, Set<EnergyReceiver> receivers) {
        if (receivers.isEmpty()) {
            return toGive;
        }
        Energy excess = Energy.EMPTY;
        Set<EnergyReceiver> left = new HashSet<EnergyReceiver>(receivers);//If it's here it either hasn't been visited or it's full
        Energy ret = Energy.EMPTY;
        Energy give = toGive.split(receivers.size());
        while (!left.isEmpty() && give.compareTo(Energy.EMPTY) > 0) {
            for(EnergyReceiver receiver : left) {
                if (visited.contains(receiver)) {
                    left.remove(receiver);
                    continue;
                }
                ret = ret.add(receiver.onReceive(from, visited, give));
            }
            give = ret.split(left.size());
        }
        return excess;
    }
}
