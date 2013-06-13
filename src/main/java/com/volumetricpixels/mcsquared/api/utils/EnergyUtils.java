package com.volumetricpixels.mcsquared.api.utils;

import com.volumetricpixels.mcsquared.api.energy.Energy;
import com.volumetricpixels.mcsquared.api.energy.EnergyNodeComponent;
import com.volumetricpixels.mcsquared.api.energy.EnergyReceiver;
import com.volumetricpixels.mcsquared.api.energy.EnergySource;
import java.util.HashSet;
import java.util.Set;

public class EnergyUtils {

    /**
     * Safely splits the given energy across all the receivers and returns what
     * is left. NOTE: The calling node should add itself to the visited list
     *
     * @param <T> Type of energy
     * @param from
     * @param toGive
     * @param visited
     * @param receivers
     * @return leftover energy that none of the receivers wanted
     */
    public static <T extends Energy<T>> T safeSplit(EnergySource<T> from, T toGive, Set<EnergyNodeComponent<T>> visited, Set<EnergyReceiver<T>> receivers) {
        if (receivers.isEmpty()) {
            return toGive;
        }
        Set<EnergyReceiver<T>> left = new HashSet<EnergyReceiver<T>>(receivers);//If it's here it either hasn't been visited or it's full
        T returned = toGive.newEmpty();
        T give = toGive.split(receivers.size());
        while (!left.isEmpty() && !give.isEmpty()) {
            for (EnergyReceiver<T> receiver : left) {
                if (visited.contains(receiver)) {
                    left.remove(receiver);
                    continue;
                }
                T onReceive = receiver.onReceive(from, visited, give);
                returned = returned.add(onReceive);
            }
            give = returned.split(left.size());
        }
        return null;//Excess wasn't being calculated
    }
}