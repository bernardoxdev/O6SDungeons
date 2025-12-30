package org.dungeon.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.dungeon.O6SDungeon;
import org.dungeon.countdowns.PreGameTimer;
import org.dungeon.managers.ChatManager;

public class CommandStart implements CommandExecutor {

    private final O6SDungeon main;

    public CommandStart(O6SDungeon main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        Player p = (Player) sender;

        if (!p.hasPermission("game.start")) {
            p.sendMessage(new ChatManager(main).permission);
            return true;
        } else if (cmd.getName().equalsIgnoreCase("start")) {
            new PreGameTimer(main).startCountdown();
            p.sendMessage(new ChatManager(main).prefix + "You have started the game.");
            return true;
        }
        return true;
    }

}