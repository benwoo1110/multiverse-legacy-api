package com.onarandombox.MultiverseCore;

import com.onarandombox.MultiverseCore.api.MultiverseWorld;
import com.onarandombox.MultiverseCore.enums.AllowedPortalType;
import com.onarandombox.MultiverseCore.exceptions.PropertyDoesNotExistException;
import org.bukkit.ChatColor;
import org.bukkit.Difficulty;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.WorldType;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.SpawnCategory;
import org.bukkit.permissions.Permission;
import org.mvplugins.multiverse.core.world.LoadedMultiverseWorld;

import javax.annotation.Nullable;
import java.util.List;

public class MVWorld implements MultiverseWorld {

    private final LoadedMultiverseWorld mvWorld;

    public MVWorld(LoadedMultiverseWorld mvWorld) {
        this.mvWorld = mvWorld;
    }

    @Override
    public World getCBWorld() {
        return mvWorld.getBukkitWorld().getOrNull();
    }

    @Override
    public String getName() {
        return mvWorld.getName();
    }

    @Override
    public WorldType getWorldType() {
        return mvWorld.getWorldType().getOrNull();
    }

    @Override
    public World.Environment getEnvironment() {
        return mvWorld.getEnvironment();
    }

    @Override
    public void setEnvironment(World.Environment environment) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Difficulty getDifficulty() {
        return mvWorld.getDifficulty();
    }

    @Override
    public boolean setDifficulty(Difficulty difficulty) {
        return mvWorld.setDifficulty(difficulty).isSuccess();
    }

    @Override
    public long getSeed() {
        return mvWorld.getSeed();
    }

    @Override
    public void setSeed(long seed) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String getGenerator() {
        return mvWorld.getGenerator();
    }

    @Override
    public void setGenerator(String generator) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String getPropertyHelp(String property) throws PropertyDoesNotExistException {
        throw new UnsupportedOperationException();
    }

    @Override
    public String getPropertyValue(String property) throws PropertyDoesNotExistException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean setPropertyValue(String property, String value) throws PropertyDoesNotExistException {
        throw new UnsupportedOperationException();
    }

    @Override
    public String getPermissibleName() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Permission getAccessPermission() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Permission getExemptPermission() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String getAlias() {
        return mvWorld.getAlias();
    }

    @Override
    public void setAlias(String alias) {
        mvWorld.setAlias(alias);
    }

    @Override
    public ChatColor getColor() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean setColor(String color) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ChatColor getStyle() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean setStyle(String style) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String getColoredWorldString() {
        return mvWorld.getAliasOrName();
    }

    @Override
    public boolean canAnimalsSpawn() {
        return mvWorld.getEntitySpawnConfig().getSpawnCategoryConfig(SpawnCategory.ANIMAL).isSpawn();
    }

    @Override
    public void setAllowAnimalSpawn(boolean allowAnimalSpawn) {
        mvWorld.getEntitySpawnConfig().getSpawnCategoryConfig(SpawnCategory.ANIMAL).setSpawn(allowAnimalSpawn);
    }

    @Override
    public List<String> getAnimalList() {
        return mvWorld.getEntitySpawnConfig().getSpawnCategoryConfig(SpawnCategory.ANIMAL).getExceptions()
                .stream()
                .map(EntityType::name)
                .toList();
    }

    @Override
    public boolean canMonstersSpawn() {
        return mvWorld.getEntitySpawnConfig().getSpawnCategoryConfig(SpawnCategory.MONSTER).isSpawn();
    }

    @Override
    public void setAllowMonsterSpawn(boolean allowMonsterSpawn) {
        mvWorld.getEntitySpawnConfig().getSpawnCategoryConfig(SpawnCategory.MONSTER).setSpawn(allowMonsterSpawn);
    }

    @Override
    public List<String> getMonsterList() {
        return mvWorld.getEntitySpawnConfig().getSpawnCategoryConfig(SpawnCategory.MONSTER).getExceptions()
                .stream()
                .map(EntityType::name)
                .toList();
    }

    @Override
    public boolean isPVPEnabled() {
        return mvWorld.getPvp();
    }

    @Override
    public void setPVPMode(boolean pvpMode) {
        mvWorld.setPvp(pvpMode);
    }

    @Override
    public boolean isHidden() {
        return mvWorld.isHidden();
    }

    @Override
    public void setHidden(boolean hidden) {
        mvWorld.setHidden(hidden);
    }

    @Override
    public boolean isWeatherEnabled() {
        return mvWorld.isAllowWeather();
    }

    @Override
    public void setEnableWeather(boolean enableWeather) {
        mvWorld.setAllowWeather(enableWeather);
    }

    @Override
    public boolean isKeepingSpawnInMemory() {
        return mvWorld.isKeepSpawnInMemory();
    }

    @Override
    public void setKeepSpawnInMemory(boolean keepSpawnInMemory) {
        mvWorld.setKeepSpawnInMemory(keepSpawnInMemory);
    }

    @Override
    public Location getSpawnLocation() {
        return mvWorld.getSpawnLocation();
    }

    @Override
    public void setSpawnLocation(Location spawnLocation) {
        mvWorld.setSpawnLocation(spawnLocation);
    }

    @Override
    public boolean getHunger() {
        return mvWorld.isHunger();
    }

    @Override
    public void setHunger(boolean hungerEnabled) {
        mvWorld.setHunger(hungerEnabled);
    }

    @Override
    public GameMode getGameMode() {
        return mvWorld.getGameMode();
    }

    @Override
    public boolean setGameMode(GameMode gameMode) {
        return mvWorld.setGameMode(gameMode).isSuccess();
    }

    @Override
    public double getPrice() {
        return mvWorld.getPrice();
    }

    @Override
    public void setPrice(double price) {
        mvWorld.setPrice(price);
    }

    @Nullable
    @Override
    public Material getCurrency() {
        return mvWorld.getCurrency();
    }

    @Override
    public void setCurrency(@Nullable Material item) {
        mvWorld.setCurrency(item);
    }

    @Override
    public World getRespawnToWorld() {
        return mvWorld.getRespawnWorld();
    }

    @Override
    public boolean setRespawnToWorld(String respawnWorld) {
        return mvWorld.setRespawnWorld(respawnWorld).isSuccess();
    }

    @Override
    public double getScaling() {
        return mvWorld.getScale();
    }

    @Override
    public boolean setScaling(double scaling) {
        return mvWorld.setScale(scaling).isSuccess();
    }

    @Override
    public boolean getAutoHeal() {
        return mvWorld.getAutoHeal();
    }

    @Override
    public void setAutoHeal(boolean heal) {
        mvWorld.setAutoHeal(heal);
    }

    @Override
    public boolean getAdjustSpawn() {
        return mvWorld.getAdjustSpawn();
    }

    @Override
    public void setAdjustSpawn(boolean adjust) {
        mvWorld.setAdjustSpawn(adjust);
    }

    @Override
    public boolean getAutoLoad() {
        return mvWorld.isAutoLoad();
    }

    @Override
    public void setAutoLoad(boolean autoLoad) {
        mvWorld.setAutoLoad(autoLoad);
    }

    @Override
    public boolean getBedRespawn() {
        return mvWorld.getBedRespawn();
    }

    @Override
    public void setBedRespawn(boolean bedRespawn) {
        mvWorld.setBedRespawn(bedRespawn);
    }

    @Override
    public void setPlayerLimit(int limit) {
        mvWorld.setPlayerLimit(limit);
    }

    @Override
    public int getPlayerLimit() {
        return mvWorld.getPlayerLimit();
    }

    @Override
    public String getTime() {
       throw new UnsupportedOperationException();
    }

    @Override
    public boolean setTime(String timeAsString) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void allowPortalMaking(AllowedPortalType type) {
        mvWorld.setPortalForm(type.toNewAllowedPortalType());
    }

    @Override
    public AllowedPortalType getAllowedPortals() {
        return AllowedPortalType.fromNewAllowedPortalType(mvWorld.getPortalForm());
    }

    @Override
    public List<String> getWorldBlacklist() {
        return mvWorld.getWorldBlacklist();
    }

    @Override
    public String getAllPropertyNames() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean getAllowFlight() {
        return mvWorld.isAllowFlight();
    }

    @Override
    public void setAllowFlight(boolean allowFlight) {
        mvWorld.setAllowFlight(allowFlight);
    }
}
