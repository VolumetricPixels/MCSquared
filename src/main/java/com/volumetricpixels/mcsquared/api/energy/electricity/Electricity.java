package com.volumetricpixels.mcsquared.api.energy.electricity;

import com.volumetricpixels.mcsquared.api.energy.Energy;

public class Electricity extends Energy<Electricity> {

    public static final Electricity EMPTY = new Electricity(0);
    private final float amps, volts;

    public Electricity(float energy) {
        super(energy);
        amps = energy / 0.05f; // Energy / Time (1 tick)
        volts = 0; // TODO configure
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
}