package me.kewlkidchristian.hidentag.Commands;

import me.kewlkidchristian.hidentag.HideNTag;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class MainCommand implements CommandExecutor {

    private final HideNTag plugin;

    public MainCommand(HideNTag plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args[0].equalsIgnoreCase("start")) {
            Player[] onlinePlayers = Bukkit.getOnlinePlayers().toArray(new Player[0]);
            double randomDouble = Math.floor(Math.random()*onlinePlayers.length);
            int randomInt = (int)randomDouble;
            Player seeker = onlinePlayers[randomInt];

            for (Player player : onlinePlayers) {
                if (player == seeker) {
                    player.sendMessage("You are the seeker!");
                } else {
                    player.sendMessage("You are a hider!");
                }
            }
        } else {
            if (sender instanceof Player player) {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "geowilzu stinks &b&lreally badly."));
            }
        }

        return true;
    }
}
