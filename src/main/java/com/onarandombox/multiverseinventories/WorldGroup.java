package com.onarandombox.multiverseinventories;

import org.bukkit.World;
import org.bukkit.event.EventPriority;

import java.util.Collection;
import java.util.Set;

public final class WorldGroup {

    private final org.mvplugins.multiverse.inventories.profile.group.WorldGroup worldGroup;

    WorldGroup(org.mvplugins.multiverse.inventories.profile.group.WorldGroup worldGroup) {
        this.worldGroup = worldGroup;
    }

    /**
     * Get the name of this World Group.
     *
     * @return Name of this World Group.
     */
    public String getName() {
        return worldGroup.getName();
    }

    /**
     * Adds a world to this world group and updates it in the Config.
     *
     * @param worldName The name of the world to add.
     */
    public void addWorld(String worldName) {
        worldGroup.addWorld(worldName);
    }

    /**
     * Adds a world to this world group and optionally updates it in the Config.
     *
     * @param worldName    The name of the world to add.
     * @param updateConfig True to update this group in the config.
     */
    public void addWorld(String worldName, boolean updateConfig) {
        worldGroup.addWorld(worldName, updateConfig);
    }

    /**
     * Convenience method to add a {@link org.bukkit.World} to this World Group.
     *
     * @param world The world to add.
     */
    public void addWorld(World world) {
        worldGroup.addWorld(world);
    }

    /**
     * Convenience method to add multiple worlds to this World Group and updates it in the Config.
     *
     * @param worlds A collections of worlds to add.
     */
    public void addWorlds(Collection<String> worlds) {
        worldGroup.addWorlds(worlds);
    }

    /**
     * Convenience method to add multiple worlds to this World Group.
     *
     * @param worlds A collections of worlds to add.
     * @param updateConfig True to update this group in the config.
     */
    public void addWorlds(Collection<String> worlds, boolean updateConfig) {
        worldGroup.addWorlds(worlds, updateConfig);
    }

    /**
     * Removes a world from this world group and updates the group in the Config.
     *
     * @param worldName The name of the world to remove.
     */
    public void removeWorld(String worldName) {
        worldGroup.removeWorld(worldName);
    }

    /**
     * Removes a world from this world group and optionally updates it in the Config.
     *
     * @param worldName    The name of the world to remove.
     * @param updateConfig True to update this group in the config.
     */
    public void removeWorld(String worldName, boolean updateConfig) {
        worldGroup.removeWorld(worldName, updateConfig);
    }

    /**
     * Convenience method to remove a {@link org.bukkit.World} from this World Group.
     *
     * @param world The world to remove.
     */
    public void removeWorld(World world) {
        worldGroup.removeWorld(world);
    }

    /**
     * Remove all the worlds in this World Group.
     */
    public void removeAllWorlds() {
        worldGroup.removeAllWorlds();
    }

    /**
     * Remove all the worlds in this World Group.
     *
     * @param updateConfig  True to update this group in the config.
     */
    public void removeAllWorlds(boolean updateConfig) {
        worldGroup.removeAllWorlds(updateConfig);
    }

    /**
     * Retrieves all of the worlds in this World Group.
     *
     * @return The worlds of this World Group.
     */
    public Set<String> getWorlds() {
        return worldGroup.getWorlds();
    }

//    /**
//     * Checks if this group is sharing sharable. This will check both shares and negative shares of the group.
//     * This is the preferred method for checking if a group shares something as shares may contain ALL shares while
//     * ones indicated in negative shares means those aren't actually shared.
//     *
//     * @param sharable Sharable to check if sharing.
//     * @return true is the sharable is shared for this group.
//     */
//    public boolean isSharing(Sharable sharable) {
//
//    }

//    /**
//     * Retrieves the shares for this World Group. Any changes to this group must be subsequently saved to the data
//     * source for the changes to be permanent.
//     *
//     * @return The shares for this World Group.
//     */
//    public Shares getShares() {
//
//    }

    /**
     * @param worldName Name of world to check for.
     * @return True if specified world is part of this group.
     */
    public boolean containsWorld(String worldName) {
        return worldGroup.containsWorld(worldName);
    }

    /**
     * @return The name of the world that will be used as the spawn for this group.
     *         Or null if no world was specified as the group spawn world.
     */
    public String getSpawnWorld() {
        return worldGroup.getSpawnWorld();
    }

    /**
     * @param worldName The name of the world to set this groups spawn to.
     */
    public void setSpawnWorld(String worldName) {
        worldGroup.setSpawnWorld(worldName);
    }

    /**
     * @return The priority for the respawn event that this spawn will act on.
     */
    public EventPriority getSpawnPriority() {
        return worldGroup.getSpawnPriority();
    }

    /**
     * @param priority The priority that will be used for respawning the player at
     *                 this group's spawn location if there is one set.
     */
    public void setSpawnPriority(EventPriority priority) {
        worldGroup.setSpawnPriority(priority);
    }

    /**
     * Is this a default group.
     *
     * @return true if this is the default group.
     */
    public boolean isDefault() {
        return worldGroup.isDefault();
    }

//    /**
//     * Returns the profile container for this group.
//     *
//     * @return the profile container for this group.
//     */
//    public ProfileContainer getGroupProfileContainer() {
//
//    }

    @Override
    public String toString() {
        return worldGroup.toString();
    }
}
