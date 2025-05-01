package com.onarandombox.MultiverseCore;

import com.onarandombox.MultiverseCore.api.Core;
import com.onarandombox.MultiverseCore.api.MVWorldManager;
import com.onarandombox.MultiverseCore.destination.DestinationFactory;
import com.onarandombox.MultiverseCore.utils.AnchorManager;
import com.onarandombox.MultiverseCore.utils.WorldManager;
import com.onarandombox.legacy.plugin.MockPlugin;
import org.jetbrains.annotations.NotNull;
import org.mvplugins.multiverse.core.MultiverseCoreApi;
import org.mvplugins.multiverse.core.world.helpers.PlayerWorldTeleporter;

public final class MultiverseCore extends MockPlugin implements Core {

    private DestinationFactory legacyDestinationFactory;
    private WorldManager legacyWorldManager;
    private AnchorManager legacyAnchorManager;

    public MultiverseCore() {
        super("Multiverse-Core", "4.0.0", MultiverseCore.class.getName());
    }

    @Override
    public void onEnable() {
        MultiverseCoreApi api = MultiverseCoreApi.get();
        legacyDestinationFactory = new DestinationFactory(api.getDestinationsProvider());
        legacyWorldManager = new WorldManager(api.getWorldManager(), api.getServiceLocator().getService(PlayerWorldTeleporter.class));
        legacyAnchorManager = new AnchorManager(api.getAnchorManager());
    }

    @Override
    public @NotNull String getName() {
        return "Multiverse-Core";
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
