package me.kewlkidchristian.hidentag;

import me.kewlkidchristian.hidentag.Commands.MainCommand;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public final class HideNTag extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("hidentag").setExecutor(new MainCommand(this));

        getLogger().info("Hide 'N Tag has been enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("Hide 'N Tag has been disabled!");
    }
}
