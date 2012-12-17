package com.volumetricpixels.mcsquared.api.energy_matter;

/**
 * @author thehutch
 */
public interface EnergySource extends EnergyTransferer {
    /**
     * Called when the source generates energy
     */
    public void onEnergyGenerate(double energyGenerated);
}