package com.onarandombox.multiverseinventories;

import com.onarandombox.legacy.plugin.MockPlugin;
import com.onarandombox.multiverseinventories.profile.WorldGroupManager;
import org.jetbrains.annotations.NotNull;
import org.mvplugins.multiverse.core.command.MVCommandManager;
import org.mvplugins.multiverse.inventories.MultiverseInventoriesApi;

public final class MultiverseInventories extends MockPlugin {

    private static MultiverseInventories instance;

    public MultiverseInventories() {
        super("Multiverse-Inventories", "4.0.0", MultiverseInventories.class.getName());
    }

    public static MultiverseInventories getPlugin() {
        if (instance == null) {
            throw new IllegalStateException("MultiverseInventories has not been initialized.");
        }
        return instance;
    }

    private WorldGroupManager legacyWorldGroupManager;

    @Override
    public void onEnable() {
        MultiverseInventoriesApi api = MultiverseInventoriesApi.get();
        legacyWorldGroupManager = new YamlWorldGroupManager(api.getServiceLocator().getService(MVCommandManager.class), api.getWorldGroupManager());
        instance = this;
    }

    @Override
    public @NotNull String getName() {
        return "Multiverse-Inventories";
    }

    /**
     * @return The World Group manager for this plugin.
     */
    public WorldGroupManager getGroupManager() {
        return legacyWorldGroupManager;
    }
}
