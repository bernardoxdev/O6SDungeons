package org.dungeon.listeners;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.dungeon.GameStates;
import org.dungeon.O6SDungeon;

public class Damage implements Listener {

    private final O6SDungeon main;

    public Damage(O6SDungeon main) {
        this.main = main;
    }

    @EventHandler
    public void onDamage(EntityDamageEvent event) {
        if (event.getEntity().getType() == EntityType.PLAYER) {
            if (main.getGameStates() == GameStates.LOBBY || main.getGameStates() == GameStates.PREGAME) {
                event.setCancelled(true);
            }
        }
    }

}