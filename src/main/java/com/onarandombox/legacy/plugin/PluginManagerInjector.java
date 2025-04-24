package com.onarandombox.legacy.plugin;

import com.onarandombox.legacy.MultiverseLegacy;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.SimplePluginManager;
import org.jetbrains.annotations.ApiStatus;
import org.mvplugins.multiverse.external.vavr.control.Try;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.logging.Logger;

@ApiStatus.Internal
public class PluginManagerInjector {

    private final MultiverseLegacy multiverseLegacy;
    private final Plugin plugin;
    private final String pluginName;

    public PluginManagerInjector(MultiverseLegacy multiverseLegacy, Plugin plugin, String pluginName) {
        this.multiverseLegacy = multiverseLegacy;
        this.plugin = plugin;
        this.pluginName = pluginName.toLowerCase();
    }

    public void replacePluginLookup() {
        try {
            SimplePluginManager pluginManager = (SimplePluginManager) Bukkit.getPluginManager();
            Field lookupNamesField = pluginManager.getClass().getDeclaredField("lookupNames");
            if (lookupNamesField == null) {
                getLogger().severe("Could not find lookupNames field in PluginManager.");
                return;
            }
            lookupNamesField.setAccessible(true);
            Map<String, Plugin> lookupNames = (Map<String, Plugin>) lookupNamesField.get(pluginManager);
            if (lookupNames == null) {
                getLogger().severe("Could not get lookupNames from PluginManager.");
                return;
            }
            lookupNames.put(pluginName, plugin);
            getLogger().info("Replaced Multiverse-Core plugin for spigot lookup.");
        } catch (Exception e) {
            e.printStackTrace();
            getLogger().severe("Could not replace Multiverse-Core plugin spigot lookup.");
        }

        try {
            SimplePluginManager pluginManager = (SimplePluginManager) Bukkit.getPluginManager();
            PluginManager paperPluginManager = Try.of(() -> pluginManager.paperPluginManager).getOrNull();
            if (paperPluginManager == null) {
                getLogger().info("Could not get paperPluginManager from PluginManager. Ignore if using spigot.");
                return;
            }

            Class.forName("io.papermc.paper.plugin.manager.PaperPluginInstanceManager");
            Field instanceManagerField = paperPluginManager.getClass().getDeclaredField("instanceManager");
            if (instanceManagerField == null) {
                getLogger().severe("Could not find instanceManager field in PluginManager.");
                return;
            }
            instanceManagerField.setAccessible(true);
            Object instanceManager = instanceManagerField.get(paperPluginManager);

            Field lookupNamesField = instanceManager.getClass().getDeclaredField("lookupNames");
            if (lookupNamesField == null) {
                getLogger().severe("Could not find lookupNames field in PluginManager.");
                return;
            }
            lookupNamesField.setAccessible(true);
            Map<String, Plugin> lookupNames = (Map<String, Plugin>) lookupNamesField.get(instanceManager);
            if (lookupNames == null) {
                getLogger().severe("Could not get lookupNames from PluginManager.");
                return;
            }
            lookupNames.put(pluginName, plugin);
            getLogger().info("Replaced Multiverse-Core plugin for paper lookup.");
        } catch (Exception e) {
            e.printStackTrace();
            getLogger().severe("Could not replace Multiverse-Core plugin paper lookup.");
        }
    }

    private Logger getLogger() {
        return multiverseLegacy.getLogger();
    }
}
