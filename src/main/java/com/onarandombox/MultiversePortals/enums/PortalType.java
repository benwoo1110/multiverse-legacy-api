package com.onarandombox.MultiversePortals.enums;

/**
 * What type of portal was used?
 *
 * If Legacy, a MV1 style portal was used.
 * If Normal, a Nether style portal (with purple goo) was used.
 *
 */
public enum PortalType {
    Legacy, Normal;

    public static PortalType fromNewPortalType(org.mvplugins.multiverse.portals.enums.PortalType portalType) {
        return switch (portalType) {
            case Legacy -> Legacy;
            case Normal -> Normal;
            default -> Legacy;
        };
    }
}
