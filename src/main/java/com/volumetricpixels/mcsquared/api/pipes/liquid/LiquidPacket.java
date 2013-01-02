package com.volumetricpixels.mcsquared.api.pipes.liquid;

public class LiquidPacket<T extends Liquid> implements Comparable<LiquidPacket<T>> {

    private final float value;
    private final Class<T> liquid;
    
    public LiquidPacket(Class<T> liquid, float value) {
        this.liquid = liquid;
        this.value = value;
    }

    public float getValue() {
        return value;
    }

    public Class<T> getLiquid() {
        return liquid;
    }

    public LiquidPacket<T> add(LiquidPacket<T> other) {
        return new LiquidPacket<T>(other.liquid, value + other.getValue());
    }
    
    public LiquidPacket<T> subtract(LiquidPacket<T> other) {
        return new LiquidPacket<T>(other.liquid, value - other.getValue());
    }
    
    public LiquidPacket<T> multiply(LiquidPacket<T> other) {
        return new LiquidPacket<T>(other.liquid, value * other.getValue());
    }
    
    public LiquidPacket<T> divide(LiquidPacket<T> other) {
        return new LiquidPacket<T>(other.liquid, value / other.getValue());
    }
    
    public LiquidPacket<T> split(int size) {
        return new LiquidPacket<T>(liquid, value / size);
    }
    
    @Override
    public int compareTo(LiquidPacket<T> other) {
        if (value > other.getValue()) {
            return 1;
        }
        if (value < other.getValue()) {
            return -1;
        }
        return 0;
    }
    
    public static <U extends Liquid> LiquidPacket<U> getEmpty(Class<U> l) {
        return new LiquidPacket<U>(l, 0f);
    }
}