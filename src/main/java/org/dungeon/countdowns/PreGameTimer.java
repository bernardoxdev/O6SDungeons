package org.dungeon.countdowns;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;
import org.dungeon.GameStates;
import org.dungeon.O6SDungeon;
import org.dungeon.managers.ChatManager;

public class PreGameTimer {

    private final O6SDungeon main;

    public PreGameTimer(O6SDungeon main) {
        this.main = main;
    }

    public void startCountdown() {
        new BukkitRunnable() {

            int number = 30;

            @Override
            public void run() {
                if (number > 0) {
                    if (number == 30) {
                        main.setGameStates(GameStates.PREGAME);
                        Bukkit.broadcastMessage(new ChatManager(main).prefix + "Game starting in 30 seconds.");
                    }
                    if (number == 20) {
                        Bukkit.broadcastMessage(new ChatManager(main).prefix + "Game starting in 20 seconds.");
                    }
                    if (number == 10) {
                        Bukkit.broadcastMessage(new ChatManager(main).prefix + "Game starting in 10 seconds.");
                    }
                    if (number == 5) {
                        Bukkit.broadcastMessage(new ChatManager(main).prefix + "Game starting in 5 seconds.");
                    }
                    if (number == 4) {
                        Bukkit.broadcastMessage(new ChatManager(main).prefix + "Game starting in 4 seconds.");
                    }
                    if (number == 3) {
                        Bukkit.broadcastMessage(new ChatManager(main).prefix + "Game starting in 3 seconds.");
                    }
                    if (number == 2) {
                        Bukkit.broadcastMessage(new ChatManager(main).prefix + "Game starting in 2 seconds.");
                    }
                    if (number == 1) {
                        Bukkit.broadcastMessage(new ChatManager(main).prefix + "Game starting in 1 second.");
                        // DO PREGAME THINGS, SCATTER, KITS, ETC
                    }
                    number--;
                } else {
                    Bukkit.broadcastMessage(new ChatManager(main).prefix + "The game has now started!");
                    cancel();
                }
            }
        }.runTaskTimer(main,20L, 20L);
    }

}
