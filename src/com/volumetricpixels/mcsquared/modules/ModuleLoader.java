package com.volumetricpixels.mcsquared.modules;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import org.spout.api.util.config.yaml.YamlConfiguration;

import com.volumetricpixels.mcsquared.exceptions.InvalidMainClassException;
import com.volumetricpixels.mcsquared.exceptions.InvalidModuleYAMLException;

/**
 * @author thehutch
 * @author DziNeIT
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
        JarFile jarFile = null;
        JarEntry yamlFile;
        String main, name, version; //TODO: , depends;
        YamlConfiguration yaml;

        for (File file : directory.listFiles()) {
            try {
                jarFile = new JarFile(file);
                yamlFile = jarFile.getJarEntry("module.yml");
                if (yamlFile == null) {
                    throw new InvalidModuleYAMLException("Could not find module.yml in module: " + file.getName());
                }
                yaml = new YamlConfiguration(jarFile.getInputStream(yamlFile));
                main = yaml.getNode("main").getString();
                name = yaml.getNode("name").getString();
                version = yaml.getNode("version").getString();
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

                Class<?> mainClass = ModuleLoader.class.getClassLoader().loadClass(main);
                if (!Module.class.isAssignableFrom(mainClass)) {
                    throw new InvalidMainClassException("Invalid main class loading attempt from module: " + name);
                }
                Module module = (Module) mainClass.newInstance();
                module.name = name;
                module.version = version;
                module.onLoad();
                modules.add(module);
                System.out.println("[MCSquared] Module: " + name + " Version: " + version + " has been loaded");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    jarFile.close();
                } catch (Exception e) {
                }
            }
        }
        return modules;
    }
}