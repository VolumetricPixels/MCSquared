package me.thehutch.mcsquared.api.energy;

/**
 * @author thehutch
 */
public enum VoltageLevel {

    LOW(32L),
    MEDIUM(128L),
    HIGH(512L);
    
    private final long max_voltage;
    
    private VoltageLevel(long max) {
        this.max_voltage = max;
    }
    
    public final long getMaximumVoltage() {
        return max_voltage;
    }
}