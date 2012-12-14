package me.thehutch.mcsquared.modules;

import java.io.File;

/**
 * @author thehutch
 */
public abstract class Module {
    
    private final String name;
    private final String version;
    
    public Module(String name, String version) {
        this.name = name;
        this.version = version;
    }
    
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