package com.onarandombox.legacy.events;

import com.onarandombox.multiverseinventories.event.GameModeChangeShareHandlingEvent;
import com.onarandombox.multiverseinventories.event.WorldChangeShareHandlingEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
public class InventoriesLegacyEventMapper extends LegacyEventMapper implements Listener {

    @EventHandler
    private void onGameModeChangeShareHandlingEvent(org.mvplugins.multiverse.inventories.event.GameModeChangeShareHandlingEvent event) {
        callEvent(new GameModeChangeShareHandlingEvent(event.getPlayer(), event.getFromGameMode(), event.getToGameMode()), event);
    }

    @EventHandler
    private void onWorldChangeShareHandlingEvent(org.mvplugins.multiverse.inventories.event.WorldChangeShareHandlingEvent event) {
        callEvent(new WorldChangeShareHandlingEvent(event.getPlayer(), event.getFromWorld(), event.getToWorld()), event);
    }
}
