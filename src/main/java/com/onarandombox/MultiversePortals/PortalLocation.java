package com.onarandombox.MultiversePortals;

import com.onarandombox.MultiverseCore.MVWorld;
import com.onarandombox.MultiverseCore.api.MultiverseWorld;
import com.onarandombox.MultiversePortals.utils.MultiverseRegion;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.ApiStatus;

import java.util.List;

public class PortalLocation {

    private final org.mvplugins.multiverse.portals.PortalLocation portalLocation;

    public PortalLocation(org.mvplugins.multiverse.portals.PortalLocation portalLocation) {
        this.portalLocation = portalLocation;
    }

    public boolean setLocation(Vector v1, Vector v2, MultiverseWorld world) {
        throw new UnsupportedOperationException();
    }

    public boolean setLocation(String v1, String v2, MultiverseWorld world) {
        throw new UnsupportedOperationException();
    }

    public boolean isValidLocation() {
        return portalLocation.isValidLocation();
    }

    public List<Vector> getVectors() {
        return portalLocation.getVectors();
    }

    public Vector getMinimum() {
        return portalLocation.getMinimum();
    }

    public Vector getMaximum() {
        return portalLocation.getMaximum();
    }

    @Override
    public String toString() {
        return portalLocation.toString();
    }

    public MultiverseWorld getMVWorld() {
        return new MVWorld(portalLocation.getMVWorld());
    }

    public MultiverseRegion getRegion() {
        return new MultiverseRegion(portalLocation.getRegion());
    }

    @ApiStatus.Internal
    public org.mvplugins.multiverse.portals.PortalLocation getWrappedPortalLocation() {
        return portalLocation;
    }
}
