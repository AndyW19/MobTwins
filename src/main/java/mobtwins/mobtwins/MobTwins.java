package mobtwins.mobtwins;

import mobtwins.mobtwins.util.Metrics;
import org.bukkit.plugin.java.JavaPlugin;

public final class MobTwins extends JavaPlugin {

    private static Settings settings;
    public static Settings getSettings() {
        return settings;
    }


    @Override
    public void onLoad() {
        // Set instance for easy cross-class referencing
        settings = new Settings(this);
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        registerConfig();
        getServer().getPluginManager().registerEvents(new BreedListener(this), this);
        // Bstats register
        Metrics metrics = new Metrics(this, 12223);
        this.getCommand("mobtwinsreload").setExecutor(new ReloadCommand(this));
        System.out.println("MobTwins Loaded");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("MobTwins Unloaded");
    }

    private void registerConfig() {
        saveDefaultConfig();
        getConfig().options().copyDefaults(true);
        saveConfig();
        settings.reload();
    }
}
