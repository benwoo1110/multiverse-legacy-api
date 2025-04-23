package com.onarandombox.mv5remap;

import com.onarandombox.MultiverseCore.MVWorld;
import com.onarandombox.MultiverseCore.event.MVRespawnEvent;
import com.onarandombox.MultiverseCore.event.MVWorldDeleteEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
public class CoreLegacyEventMapper extends LegacyEventMapper implements Listener {

    @EventHandler
    private void onMVWorldDeleteEvent(org.mvplugins.multiverse.core.event.world.MVWorldDeleteEvent event) {
        callEvent(new MVWorldDeleteEvent(new MVWorld(event.getWorld()), true), event);
    }

    @EventHandler
    private void onMVRespawnEvent(org.mvplugins.multiverse.core.event.MVRespawnEvent event) {
        callEvent(new MVRespawnEvent(event.getRespawnLocation(), event.getPlayer(), "compatibility"), event);
    }
}
