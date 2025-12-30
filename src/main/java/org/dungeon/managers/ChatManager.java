package org.dungeon.managers;

import org.bukkit.ChatColor;
import org.dungeon.O6SDungeon;

public class ChatManager {

    private final O6SDungeon main;

    public ChatManager(O6SDungeon main) {
        this.main = main;
    }

    public String format(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    public String permission = format("&cYou do not have permission to access this command.");
    public String prefix = format("&8[&bMiniGame&8] &e");
}