package com.onarandombox.legacy.events;

import org.bukkit.Bukkit;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
abstract class LegacyEventMapper {
    protected void callEvent(Event legacyEvent, Event event) {
        Bukkit.getPluginManager().callEvent(legacyEvent);
        if (legacyEvent instanceof Cancellable legacyCancellable && event instanceof Cancellable cancellable) {
            if (legacyCancellable.isCancelled()) {
                cancellable.setCancelled(true);
            }
        }
    }
}
