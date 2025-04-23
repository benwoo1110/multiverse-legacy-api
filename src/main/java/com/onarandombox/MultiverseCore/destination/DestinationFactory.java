package com.onarandombox.MultiverseCore.destination;

import com.onarandombox.MultiverseCore.api.MVDestination;
import com.onarandombox.mv5remap.destinations.DestinationInstanceMapper;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.mvplugins.multiverse.core.destination.Destination;
import org.mvplugins.multiverse.core.destination.DestinationsProvider;

import java.util.Collection;

public class DestinationFactory {

    private final DestinationsProvider destinationsProvider;

    public DestinationFactory(DestinationsProvider destinationsProvider) {
        this.destinationsProvider = destinationsProvider;
    }

    /**
     * Parse a destination that has relation to sender, such as a cannon or player destination.
     *
     * @param teleportee        The player that is going to be teleported.
     * @param destinationName   The destination to parse.
     * @return A non-null MVDestination
     */
    @NotNull
    public MVDestination getPlayerAwareDestination(@NotNull Player teleportee,
                                                   @NotNull String destinationName) {
        return getDestination(destinationName);
    }

    /**
     * Gets a new destination from a string.
     * Returns a new InvalidDestination if the string could not be parsed.
     *
     * @param destination The destination in string format.
     *
     * @return A non-null MVDestination
     */
    public MVDestination getDestination(String destination) {
        return DestinationInstanceMapper.fromDestinationInstance(
                destinationsProvider.parseDestination(destination).getOrNull());
    }

    /**
     * Registers a {@link MVDestination}.
     *
     * @param c The {@link Class} of the {@link MVDestination} to register.
     * @param identifier The {@link String}-identifier.
     * @return True if the class was successfully registered.
     */
    public boolean registerDestinationType(Class<? extends MVDestination> c, String identifier) {
        throw new UnsupportedOperationException();
    }

    /**
     * Gets all the {@link MVDestination} identifiers registered.
     *
     * @return A collection of destination identifiers.
     */
    public Collection<String> getRegisteredIdentifiers() {
        return destinationsProvider.getDestinations().stream()
                .map(Destination::getIdentifier)
                .toList();
    }
}
