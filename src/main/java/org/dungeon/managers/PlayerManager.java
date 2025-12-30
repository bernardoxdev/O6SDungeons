package org.dungeon.managers;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.dungeon.GameStates;
import org.dungeon.O6SDungeon;
import org.dungeon.commands.CommandVanish;

public class PlayerManager {

    private final O6SDungeon main;
    public PlayerManager(O6SDungeon main) {
        this.main = main;
    }

    public void handle(Player player) {
        if (main.getGameStates() == GameStates.LOBBY) {
            main.alive.remove(player);
            main.spectating.remove(player);
            main.alive.add(player);
            player.setExp(0);
            player.setTotalExperience(0);
            player.setHealth(20);
            player.setFoodLevel(20);
            player.setGameMode(GameMode.SURVIVAL);
            player.setAllowFlight(false);
            player.sendMessage(new ChatManager(main).prefix + "Welcome to the MiniGame!");
            Bukkit.broadcastMessage(new ChatManager(main).prefix + player.getDisplayName() + " has joined the minigame.");
        } else if (main.getGameStates() == GameStates.INGAME || main.getGameStates() == GameStates.ENDGAME || main.getGameStates() == GameStates.PREGAME) {
            main.alive.remove(player);
            main.spectating.remove(player);
            main.spectating.add(player);
            new CommandVanish(main).toggleVanish(player);
            Bukkit.broadcastMessage(new ChatManager(main).prefix + player.getDisplayName() + " has joined as a spectator.");
        }
    }
}