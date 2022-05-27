package me.kewlkidchristian.hidentag.Commands;

import me.kewlkidchristian.hidentag.HideNTag;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.title.Title;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Server;
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
        if (args.length >= 1) {
            if (args[0].equalsIgnoreCase("start")) {
                Player[] onlinePlayers = Bukkit.getOnlinePlayers().toArray(new Player[0]);
                double randomDouble = Math.floor(Math.random() * onlinePlayers.length);
                int randomInt = (int) randomDouble;
                Player seeker = onlinePlayers[randomInt];

                final Component youAreTheText = Component.text("You are the"); // TODO: Make text use messages.toml
                final Component seekerText = Component.text("SEEKER!", NamedTextColor.RED, TextDecoration.BOLD);
                final Component hiderText = Component.text("HIDER!", NamedTextColor.RED, TextDecoration.BOLD);

                final Title seekerTitle = Title.title(youAreTheText, seekerText);
                final Title hiderTitle = Title.title(youAreTheText, hiderText);

                for (Player player : onlinePlayers) {
                    if (player == seeker) {
                        player.showTitle(seekerTitle);
                        // TODO: Teleport seeker to seeker spawn
                    } else {
                        player.showTitle(hiderTitle);
                        // TODO: Teleport hider to map spawn
                    }
                }
            }
        } else {
            if (sender instanceof Player player) {
                var miniMessage = MiniMessage.miniMessage();

                Component parsed = miniMessage.deserialize(plugin.messages.getString("help"));

                player.sendMessage(parsed);
            }
        }

        return true;
    }
}
