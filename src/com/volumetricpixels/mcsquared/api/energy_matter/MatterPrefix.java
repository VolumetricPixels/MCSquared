package com.volumetricpixels.mcsquared.api.energy_matter;

/**
 * @author thehutch
 */
public enum MatterPrefix implements Prefix {

    MILLI_GRAMS("mg"),
    GRAMS("g"),
    KILO_GRAMS("kg"),
    TONS("tons");
    
    private final String prefix;
    
    private MatterPrefix(String prefix) {
        this.prefix = prefix;
    }

    @Override
    public String getPrefix() {
        return prefix;
    }
}