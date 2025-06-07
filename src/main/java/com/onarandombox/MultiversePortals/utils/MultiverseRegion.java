package com.onarandombox.MultiversePortals.utils;

import com.onarandombox.MultiverseCore.MVWorld;
import com.onarandombox.MultiverseCore.api.MultiverseWorld;
import org.bukkit.Location;
import org.bukkit.util.Vector;

public class MultiverseRegion {

    private final org.mvplugins.multiverse.portals.utils.MultiverseRegion region;

    public MultiverseRegion(org.mvplugins.multiverse.portals.utils.MultiverseRegion region) {
        this.region = region;
    }

    public Vector getMinimumPoint() {
        return region.getMinimumPoint();
    }

    public Vector getMaximumPoint() {
        return region.getMaximumPoint();
    }

    public MultiverseWorld getWorld() {
        return new MVWorld(region.getWorld());
    }

    public int getWidth() {
        return region.getWidth();
    }

    public int getHeight() {
        return region.getHeight();
    }

    public int getDepth() {
        return region.getDepth();
    }

    public int getArea() {
        return region.getArea();
    }

    public boolean containsVector(Location l) {
        return region.containsVector(l);
    }
}
