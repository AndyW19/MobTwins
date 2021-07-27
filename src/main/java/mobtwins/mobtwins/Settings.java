package mobtwins.mobtwins;

import org.bukkit.configuration.file.FileConfiguration;

public class Settings {

    private final MobTwins plugin;

    private boolean isSheep;
    private boolean isCow;
    private boolean isPig;
    private boolean isRabbit;
    private boolean isPanda;
    private boolean isDog;
    private boolean isCat;
    private boolean isHorse;
    private boolean isLlama;
    private boolean isFox;

    private double sheepChance;
    private double cowChance;
    private double pigChance;
    private double rabbitChance;
    private double pandaChance;
    private double dogChance;
    private double catChance;
    private double horseChance;
    private double llamaChance;
    private double foxChance;

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
            this.isDog = config.getBoolean("dog.enabled", true);
            this.dogChance = config.getDouble("dog.chance", 0.1);
            this.isCat = config.getBoolean("cat.enabled", true);
            this.catChance = config.getDouble("cat.chance", 0.1);
            this.isHorse = config.getBoolean("horse.enabled", true);
            this.horseChance = config.getDouble("horse.chance", 0.1);
            this.isLlama = config.getBoolean("llama.enabled", true);
            this.llamaChance = config.getDouble("llama.chance", 0.1);
            this.isFox = config.getBoolean("fox.enabled", true);
            this.foxChance = config.getDouble("fox.chance", 0.1);
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

    public boolean isPig() {
        return isPig;
    }

    public boolean isRabbit() {
        return isRabbit;
    }

    public boolean isPanda() {
        return isPanda;
    }

    public boolean isDog() {return isDog;}

    public boolean isCat() { return isCat;}

    public double getCowChance() {
        return cowChance;
    }

    public double getSheepChance() {
        return sheepChance;
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

    public double getCatChance() {
        return catChance;
    }

    public double getDogChance() {
        return dogChance;
    }

    public boolean isHorse() {
        return isHorse;
    }

    public boolean isLlama() {
        return isLlama;
    }

    public boolean isFox() {
        return isFox;
    }

    public double getHorseChance() {
        return horseChance;
    }

    public double getLlamaChance() {
        return llamaChance;
    }

    public double getFoxChance() {
        return foxChance;
    }
}
