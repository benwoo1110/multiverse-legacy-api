package com.onarandombox.legacy.destinations;

import com.onarandombox.MultiverseCore.api.MVDestination;
import com.onarandombox.MultiverseCore.destination.AnchorDestination;
import com.onarandombox.MultiverseCore.destination.BedDestination;
import com.onarandombox.MultiverseCore.destination.CannonDestination;
import com.onarandombox.MultiverseCore.destination.ExactDestination;
import com.onarandombox.MultiverseCore.destination.InvalidDestination;
import com.onarandombox.MultiverseCore.destination.PlayerDestination;
import com.onarandombox.MultiverseCore.destination.WorldDestination;
import org.jetbrains.annotations.ApiStatus;
import org.mvplugins.multiverse.core.destination.DestinationInstance;

@ApiStatus.Internal
public final class MVDestinationMapper {

    public static MVDestination fromDestinationInstance(DestinationInstance<?, ?> destinationInstance) {
        if (destinationInstance == null) {
            return new InvalidDestination();
        }
        return switch (destinationInstance.getIdentifier()) {
            case "a" -> new AnchorDestination(destinationInstance);
            case "b" -> new BedDestination(destinationInstance);
            case "ca" -> new CannonDestination(destinationInstance);
            case "e" -> new ExactDestination(destinationInstance);
            case "pl" -> new PlayerDestination(destinationInstance);
            case "w" -> new WorldDestination(destinationInstance);
            default -> new LegacyMVDestination(destinationInstance);
        };
    }
}
