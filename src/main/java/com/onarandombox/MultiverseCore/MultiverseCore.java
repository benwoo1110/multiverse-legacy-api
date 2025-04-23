package com.onarandombox.MultiverseCore;

import com.onarandombox.MultiverseCore.api.Core;
import com.onarandombox.MultiverseCore.api.MVWorldManager;
import com.onarandombox.MultiverseCore.destination.DestinationFactory;
import com.onarandombox.mv5remap.events.CoreLegacyEventMapper;
import com.onarandombox.mv5remap.events.InventoriesLegacyEventMapper;
import com.onarandombox.mv5remap.PluginManagerInjector;
import com.onarandombox.MultiverseCore.utils.AnchorManager;
import com.onarandombox.MultiverseCore.utils.WorldManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.server.PluginEnableEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.mvplugins.multiverse.core.MultiverseCoreApi;
import org.mvplugins.multiverse.core.world.helpers.PlayerWorldTeleporter;

public final class MultiverseCore extends JavaPlugin implements Core, Listener {

    private DestinationFactory legacyDestinationFactory;
    private WorldManager legacyWorldManager;
    private AnchorManager legacyAnchorManager;

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);

        if (getServer().getPluginManager().isPluginEnabled("Multiverse-Core")) {
            onMultiverseCoreEnable();
        }
        if (getServer().getPluginManager().isPluginEnabled("Multiverse-Inventories")) {
            onMultiverseInventoriesEnable();
        }
    }

    @EventHandler(priority = EventPriority.LOWEST)
    private void onPluginLoad(PluginEnableEvent event) {
        if (event.getPlugin().getName().equals("Multiverse-Core")) {
            onMultiverseCoreEnable();
        }
        if (event.getPlugin().getName().equals("Multiverse-Inventories")) {
            onMultiverseInventoriesEnable();
        }
    }

    private void onMultiverseCoreEnable() {
        getLogger().info("Multiverse-Legacy-Api loading Multiverse-Core v4 api...");

        // Plugin startup logic
        MultiverseCoreApi api = MultiverseCoreApi.get();
        legacyDestinationFactory = new DestinationFactory(api.getDestinationsProvider());
        legacyWorldManager = new WorldManager(api.getWorldManager(), api.getServiceLocator().getService(PlayerWorldTeleporter.class));
        legacyAnchorManager = new AnchorManager(api.getAnchorManager());

        // Register legacy listeners
        getServer().getPluginManager().registerEvents(new CoreLegacyEventMapper(), this);

        // Inject plugin into PluginManager
        new PluginManagerInjector(this, "Multiverse-Core").replacePluginLookup();
    }

    private void onMultiverseInventoriesEnable() {
        getLogger().info("Multiverse-Legacy-Api loading Multiverse-Inventories v4 api...");
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new InventoriesLegacyEventMapper(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        super.onDisable();
    }

    @Override
    public DestinationFactory getDestFactory() {
        return legacyDestinationFactory;
    }

    @Override
    public MVWorldManager getMVWorldManager() {
        return legacyWorldManager;
    }

    @Override
    public AnchorManager getAnchorManager() {
        return legacyAnchorManager;
    }
}
