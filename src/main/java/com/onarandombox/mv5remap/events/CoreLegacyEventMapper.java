package com.onarandombox.mv5remap.events;

import com.onarandombox.MultiverseCore.MVWorld;
import com.onarandombox.MultiverseCore.event.MVPlayerTouchedPortalEvent;
import com.onarandombox.MultiverseCore.event.MVRespawnEvent;
import com.onarandombox.MultiverseCore.event.MVTeleportEvent;
import com.onarandombox.MultiverseCore.event.MVWorldDeleteEvent;
import com.onarandombox.mv5remap.destinations.MVDestinationMapper;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
public class CoreLegacyEventMapper extends LegacyEventMapper implements Listener {

    @EventHandler
    private void onMVPlayerTouchedPortalEvent(org.mvplugins.multiverse.core.event.MVPlayerTouchedPortalEvent event) {
        callEvent(new MVPlayerTouchedPortalEvent(event.getPlayer(), event.getBlockTouched()), event);
    }

    @EventHandler
    private void onMVRespawnEvent(org.mvplugins.multiverse.core.event.MVRespawnEvent event) {
        callEvent(new MVRespawnEvent(event.getRespawnLocation(), event.getPlayer(), "compatibility"), event);
    }

    @EventHandler
    private void onMVTeleportEvent(org.mvplugins.multiverse.core.event.MVTeleportDestinationEvent event) {
        if (!(event.getTeleportee() instanceof Player teleportee)) {
            return;
        }
        callEvent(new MVTeleportEvent(
                MVDestinationMapper.fromDestinationInstance(event.getDestination()),
                teleportee,
                event.getTeleporter(),
                event.getDestination().checkTeleportSafety()
        ), event);
    }

    @EventHandler
    private void onMVWorldDeleteEvent(org.mvplugins.multiverse.core.event.world.MVWorldDeleteEvent event) {
        callEvent(new MVWorldDeleteEvent(new MVWorld(event.getWorld()), true), event);
    }
}
