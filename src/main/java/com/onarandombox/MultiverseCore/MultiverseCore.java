package com.onarandombox.MultiverseCore;

import com.onarandombox.MultiverseCore.api.Core;
import com.onarandombox.MultiverseCore.api.MVWorldManager;
import com.onarandombox.MultiverseCore.event.MVRespawnEvent;
import com.onarandombox.MultiverseCore.event.MVWorldDeleteEvent;
import com.onarandombox.MultiverseCore.utils.WorldManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.PluginEnableEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.SimplePluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.mvplugins.multiverse.core.MultiverseCoreApi;
import org.mvplugins.multiverse.core.world.helpers.PlayerWorldTeleporter;
import org.mvplugins.multiverse.external.vavr.control.Try;

import java.lang.reflect.Field;
import java.util.Map;

public final class MultiverseCore extends JavaPlugin implements Core, Listener {

    private WorldManager legacyWorldManager;

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);

        if (getServer().getPluginManager().isPluginEnabled("Multiverse-Core")) {
            onMultiverseCoreEnable();
            replacePluginLookup();
        }
    }

    @EventHandler
    private void onPluginLoad(PluginEnableEvent event) {
        if (event.getPlugin().getName().equals("Multiverse-Core")) {
            onMultiverseCoreEnable();
            replacePluginLookup();
        }
    }

    private void onMultiverseCoreEnable() {
        // Plugin startup logic
        MultiverseCoreApi api = MultiverseCoreApi.get();
        legacyWorldManager = new WorldManager(
                api.getWorldManager(),
                api.getServiceLocator().getService(PlayerWorldTeleporter.class)
        );
    }

    private void replacePluginLookup() {
        try {
            SimplePluginManager pluginManager = (SimplePluginManager) getServer().getPluginManager();
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
            lookupNames.put("multiverse-core", this);
            lookupNames.put("Multiverse-Core", this);
            getLogger().info("Replaced Multiverse-Core plugin for spigot lookup.");
        } catch (Exception e) {
            e.printStackTrace();
            getLogger().severe("Could not replace Multiverse-Core plugin spigot lookup.");
        }

        try {
            SimplePluginManager pluginManager = (SimplePluginManager) getServer().getPluginManager();
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
            lookupNames.put("multiverse-core", this);
            getLogger().info("Replaced Multiverse-Core plugin for paper lookup.");
        } catch (Exception e) {
            e.printStackTrace();
            getLogger().severe("Could not replace Multiverse-Core plugin paper lookup.");
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        super.onDisable();
    }

    @Override
    public MVWorldManager getMVWorldManager() {
        return legacyWorldManager;
    }

    @EventHandler
    private void onMVWorldDeleteEvent(org.mvplugins.multiverse.core.event.world.MVWorldDeleteEvent event) {
        MVWorldDeleteEvent legacyEvent = new MVWorldDeleteEvent(new MVWorld(event.getWorld()), true);
        getServer().getPluginManager().callEvent(legacyEvent);
        if (legacyEvent.isCancelled()) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    private void onMVRespawnEvent(org.mvplugins.multiverse.core.event.MVRespawnEvent event) {
        MVRespawnEvent legacyEvent = new MVRespawnEvent(event.getRespawnLocation(), event.getPlayer(), "compatibility");
        getServer().getPluginManager().callEvent(legacyEvent);
    }
}
