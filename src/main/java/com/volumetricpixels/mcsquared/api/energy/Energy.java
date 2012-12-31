package com.volumetricpixels.mcsquared.api.energy;

public class Energy implements Comparable<Energy> {
    
    public static final Energy EMPTY = new Energy(0f);
    private final float value;

    public Energy(float value) {
        this.value = value;
    }

    public float getValue() {
        return value;
    }
    
    public Energy add(Energy other) {
        return new Energy(value + other.value);
    }

    public Energy subtract(Energy other) {
        return new Energy(value - other.value);
    }
    
    public Energy multiply(Energy other) {
        return new Energy(value * other.value);
    }

    public Energy divide(Energy other) {
        return new Energy(value / other.value);
    }
    
    public Energy split(int size) {
        return new Energy(value / size);
    }

    @Override
    public int compareTo(Energy other) {
        if (value > other.value) {
            return 1;
        }
        if (value < other.value) {
            return -1;
        }
        return 0;
    }
}