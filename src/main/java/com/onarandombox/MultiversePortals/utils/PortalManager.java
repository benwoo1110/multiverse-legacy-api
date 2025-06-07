package com.onarandombox.MultiversePortals.utils;

import com.onarandombox.MultiverseCore.api.MultiverseWorld;
import com.onarandombox.MultiversePortals.MVPortal;
import com.onarandombox.MultiversePortals.PortalLocation;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class PortalManager {

    private final org.mvplugins.multiverse.portals.utils.PortalManager portalManager;

    public PortalManager(org.mvplugins.multiverse.portals.utils.PortalManager portalManager) {
        this.portalManager = portalManager;
    }

    public MVPortal getPortal(Player sender, Location l) {
        return new MVPortal(portalManager.getPortal(sender, l));
    }

    public MVPortal getPortal(Player sender, Location l, boolean checkPermission) {
        return new MVPortal(portalManager.getPortal(sender, l, checkPermission));
    }

    @Deprecated
    public MVPortal isPortal(Player sender, Location l) {
        return new MVPortal(portalManager.isPortal(sender, l));
    }

    public boolean isPortal(Location l) {
        return portalManager.isPortal(l);
    }

    public MVPortal getPortal(Location l) {
        return new MVPortal(portalManager.getPortal(l));
    }

    public boolean addPortal(MVPortal portal) {
        return portalManager.addPortal(portal.getWrappedPortal());
    }

    public boolean addPortal(MultiverseWorld world, String name, String owner, PortalLocation location) {
        return portalManager.addPortal(world.getWrappedWorld(), name, owner, location.getWrappedPortalLocation());
    }

    public MVPortal removePortal(String portalName, boolean removeFromConfigs) {
        return new MVPortal(portalManager.removePortal(portalName, removeFromConfigs));
    }

    public List<MVPortal> getAllPortals() {
        return portalManager.getAllPortals().stream().map(MVPortal::new).toList();
    }

    public List<MVPortal> getPortals(CommandSender sender) {
        return portalManager.getPortals(sender).stream().map(MVPortal::new).toList();
    }

    public List<MVPortal> getPortals(CommandSender sender, MultiverseWorld world) {
        return portalManager.getPortals(sender, world.getWrappedWorld()).stream().map(MVPortal::new).toList();
    }

    public MVPortal getPortal(String portalName) {
        return new MVPortal(portalManager.getPortal(portalName));
    }

    public MVPortal getPortal(String portalName, CommandSender sender) {
        return new MVPortal(portalManager.getPortal(portalName, sender));
    }

    public boolean isPortal(String portalName) {
        return portalManager.isPortal(portalName);
    }

    public void removeAll(boolean removeFromConfigs) {
        portalManager.removeAll(removeFromConfigs);
    }
}
