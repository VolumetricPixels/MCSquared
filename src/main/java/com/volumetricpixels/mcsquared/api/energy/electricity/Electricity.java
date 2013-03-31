package com.volumetricpixels.mcsquared.api.energy.electricity;

import com.volumetricpixels.mcsquared.api.energy.Energy;

public class Electricity extends Energy<Electricity> {

    public static final Electricity EMPTY = new Electricity(0f);
    private final float value;

    public Electricity(float value) {
        this.value = value;
    }

    public float getValue() {
        return value;
    }

    @Override
    public Electricity add(Electricity other) {
        return new Electricity(value + other.value);
    }

    @Override
    public Electricity subtract(Electricity other) {
        return new Electricity(value - other.value);
    }

    @Override
    public Electricity multiply(Electricity other) {
        return new Electricity(value * other.value);
    }

    @Override
    public Electricity divide(Electricity other) {
        return new Electricity(value / other.value);
    }

    @Override
    public Electricity split(int size) {
        return new Electricity(value / size);
    }

    @Override
    public boolean isEmpty() {
        return value <= 0;
    }

    @Override
    public Electricity newEmpty() {
        return new Electricity(0);
    }

    @Override
    public int compareTo(Electricity other) {
        if (value > other.value) {
            return 1;
        }
        if (value < other.value) {
            return -1;
        }
        return 0;
    }
}