package org.dungeon.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.dungeon.GameStates;
import org.dungeon.O6SDungeon;
import org.dungeon.countdowns.PreGameTimer;
import org.dungeon.managers.PlayerManager;

public class Join implements Listener {

    private final O6SDungeon main;

    public Join(O6SDungeon main) {
        this.main = main;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player p = event.getPlayer();
        event.setJoinMessage("");
        new PlayerManager(main).handle(p);

        if (Bukkit.getOnlinePlayers().size() >= 3) {
            new PreGameTimer(main).startCountdown();
        } else if (main.getGameStates() == GameStates.PREGAME) {
            return;
        }
    }
}