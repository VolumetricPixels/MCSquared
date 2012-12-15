package com.volumetricpixels.mcsquared.modules;

import java.io.File;

/**
 * @author thehutch
 */
public abstract class Module {
    
    protected String name;
    protected String version;
    
    public String getName() {
        return name;
    }
    
    public String getVersion() {
        return version;
    }
    
    public File getDataDirectory() {
        File directory = new File("");
        if (!directory.exists() || !directory.isDirectory()) {
            directory.mkdirs();
        }
        return directory;
    }
    
    public abstract void onLoad();

    public abstract void onUnload();

}