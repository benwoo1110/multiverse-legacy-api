package com.onarandombox.mv5remap.destinations;

import com.onarandombox.MultiverseCore.api.MVDestination;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;
import org.mvplugins.multiverse.core.destination.Destination;
import org.mvplugins.multiverse.core.destination.DestinationInstance;

public class LegacyMVDestination implements MVDestination {

    private final Destination<?, ?, ?> destination;
    private DestinationInstance<?, ?> destinationInstance;

    public LegacyMVDestination(DestinationInstance<?, ?> destinationInstance) {
        this.destination = destinationInstance.getDestination();
        this.destinationInstance = destinationInstance;
    }

    @Override
    public String getIdentifier() {
        return destinationInstance.getIdentifier();
    }

    @Override
    public boolean isThisType(JavaPlugin plugin, String destination) {
        return destinationInstance.getDestination().getDestinationInstance(destination).isSuccess();
    }

    @Override
    public Location getLocation(Entity entity) {
        return destinationInstance.getLocation(entity).getOrNull();
    }

    @Override
    public Vector getVelocity() {
        return destinationInstance.getVelocity(null).getOrNull();
    }

    @Override
    public void setDestination(JavaPlugin plugin, String destination) {
        destinationInstance = this.destination.getDestinationInstance(destination).getOrNull();
    }

    @Override
    public boolean isValid() {
        return destinationInstance != null;
    }

    @Override
    public String getType() {
        return destinationInstance.toString();
    }

    @Override
    public String getName() {
        return destinationInstance.toString();
    }

    @Override
    public String getRequiredPermission() {
        return "";
    }

    @Override
    public boolean useSafeTeleporter() {
        return destinationInstance.checkTeleportSafety();
    }

    @Override
    public String toString() {
        return destinationInstance.toString();
    }
}
