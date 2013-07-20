package com.volumetricpixels.mcsquared.api.energy.electricity;

import com.volumetricpixels.mcsquared.api.energy.Energy;

public class Electricity implements Energy<Electricity> {

    public static final Electricity EMPTY = new Electricity(0);
    private final float energy;
    private final float amps, volts;

    public Electricity(float energy) {
        if (energy < 0) {
            throw new IllegalArgumentException("Energy cannot be negative!");
        }
        this.energy = energy;
        amps = energy / 0.05f; // Energy / Time (1 tick)
        volts = 0; // TODO configure
    }
    
    public float getValue() {
        return energy;
    }

    public float getAmperes() {
        return amps;
    }

    public float getVoltage() {
        return volts;
    }

    @Override
    public Electricity add(Electricity other) {
        return new Electricity(energy + other.energy);
    }

    @Override
    public Electricity subtract(Electricity other) {
        return new Electricity(energy - other.energy);
    }

    @Override
    public Electricity multiply(Electricity other) {
        return new Electricity(energy * other.energy);
    }

    @Override
    public Electricity divide(Electricity other) {
        return new Electricity(energy / other.energy);
    }
    
    @Override
    public Electricity split(int size) {
        return new Electricity(energy / size);
    }
    
    @Override
    public Electricity newEmpty() {
        return Electricity.EMPTY;
    }

    @Override
    public boolean isEmpty() {
        return energy == 0;
    }

    @Override
    public int compareTo(Electricity other) {
        return energy == other.energy ? 0 : (energy - other.energy > 0 ? 1 : -1);
    }
}