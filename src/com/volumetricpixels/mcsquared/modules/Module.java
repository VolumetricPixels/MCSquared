package com.volumetricpixels.mcsquared.modules;

import com.volumetricpixels.mcsquared.MCSquared;
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
        File directory = new File("MCSquared" + File.separator + "modules" +  File.separator + name);
        if (!directory.exists() || !directory.isDirectory()) {
            directory.mkdirs();
        }
        return directory;
    }
    
    public ModuleManager getModuleManager() {
        return MCSquared.getModuleManager();
    }
    
    public abstract void onLoad();

    public abstract void onUnload();

}