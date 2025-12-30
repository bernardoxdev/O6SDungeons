package org.dungeon.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.dungeon.GameStates;
import org.dungeon.O6SDungeon;

public class Food  implements Listener {

    private final O6SDungeon main;

    public Food(O6SDungeon main) {
        this.main = main;
    }

    @EventHandler
    public void onFoodLevelChange(FoodLevelChangeEvent event) {
        if (main.getGameStates() == GameStates.LOBBY || main.getGameStates() == GameStates.PREGAME) {
            event.setCancelled(true);
        }
    }

}