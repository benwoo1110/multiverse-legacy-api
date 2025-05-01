package com.onarandombox.legacy.plugin;

import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.generator.BiomeProvider;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginLoader;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.logging.Logger;

@ApiStatus.Internal
public abstract class MockPlugin implements Plugin {

    private final String pluginName;
    private final String pluginVersion;
    private final String mainClass;

    private final File dataFolder;
    private final PluginDescriptionFile pluginDescriptionFile;
    private final File configFile;

    protected MockPlugin(String pluginName, String pluginVersion, String mainClass) {
        this.pluginName = pluginName;
        this.pluginVersion = pluginVersion;
        this.mainClass = mainClass;
        this.dataFolder = new File(Bukkit.getPluginsFolder(), pluginName);
        this.pluginDescriptionFile = new PluginDescriptionFile(pluginName, pluginVersion, mainClass);
        this.configFile = new File(dataFolder, "config.yml");
    }

    @Override
    public @NotNull File getDataFolder() {
        return dataFolder;
    }

    @Override
    public @NotNull PluginDescriptionFile getDescription() {
        return pluginDescriptionFile;
    }

    @Override
    public @NotNull FileConfiguration getConfig() {
        return YamlConfiguration.loadConfiguration(configFile);
    }

    @Override
    public @Nullable InputStream getResource(@NotNull String filename) {
        return null;
    }

    @Override
    public void saveConfig() {

    }

    @Override
    public void saveDefaultConfig() {

    }

    @Override
    public void saveResource(@NotNull String resourcePath, boolean replace) {

    }

    @Override
    public void reloadConfig() {

    }

    @Override
    public @NotNull PluginLoader getPluginLoader() {
        return null;
    }

    @Override
    public @NotNull Server getServer() {
        return Bukkit.getServer();
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public void onDisable() {

    }

    @Override
    public void onLoad() {

    }

    @Override
    public void onEnable() {

    }

    @Override
    public boolean isNaggable() {
        return false;
    }

    @Override
    public void setNaggable(boolean canNag) {

    }

    @Override
    public @Nullable ChunkGenerator getDefaultWorldGenerator(@NotNull String worldName, @Nullable String id) {
        return null;
    }

    @Override
    public @Nullable BiomeProvider getDefaultBiomeProvider(@NotNull String worldName, @Nullable String id) {
        return null;
    }

    @Override
    public @NotNull Logger getLogger() {
        return null;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String @NotNull [] args) {
        return false;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String @NotNull [] args) {
        return List.of();
    }
}
