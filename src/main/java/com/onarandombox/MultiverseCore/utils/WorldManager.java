package com.onarandombox.MultiverseCore.utils;

import com.onarandombox.MultiverseCore.MVWorld;
import com.onarandombox.MultiverseCore.api.MVWorldManager;
import com.onarandombox.MultiverseCore.api.MultiverseWorld;
import com.onarandombox.MultiverseCore.api.WorldPurger;
import org.bukkit.World;
import org.bukkit.World.Environment;
import org.bukkit.WorldType;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.generator.ChunkGenerator;
import org.mvplugins.multiverse.core.world.helpers.PlayerWorldTeleporter;
import org.mvplugins.multiverse.core.world.options.CloneWorldOptions;
import org.mvplugins.multiverse.core.world.options.CreateWorldOptions;
import org.mvplugins.multiverse.core.world.options.DeleteWorldOptions;
import org.mvplugins.multiverse.core.world.options.RegenWorldOptions;
import org.mvplugins.multiverse.core.world.options.UnloadWorldOptions;
import org.mvplugins.multiverse.external.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.Collection;
import java.util.List;

public class WorldManager implements MVWorldManager {

    private final org.mvplugins.multiverse.core.world.WorldManager worldManager;
    private final PlayerWorldTeleporter playerWorldTeleporter;

    public WorldManager(
            @NotNull org.mvplugins.multiverse.core.world.WorldManager worldManager,
            @NotNull PlayerWorldTeleporter playerWorldTeleporter
    ) {
        this.worldManager = worldManager;
        this.playerWorldTeleporter = playerWorldTeleporter;
    }

    @Override
    public boolean addWorld(String name, Environment env, String seedString, WorldType type, Boolean generateStructures, String generator) {
        return addWorld(name, env, seedString, type, generateStructures, generator, true);
    }

    @Override
    public boolean addWorld(String name, Environment env, String seedString, WorldType type, Boolean generateStructures, String generator, boolean useSpawnAdjust) {
         return worldManager.createWorld(CreateWorldOptions.worldName(name)
                .environment(env)
                .seed(seedString)
                .worldType(type)
                .generateStructures(generateStructures)
                .generator(generator)
                .useSpawnAdjust(useSpawnAdjust)
         ).isSuccess();
    }

    @Override
    public boolean cloneWorld(String oldName, String newName) {
        return worldManager.cloneWorld(CloneWorldOptions.fromTo(
                worldManager.getLoadedWorld(oldName).getOrNull(),
                newName)
        ).isSuccess();
    }

    @Override
    public boolean deleteWorld(String name) {
        return worldManager.getWorld(name)
                .map(world -> worldManager.deleteWorld(DeleteWorldOptions.world(world)).isSuccess())
                .getOrElse(false);
    }

    @Override
    public boolean deleteWorld(String name, boolean removeConfig) {
        return worldManager.getWorld(name)
                .map(world -> worldManager.deleteWorld(DeleteWorldOptions.world(world)).isSuccess())
                .getOrElse(false);
    }

    @Override
    public boolean deleteWorld(String name, boolean removeFromConfig, boolean deleteWorldFolder) {
        return worldManager.getWorld(name)
                .map(world -> worldManager.deleteWorld(DeleteWorldOptions.world(world)).isSuccess())
                .getOrElse(false);
    }

    @Override
    public boolean unloadWorld(String name) {
        return worldManager.unloadWorld(UnloadWorldOptions.world(
                worldManager.getLoadedWorld(name).getOrNull())
        ).isSuccess();
    }

    @Override
    public boolean unloadWorld(String name, boolean unloadBukkit) {
        return worldManager.unloadWorld(UnloadWorldOptions.world(
                worldManager.getLoadedWorld(name).getOrNull())
        ).isSuccess();
    }

    @Override
    public boolean loadWorld(String name) {
        return worldManager.loadWorld(name).isSuccess();
    }

    @Override
    public void removePlayersFromWorld(String name) {
        playerWorldTeleporter.removeFromWorld(worldManager.getLoadedWorld(name).getOrNull());
    }

    @Override
    public ChunkGenerator getChunkGenerator(String generator, String generatorID, String worldName) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Collection<MultiverseWorld> getMVWorlds() {
        return worldManager.getLoadedWorlds()
                .stream()
                .map(MVWorld::new)
                .map(world -> (MultiverseWorld) world)
                .toList();
    }

    @Override
    public MultiverseWorld getMVWorld(String name) {
        return worldManager.getLoadedWorld(name)
                .map(MVWorld::new)
                .getOrNull();
    }

    @Override
    public MultiverseWorld getMVWorld(String name, boolean checkAliases) {
        return worldManager.getLoadedWorldByNameOrAlias(name)
                .map(MVWorld::new)
                .getOrNull();
    }

    @Override
    public MultiverseWorld getMVWorld(World world) {
        return worldManager.getLoadedWorld(world)
                .map(MVWorld::new)
                .getOrNull();
    }

    @Override
    public boolean isMVWorld(String name) {
        return worldManager.isLoadedWorld(name);
    }

    @Override
    public boolean isMVWorld(String name, boolean checkAliases) {
        return worldManager.getLoadedWorldByNameOrAlias(name).isDefined();
    }

    @Override
    public boolean isMVWorld(World world) {
        return worldManager.isLoadedWorld(world);
    }

    @Override
    public void loadWorlds(boolean forceLoad) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void loadDefaultWorlds() {
        throw new UnsupportedOperationException();
    }

    @Override
    public WorldPurger getTheWorldPurger() {
        throw new UnsupportedOperationException();
    }

    @Override
    public MultiverseWorld getSpawnWorld() {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> getUnloadedWorlds() {
        return worldManager.getUnloadedWorlds()
                .stream()
                .map(org.mvplugins.multiverse.core.world.MultiverseWorld::getName)
                .toList();
    }

    @Override
    public void getDefaultWorldGenerators() {
        throw new UnsupportedOperationException();
    }

    @Override
    public FileConfiguration loadWorldConfig(File file) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean saveWorldsConfig() {
        return worldManager.saveWorldsConfig().isSuccess();
    }

    @Override
    public boolean removeWorldFromConfig(String name) {
        return worldManager.removeWorld(name).isSuccess();
    }

    @Override
    public void setFirstSpawnWorld(String world) {
        throw new UnsupportedOperationException();
    }

    @Override
    public MultiverseWorld getFirstSpawnWorld() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean regenWorld(String name, boolean useNewSeed, boolean randomSeed, String seed) {
        return regenWorld(name, useNewSeed, randomSeed, seed, false);
    }

    @Override
    public boolean regenWorld(String name, boolean useNewSeed, boolean randomSeed, String seed, boolean keepGameRules) {
        return worldManager.regenWorld(RegenWorldOptions
                .world(worldManager.getLoadedWorld(name).getOrNull())
                .randomSeed(randomSeed)
                .seed(seed)
                .keepGameRule(keepGameRules)
        ).isSuccess();
    }

    @Override
    public boolean isKeepingSpawnInMemory(World world) {
        return world.getKeepSpawnInMemory();
    }

    @Override
    public boolean hasUnloadedWorld(String name, boolean includeLoaded) {
        return includeLoaded ? worldManager.isWorld(name) : worldManager.isUnloadedWorld(name);
    }

    @Override
    public Collection<String> getPotentialWorlds() {
        return worldManager.getPotentialWorlds();
    }
}
