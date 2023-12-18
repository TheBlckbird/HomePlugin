package dev.theblckbird.sethome;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        this.getCommand("sethome").setExecutor(new SetHomeCommand());
        this.getCommand("home").setExecutor(new HomeCommand());
    }
}
