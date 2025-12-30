package org.dungeon.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.dungeon.GameStates;
import org.dungeon.O6SDungeon;
import org.dungeon.managers.ChatManager;

public class Build implements Listener {

    private final O6SDungeon main;

    public Build(O6SDungeon main) {
        this.main = main;
    }

    @EventHandler
    public void onBreak(BlockBreakEvent event) {
        Player p = event.getPlayer();
        if (main.getGameStates() == GameStates.LOBBY || main.getGameStates() == GameStates.PREGAME) {
            event.setCancelled(true);
            p.sendMessage(new ChatManager(main).prefix + "You cannot build before the game!");
        }
    }

    @EventHandler
    public void onPlace(BlockPlaceEvent event) {
        Player p = event.getPlayer();
        if (main.getGameStates() == GameStates.LOBBY || main.getGameStates() == GameStates.PREGAME) {
            event.setCancelled(true);
            p.sendMessage(new ChatManager(main).prefix + "You cannot build before the game!");
        }
    }

}