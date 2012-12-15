package com.volumetricpixels.mcsquared.api.energy_matter;

/**
 * @author thehutch
 */
public enum EnergyPrefix implements Prefix {
    
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
    
    @Override
    public String getPrefix() {
        return prefix;
    }
}