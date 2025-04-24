package com.onarandombox.legacy.events;

import com.onarandombox.MultiversePortals.MVPortal;
import com.onarandombox.MultiversePortals.event.MVPortalEvent;
import com.onarandombox.legacy.destinations.MVDestinationMapper;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
public class PortalsLegacyEventMapper extends LegacyEventMapper implements Listener {

    @EventHandler
    private void onMVPortalEvent(org.mvplugins.multiverse.portals.event.MVPortalEvent event) {
        callEvent(new MVPortalEvent(
                MVDestinationMapper.fromDestinationInstance(event.getDestination()),
                event.getTeleportee(),
                new MVPortal(event.getSendingPortal())
        ), event);
    }
}
