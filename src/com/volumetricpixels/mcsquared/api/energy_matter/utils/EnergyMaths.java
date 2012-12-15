package com.volumetricpixels.mcsquared.api.energy_matter.utils;

import com.volumetricpixels.mcsquared.api.energy_matter.EnergyPrefix;

/**
 * @author thehutch
 */
public class EnergyMaths {
    
    private EnergyMaths(){
    }
    
    public static final double SPEED_OF_LIGHT = 299792458L;
    public static final double SPEED_OF_LIGHT_SQUARED = SPEED_OF_LIGHT * SPEED_OF_LIGHT;
    
    public static final double MASS_OF_ELECTRON = (9.11 * (Math.pow(10, -31)));
    public static final double CHARGE_OF_ELECTRON = (1.6 * (Math.pow(10, -19)));
    
    public static double calculateEnergy(double mass) {
        return mass * SPEED_OF_LIGHT_SQUARED;
    }
    
    public static double calculateEnergyStored(double voltage, double capacitance) {
        return 0.5 * capacitance * (voltage * voltage);
    }
    
    public static double calculateVoltage(double resistance, double current) {
        return resistance * current;
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