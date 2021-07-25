package mobtwins.mobtwins;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ReloadCommand implements CommandExecutor {

    private final MobTwins plugin;

    public ReloadCommand(MobTwins mobTwins) {
        this.plugin = mobTwins;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player p = (Player) sender;
            MobTwins.getSettings().reload();
            p.sendMessage(ChatColor.GOLD + "MobTwins " + ChatColor.YELLOW + "reloaded");
        }
        return true;
    }
}
