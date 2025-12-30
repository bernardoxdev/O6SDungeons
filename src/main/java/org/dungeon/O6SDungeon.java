package org.dungeon;

import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.dungeon.commands.CommandStart;
import org.dungeon.commands.CommandVanish;
import org.dungeon.listeners.Build;
import org.dungeon.listeners.Damage;
import org.dungeon.listeners.Food;
import org.dungeon.listeners.Join;

import java.util.ArrayList;
import java.util.List;

public final class O6SDungeon extends JavaPlugin {

    public List<Player> alive = new ArrayList<>();
    public List<Player> spectating = new ArrayList<>();
    public List<Player> vanished = new ArrayList<>();

    private static O6SDungeon instance;
    private static GameStates gameStates;

    private final ConsoleCommandSender console = Bukkit.getConsoleSender();
    private final PluginManager pluginManager = Bukkit.getPluginManager();

    @Override
    public void onEnable() {
        setGameStates(GameStates.LOBBY);

        pluginManager.registerEvents(new Join(this), this);
        pluginManager.registerEvents(new Food(this), this);
        pluginManager.registerEvents(new Damage(this), this);
        pluginManager.registerEvents(new Build(this), this);

        getCommand("vanish").setExecutor(new CommandVanish(this));
        getCommand("start").setExecutor(new CommandStart(this));

        console.sendMessage("O6SGameCore ativado!");

        super.onEnable();
    }

    @Override
    public void onDisable() {
        HandlerList.unregisterAll();

        console.sendMessage("O6SGameCore desativado!");

        super.onDisable();
    }

    @Override
    public void onLoad() {
        instance = this;

        super.onLoad();
    }

    public static O6SDungeon getInstance() {
        return instance;
    }

    public GameStates getGameStates() {
        return gameStates;
    }

    public void setGameStates(GameStates gameStates) {
        O6SDungeon.gameStates = gameStates;
    }
}
