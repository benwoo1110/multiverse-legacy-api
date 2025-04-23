package com.onarandombox.multiverseinventories.event;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;

/**
 * Called when a player has changed from one world to another. Cancellable.
 */
public abstract class ShareHandlingEvent extends Event implements Cancellable {

    private boolean cancelled;

    private final Player player;
    ShareHandlingEvent(Player player) {
        this.player = player;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isCancelled() {
        return this.cancelled;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
    }

    /**
     * @return The player involved in this sharing transaction.
     */
    public Player getPlayer() {
        return this.player;
    }
}
