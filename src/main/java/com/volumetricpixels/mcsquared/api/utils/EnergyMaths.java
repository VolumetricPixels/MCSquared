package com.volumetricpixels.mcsquared.api.utils;

public class EnergyMaths {
    public static final String UNIT = "Joules";
    public static final float ENERGY_CONSTANT = 2.5f;
    public static final float CONVERT_RATE = 0.95f;

    public static double calculateEnergy(double mass) {
        return (mass / ENERGY_CONSTANT) * CONVERT_RATE;
    }

    public static double calculateMass(double energy) {
        return (energy * ENERGY_CONSTANT) * CONVERT_RATE;
    }

    private EnergyMaths() {
    }
}