package com.onarandombox.MultiversePortals;

import com.onarandombox.MultiverseCore.api.MVDestination;
import com.onarandombox.MultiverseCore.api.MultiverseWorld;
import com.onarandombox.MultiversePortals.enums.PortalType;
import com.onarandombox.legacy.destinations.MVDestinationMapper;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;

import java.util.Arrays;
import java.util.Collection;
import java.util.regex.Pattern;

public class MVPortal {

    private static final Collection<Material> INTERIOR_MATERIALS = Arrays.asList(Material.NETHER_PORTAL, Material.LEGACY_GRASS,
            Material.VINE, Material.SNOW, Material.AIR, Material.WATER, Material.LAVA);

    public static final Pattern PORTAL_NAME_PATTERN = Pattern.compile("[a-zA-Z0-9_-]+");

    public static boolean isPortalInterior(Material material) {
        return INTERIOR_MATERIALS.contains(material);
    }

    private final org.mvplugins.multiverse.portals.MVPortal mvPortal;

    public MVPortal(org.mvplugins.multiverse.portals.MVPortal mvPortal) {
        this.mvPortal = mvPortal;
    }

    public boolean getTeleportNonPlayers() {
        return mvPortal.getTeleportNonPlayers();
    }

    public boolean useSafeTeleporter() {
        return mvPortal.useSafeTeleporter();
    }

//    public static MVPortal loadMVPortalFromConfig(MultiversePortals instance, String name) {
//
//    }

    public Material getCurrency() {
        return mvPortal.getCurrency();
    }

    public double getPrice() {
        return mvPortal.getPrice();
    }

    public boolean setPortalLocation(String locationString, String worldString) {
        return mvPortal.setPortalLocation(locationString, worldString);
    }

    public boolean setPortalLocation(String locationString, MultiverseWorld world) {
        throw new UnsupportedOperationException();
    }

//    public boolean setPortalLocation(PortalLocation location) {
//
//    }

    public boolean setDestination(String destinationString) {
        return mvPortal.setDestination(destinationString);
    }

    public boolean setExactDestination(Location location) {
        throw new UnsupportedOperationException();
    }

    public Material getFillMaterial() throws IllegalStateException {
        return mvPortal.getFillMaterial();
    }

    public PortalType getPortalType() throws IllegalStateException {
        return PortalType.fromNewPortalType(mvPortal.getPortalType());
    }

    public boolean isLegacyPortal() throws IllegalStateException {
        return mvPortal.isLegacyPortal();
    }

    public boolean playerCanEnterPortal(Player player) {
        return mvPortal.playerCanEnterPortal(player);
    }

    public boolean playerCanFillPortal(Player player) {
        return mvPortal.playerCanFillPortal(player);
    }

    public MVDestination getDestination() {
        return MVDestinationMapper.fromDestinationInstance(mvPortal.getDestination());
    }

    public boolean setProperty(String property, String value) {
        return mvPortal.setProperty(property, value);
    }

    public World getWorld() {
        return mvPortal.getWorld();
    }

    public String getHandlerScript() {
        return mvPortal.getHandlerScript();
    }

    public void setHandlerScript(String handlerScript) {
        mvPortal.setHandlerScript(handlerScript);
    }

    public Permission getPermission() {
        return mvPortal.getPermission();
    }

    public Permission getFillPermission() {
        return mvPortal.getFillPermission();
    }

    public void removePermission() {
        mvPortal.removePermission();
    }

    public boolean isFrameValid(Location l) {
        return mvPortal.isFrameValid(l);
    }

    public Permission getExempt() {
        return mvPortal.getExempt();
    }
}
