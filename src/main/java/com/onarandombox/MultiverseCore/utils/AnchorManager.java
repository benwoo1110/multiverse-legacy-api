package com.onarandombox.MultiverseCore.utils;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.mvplugins.multiverse.core.anchor.MultiverseAnchor;

import java.util.Set;
import java.util.stream.Collectors;

public class AnchorManager {

    private final org.mvplugins.multiverse.core.anchor.AnchorManager anchorManager;

    public AnchorManager(org.mvplugins.multiverse.core.anchor.AnchorManager anchorManager) {
        this.anchorManager = anchorManager;
    }

    /**
     * Loads all anchors.
     */
    public void loadAnchors() {
        anchorManager.loadAnchors();
    }

    /**
     * Saves all anchors.
     * @return True if all anchors were successfully saved.
     */
    public boolean saveAnchors() {
        return anchorManager.saveAllAnchors().isSuccess();
    }

    /**
     * Gets the {@link Location} associated with an anchor.
     * @param anchor The name of the anchor.
     * @return The {@link Location}.
     */
    public Location getAnchorLocation(String anchor) {
        return anchorManager.getAnchor(anchor).map(MultiverseAnchor::getLocation).getOrNull();
    }

    /**
     * Saves an anchor.
     * @param anchor The name of the anchor.
     * @param location The location of the anchor as string.
     * @return True if the anchor was successfully saved.
     */
    public boolean saveAnchorLocation(String anchor, String location) {
        return anchorManager.setAnchor(anchor, location).isSuccess();
    }

    /**
     * Saves an anchor.
     * @param anchor The name of the anchor.
     * @param l The {@link Location} of the anchor.
     * @return True if the anchor was successfully saved.
     */
    public boolean saveAnchorLocation(String anchor, Location l) {
        return anchorManager.setAnchor(anchor, l).isSuccess();
    }

    /**
     * Gets all anchors.
     * @return An unmodifiable {@link Set} containing all anchors.
     */
    public Set<String> getAllAnchors() {
        return anchorManager.getAllAnchors().stream()
                .map(MultiverseAnchor::getName)
                .collect(Collectors.toSet());
    }

    /**
     * Gets all anchors that the specified {@link Player} can access.
     * @param p The {@link Player}.
     * @return An unmodifiable {@link Set} containing all anchors the specified {@link Player} can access.
     */
    public Set<String> getAnchors(Player p) {
        return anchorManager.getAnchors(p).stream()
                .map(MultiverseAnchor::getName)
                .collect(Collectors.toSet());
    }

    /**
     * Deletes the specified anchor.
     * @param s The name of the anchor.
     * @return True if the anchor was successfully deleted.
     */
    public boolean deleteAnchor(String s) {
        return anchorManager.deleteAnchor(anchorManager.getAnchor(s).getOrNull()).isSuccess();
    }
}
