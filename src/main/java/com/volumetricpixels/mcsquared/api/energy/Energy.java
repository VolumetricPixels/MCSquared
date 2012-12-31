package com.volumetricpixels.mcsquared.api.energy;

public class Energy {
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
        return new Energy(value * other.getValue());
    }

    public Energy divide(Energy other) {
        return new Energy(value / other.getValue());
    }
    
    public Energy split(int size) {
        if (size == 0) {
            throw new IllegalArgumentException("Aliens have invaded.");
        }
        return new Energy(value / size);
    }
}
