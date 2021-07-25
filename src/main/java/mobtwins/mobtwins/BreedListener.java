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
        }

    }

    private boolean chance(double mobChance) {
        double d = Math.random();
        return d < mobChance;
    }
}
