package mobtwins.mobtwins;

import org.bukkit.configuration.file.FileConfiguration;

public class Settings {

    private final MobTwins plugin;

    private boolean isSheep;
    private boolean isCow;
    private boolean isPig;
    private boolean isRabbit;
    private boolean isPanda;

    private double sheepChance;
    private double cowChance;
    private double pigChance;
    private double rabbitChance;
    private double pandaChance;

    public Settings(MobTwins mobTwins) {
        this.plugin = mobTwins;
    }

    public void reload() {
        plugin.reloadConfig();
        reloadFromFile(plugin.getConfig());
    }

    public void reloadFromFile(FileConfiguration config) {
        try {
            this.isSheep = config.getBoolean("sheep.enabled", true);
            this.sheepChance = config.getDouble("sheep.chance", 0.1);
            this.isCow = config.getBoolean("cow.enabled", true);
            this.cowChance = config.getDouble("cow.chance", 0.1);
            this.isPig = config.getBoolean("pig.enabled", true);
            this.pigChance = config.getDouble("pig.chance", 0.1);
            this.isRabbit = config.getBoolean("rabbit.enabled", true);
            this.rabbitChance = config.getDouble("rabbit.chance", 0.4);
            this.isPanda = config.getBoolean("panda.enabled", true);
            this.pandaChance = config.getDouble("panda.chance", 0.1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isSheep() {
        return isSheep;
    }

    public boolean isCow() {
        return isCow;
    }

    public double getCowChance() {
        return cowChance;
    }

    public double getSheepChance() {
        return sheepChance;
    }

    public boolean isPig() {
        return isPig;
    }

    public boolean isRabbit() {
        return isRabbit;
    }

    public boolean isPanda() {
        return isPanda;
    }

    public double getPigChance() {
        return pigChance;
    }

    public double getRabbitChance() {
        return rabbitChance;
    }

    public double getPandaChance() {
        return pandaChance;
    }

}
