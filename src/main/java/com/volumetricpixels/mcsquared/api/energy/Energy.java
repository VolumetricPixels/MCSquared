package com.volumetricpixels.mcsquared.api.energy;

public abstract class Energy<T extends Energy<?>> implements Comparable<T> {
    
    public abstract T add(T other);
    
    public abstract T subtract(T other);
    
    public abstract T multiply(T other);
    
    public abstract T divide(T other);
    
    public abstract T split(int size);
    
    public abstract T newEmpty();
    
    public abstract boolean isEmpty();
    
    public abstract int compareTo(T other);
}