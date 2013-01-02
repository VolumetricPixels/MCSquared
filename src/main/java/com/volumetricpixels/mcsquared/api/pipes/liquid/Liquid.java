package com.volumetricpixels.mcsquared.api.pipes.liquid;

import org.spout.api.entity.Player;
public class Liquid implements Comparable<Liquid> {

    public static final Liquid EMPTY = new Liquid(0f);
    private final float value;
    
    public Liquid(float value) {
        this.value = value;
        
        Player player;
    }
    
    public float getValue() {
        return value;
    }
    
    public Liquid add(Liquid other) {
        return new Liquid(value + other.getValue());
    }
    
    public Liquid subtract(Liquid other) {
        return new Liquid(value - other.getValue());
    }
    
    public Liquid multiply(Liquid other) {
        return new Liquid(value * other.getValue());
    }
    
    public Liquid divide(Liquid other) {
        return new Liquid(value / other.getValue());
    }
    
    public Liquid split(int size) {
        return new Liquid(value / size);
    }
    
    @Override
    public int compareTo(Liquid other) {
        if (value > other.getValue()) {
            return 1;
        }
        if (value < other.getValue()) {
            return -1;
        }
        return 0;
    }
}