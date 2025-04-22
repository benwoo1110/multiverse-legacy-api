package com.onarandombox.MultiverseCore.enums;

import org.bukkit.PortalType;

/**
 * Custom enum that adds all/none for allowing portal creation.
 */
public enum AllowedPortalType {
    /**
     * No portals are allowed.
     */
    NONE(PortalType.CUSTOM),
    /**
     * All portal types are allowed.
     */
    ALL(PortalType.CUSTOM),
    /**
     * Only Nether style portals are allowed.
     */
    NETHER(PortalType.NETHER),
    /**
     * Only Ender style portals are allowed.
     */
    END(PortalType.ENDER);

    private PortalType type;

    AllowedPortalType(PortalType type) {
        this.type = type;
    }

    /**
     * Gets the text.
     * @return The text.
     */
    public PortalType getActualPortalType() {
        return this.type;
    }

    public boolean isPortalAllowed(PortalType portalType) {
        return this != NONE && (getActualPortalType() == portalType || this == ALL);
    }

    public org.mvplugins.multiverse.core.world.AllowedPortalType toNewAllowedPortalType() {
        return switch (this) {
            case NONE -> org.mvplugins.multiverse.core.world.AllowedPortalType.NONE;
            case ALL -> org.mvplugins.multiverse.core.world.AllowedPortalType.ALL;
            case NETHER -> org.mvplugins.multiverse.core.world.AllowedPortalType.NETHER;
            case END -> org.mvplugins.multiverse.core.world.AllowedPortalType.END;
            default -> org.mvplugins.multiverse.core.world.AllowedPortalType.NONE;
        };
    }

    public static AllowedPortalType fromNewAllowedPortalType(org.mvplugins.multiverse.core.world.AllowedPortalType portalType) {
        return switch (portalType) {
            case NONE -> NONE;
            case ALL -> ALL;
            case NETHER -> NETHER;
            case END -> END;
            default -> NONE;
        };
    }
}
