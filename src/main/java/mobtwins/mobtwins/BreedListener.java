package mobtwins.mobtwins;

import org.bukkit.Location;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityBreedEvent;

public class BreedListener implements Listener {

    private final MobTwins plugin;

    public BreedListener(MobTwins mobTwins) {
        this.plugin = mobTwins;
    }

    private final boolean isSheep = MobTwins.getSettings().isSheep();
    private final double sheepChance = MobTwins.getSettings().getSheepChance();

    private final boolean isCow = MobTwins.getSettings().isCow();
    private final double cowChance = MobTwins.getSettings().getCowChance();

    private final boolean isPig = MobTwins.getSettings().isPig();
    private final double pigChance = MobTwins.getSettings().getPigChance();

    private final boolean isRabbit = MobTwins.getSettings().isRabbit();
    private final double rabbitChance = MobTwins.getSettings().getRabbitChance();

    private final boolean isPanda = MobTwins.getSettings().isPanda();
    private final double pandaChance = MobTwins.getSettings().getPandaChance();

    private final boolean isDog = MobTwins.getSettings().isDog();
    private final double dogChance = MobTwins.getSettings().getDogChance();

    private final boolean isCat = MobTwins.getSettings().isCat();
    private final double catChance = MobTwins.getSettings().getCatChance();

    private final boolean isHorse = MobTwins.getSettings().isHorse();
    private final double horseChance = MobTwins.getSettings().getHorseChance();

    private final boolean isLlama = MobTwins.getSettings().isLlama();
    private final double llamaChance = MobTwins.getSettings().getLlamaChance();

    private final boolean isFox = MobTwins.getSettings().isFox();
    private final double foxChance = MobTwins.getSettings().getFoxChance();

    @EventHandler
    public void onBreed(EntityBreedEvent event) {
        Location loc = event.getMother().getLocation();

        switch (event.getMother().getType()) {
            case SHEEP:
                if (isSheep && chance(sheepChance)) {
                    Sheep baby = (Sheep) event.getEntity();
                    Sheep sheep = (Sheep) event.getEntity().getWorld().spawnEntity(loc, EntityType.SHEEP);
                    sheep.setBaby();
                    sheep.setColor(baby.getColor());
                }
                break;
            case COW:
                if (isCow && chance(cowChance)) {
                    Cow cow = (Cow) event.getEntity().getWorld().spawnEntity(loc, EntityType.COW);
                    cow.setBaby();
                }
                break;
            case PIG:
                if (isPig && chance(pigChance)) {
                    Pig pig = (Pig) event.getEntity().getWorld().spawnEntity(loc, EntityType.PIG);
                    pig.setBaby();
                }
                break;
            case RABBIT:
                if (isRabbit && chance(rabbitChance)) {
                    Rabbit rabbit = (Rabbit) event.getEntity().getWorld().spawnEntity(loc, EntityType.RABBIT);
                    rabbit.setBaby();
                }
                break;
            case PANDA:
                if (isPanda && chance(pandaChance)) {
                    Panda panda = (Panda) event.getEntity().getWorld().spawnEntity(loc, EntityType.PANDA);
                    panda.setBaby();
                }
                break;
            case WOLF:
                if (isDog && chance(dogChance)) {
                    Wolf baby = (Wolf) event.getEntity();
                    Wolf wolf = (Wolf) event.getEntity().getWorld().spawnEntity(loc, EntityType.WOLF);
                    wolf.setBaby();
                    wolf.setCollarColor(baby.getCollarColor());
                }
                break;
            case CAT:
                if (isCat && chance(catChance)) {
                    Cat baby = (Cat) event.getEntity();
                    Cat cat = (Cat) event.getEntity().getWorld().spawnEntity(loc, EntityType.CAT);
                    cat.setBaby();
                    cat.setCatType(baby.getCatType());
                    cat.setCollarColor(baby.getCollarColor());
                }
                break;
            case HORSE:
                if (isHorse && chance(horseChance)) {
                    Horse baby = (Horse) event.getEntity();
                    Horse horse = (Horse) event.getEntity().getWorld().spawnEntity(loc, EntityType.HORSE);
                    horse.setBaby();
                    horse.setColor(baby.getColor());
                }
                break;
            case LLAMA:
                if (isLlama && chance(llamaChance)) {
                    Llama baby = (Llama) event.getEntity();
                    Llama llama = (Llama) event.getEntity().getWorld().spawnEntity(loc, EntityType.LLAMA);
                    llama.setBaby();
                    llama.setColor(baby.getColor());
                }
                break;
            case FOX:
                if (isFox && chance(foxChance)) {
                    Fox baby = (Fox) event.getEntity();
                    Fox fox = (Fox) event.getEntity().getWorld().spawnEntity(loc, EntityType.FOX);
                    fox.setBaby();
                    fox.setFoxType(baby.getFoxType());
                }
                break;
        }

    }

    private boolean chance(double mobChance) {
        double d = Math.random();
        return d < mobChance;
    }
}
