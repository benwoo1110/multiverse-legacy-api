package com.onarandombox.multiverseinventories;

import com.onarandombox.multiverseinventories.profile.WorldGroupManager;
import org.bukkit.command.CommandSender;
import org.mvplugins.multiverse.core.command.MVCommandManager;

import java.util.List;

public class YamlWorldGroupManager implements WorldGroupManager {

    private final MVCommandManager commandManager;
    private final org.mvplugins.multiverse.inventories.profile.group.WorldGroupManager worldGroupManager;

    public YamlWorldGroupManager(MVCommandManager commandManager, org.mvplugins.multiverse.inventories.profile.group.WorldGroupManager worldGroupManager) {
        this.commandManager = commandManager;
        this.worldGroupManager = worldGroupManager;
    }

    @Override
    public WorldGroup getGroup(String groupName) {
        return new WorldGroup(worldGroupManager.getGroup(groupName));
    }

    @Override
    public List<WorldGroup> getGroups() {
        return worldGroupManager.getGroups().stream()
                .map(WorldGroup::new)
                .toList();
    }

    @Override
    public List<WorldGroup> getGroupsForWorld(String worldName) {
        return worldGroupManager.getGroupsForWorld(worldName).stream()
                .map(WorldGroup::new)
                .toList();
    }

    @Override
    public boolean hasGroup(String worldName) {
        return !worldGroupManager.getGroupsForWorld(worldName).isEmpty();
    }

    @Override
    public void setGroups(List<WorldGroup> worldGroups) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void addGroup(WorldGroup worldGroup, boolean persist) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void updateGroup(WorldGroup worldGroup) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeGroup(WorldGroup worldGroup) {
        throw new UnsupportedOperationException();
    }

    @Override
    public WorldGroup newEmptyGroup(String name) {
        return new WorldGroup(worldGroupManager.newEmptyGroup(name));
    }

    @Override
    public void createDefaultGroup() {
        worldGroupManager.createDefaultGroup();
    }

    @Override
    public WorldGroup getDefaultGroup() {
        return new WorldGroup(worldGroupManager.getDefaultGroup());
    }

    @Override
    public void checkForConflicts(CommandSender sender) {
        worldGroupManager.checkForConflicts(commandManager.getCommandIssuer(sender));
    }
}
