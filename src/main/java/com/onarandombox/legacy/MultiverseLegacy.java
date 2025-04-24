package com.onarandombox.legacy;

import com.onarandombox.MultiverseCore.MultiverseCore;
import com.onarandombox.legacy.events.CoreLegacyEventMapper;
import com.onarandombox.legacy.events.InventoriesLegacyEventMapper;
import com.onarandombox.legacy.events.PortalsLegacyEventMapper;
import com.onarandombox.legacy.plugin.PluginManagerInjector;
import com.onarandombox.multiverseinventories.MultiverseInventories;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.server.PluginEnableEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
public class MultiverseLegacy extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(this, this);
        if (pluginManager.isPluginEnabled("Multiverse-Core")) {
            onMultiverseCoreEnable();
        }
        if (pluginManager.isPluginEnabled("Multiverse-Inventories")) {
            onMultiverseInventoriesEnable();
        }
        if (pluginManager.isPluginEnabled("Multiverse-Portals")) {
            onMultiversePortalsEnable();
        }
    }

    @EventHandler(priority = EventPriority.LOWEST)
    private void onPluginLoad(PluginEnableEvent event) {
        if (event.getPlugin().getName().equalsIgnoreCase("Multiverse-Core")) {
            onMultiverseCoreEnable();
        }
        if (event.getPlugin().getName().equalsIgnoreCase("Multiverse-Inventories")) {
            onMultiverseInventoriesEnable();
        }
        if (event.getPlugin().getName().equalsIgnoreCase("Multiverse-Portals")) {
            onMultiversePortalsEnable();
        }
    }

    private void onMultiverseCoreEnable() {
        getLogger().info("Multiverse-Legacy-Api loading Multiverse-Core v4 api...");
        MultiverseCore multiverseCore = new MultiverseCore();
        multiverseCore.onEnable();
        new PluginManagerInjector(this, multiverseCore, "Multiverse-Core").replacePluginLookup();
        Bukkit.getPluginManager().registerEvents(new CoreLegacyEventMapper(), this);
    }

    private void onMultiverseInventoriesEnable() {
        getLogger().info("Multiverse-Legacy-Api loading Multiverse-Inventories v4 api...");
        MultiverseInventories multiverseInventories = new MultiverseInventories();
        multiverseInventories.onEnable();
        new PluginManagerInjector(this, multiverseInventories, "Multiverse-Inventories").replacePluginLookup();
        Bukkit.getPluginManager().registerEvents(new InventoriesLegacyEventMapper(), this);
    }

    private void onMultiversePortalsEnable() {
        getLogger().info("Multiverse-Legacy-Api loading Multiverse-Portals v4 api...");
        Bukkit.getPluginManager().registerEvents(new PortalsLegacyEventMapper(), this);
    }
}
