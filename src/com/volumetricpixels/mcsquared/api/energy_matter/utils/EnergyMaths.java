package com.volumetricpixels.mcsquared.api.energy_matter.utils;

import com.volumetricpixels.mcsquared.api.energy_matter.EnergyPrefix;

/**
 * @author thehutch
 */
public class EnergyMaths {
    
    private static final float ENERGY_CONSTANT = 2.5f;
    private static final float CONVERT_RATE = 0.95f;

    private EnergyMaths(){
    }
    
    public static double calculateEnergy(double mass) {
       return (mass / ENERGY_CONSTANT) * CONVERT_RATE;
    }
    
    public static double calculateMass(double energy) {
        return (energy * ENERGY_CONSTANT) * CONVERT_RATE;
    }
    
    public static long convertPrefixToNormal(EnergyPrefix prefix, long energy) {
        switch(prefix) {
            case NORMAL:
                return energy;
            case KILO:
                return energy * 1000;
            case MEGA:
                return (long) (energy * Math.pow(1000, 2));
            case GIGA:
                return (long) (energy * Math.pow(1000, 3));
            case TERA:
                return (long) (energy * Math.pow(1000, 4));
            case PETA:
                return (long) (energy * Math.pow(1000, 5));
            case ZETTA:
                return (long) (energy * Math.pow(1000, 6));
            case YOTTA:
                return (long) (energy * Math.pow(1000, 7));
            default:
                return energy;
        }
    }
}