package me.kewlkidchristian.hidentag;

import com.moandjiezana.toml.Toml;
import me.kewlkidchristian.hidentag.Commands.MainCommand;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public final class HideNTag extends JavaPlugin {

    public static Toml config;
    public static Toml messages;

    @SuppressWarnings("ResultOfMethodCallIgnored")
    private Toml loadConfig(String name) {
        try {
            if(!getDataFolder().exists()) {
                getDataFolder().mkdirs();
            }
            File file = new File(getDataFolder(), name + ".toml");
            if(!file.exists()) {
                Files.copy(getResource("config/" + name + ".toml"), file.toPath());
            }
            return new Toml(new Toml().read(getResource("config/" + name + ".toml"))).read(file);
        } catch (IOException exception) {
            getLogger().severe("Could not load " + name + ".toml file.");
            exception.printStackTrace();
            return null;
        }
    }

    @Override
    public void onEnable() {
        messages = loadConfig("messages");
        config = loadConfig("config");

        getCommand("hidentag").setExecutor(new MainCommand(this));

        getLogger().info("Hide 'N Tag has been enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("Hide 'N Tag has been disabled!");
    }
}
