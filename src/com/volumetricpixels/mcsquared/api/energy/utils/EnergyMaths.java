package com.volumetricpixels.mcsquared.api.energy.utils;

/**
 * @author thehutch
 */
public class EnergyMaths {
    
    private EnergyMaths(){
    }
    
    public static final long SPEED_OF_LIGHT = 299792458L;
    public static final long SPEED_OF_LIGHT_SQUARED = SPEED_OF_LIGHT * SPEED_OF_LIGHT;
    
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
}