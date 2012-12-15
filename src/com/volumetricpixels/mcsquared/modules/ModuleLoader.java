package com.volumetricpixels.mcsquared.modules;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import com.volumetricpixels.mcsquared.exceptions.InvalidMainClassException;
import com.volumetricpixels.mcsquared.exceptions.InvalidModuleYAMLException;
import org.spout.api.util.config.yaml.YamlConfiguration;

/**
 * @author thehutch
 */
public class ModuleLoader {
    
    private ModuleLoader() {
    }
    
    public static List<Module> loadModules() {
        List<Module> modules = new ArrayList<Module>();
        File directory = new File("MCSquared" + File.separator + "modules" + File.separator);
        if (!directory.exists() || !directory.isDirectory()) {
            directory.mkdirs();
        }
        JarFile jarFile;
        JarEntry yaml_file;
        String main, name, version; //TODO: , depends;
        YamlConfiguration yaml_data;
        
        for(File file : directory.listFiles()) {
            try {
                jarFile = new JarFile(file);
                yaml_file = jarFile.getJarEntry("module.yml");
                if (yaml_file == null) {
                    throw new InvalidModuleYAMLException("Could not find module.yml in module: " + file.getName());
                }
                yaml_data = new YamlConfiguration(jarFile.getInputStream(yaml_file));
                main = yaml_data.getNode("main").getString();
                name = yaml_data.getNode("name").getString();
                version = yaml_data.getNode("version").getString();
                if (main == null) {
                    throw new InvalidModuleYAMLException("Missing main attribute in module.yml from module: " + file.getName());
                }
                if (name == null) {
                    throw new InvalidModuleYAMLException("Missing name attribute in module.yml from module: " + file.getName());
                }
                if (version == null) {
                    throw new InvalidModuleYAMLException("Missing version attribute in module.yml from module: " + file.getName());
                }
                main = main.replaceAll("\\.", File.separator);

                Class<?> module_class = ModuleLoader.class.getClassLoader().loadClass(main);
                if (!Module.class.isAssignableFrom(module_class)) {
                    throw new InvalidMainClassException("Invalid main class loading attempt from module: " + name);
                }
                Module module = (Module) module_class.newInstance();
                module.onLoad();
                modules.add(module);
                System.out.println("[MCSquared] Module: " + name + " Version: " + version + " has been loaded");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return modules;
    }
}