package com.volumetricpixels.mcsquared.api.energy;

/**
 * @author thehutch
 */
public enum EnergyPrefix {
    
    NORMAL(""),
    KILO("Kilo"),
    MEGA("Mega"),
    GIGA("Giga"),
    TERA("Tera"),
    PETA("Peta"),
    EXA("Exa"),
    ZETTA("Zetta"),
    YOTTA("Yotta");

    private final String prefix;
    
    private EnergyPrefix(String prefix) {
        this.prefix = prefix;
    }
    
    public String getPrefix() {
        return prefix;
    }
}