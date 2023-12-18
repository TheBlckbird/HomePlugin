package dev.theblckbird.sethome;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class HomeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "You must be a player to use this command!");
            return true;
        }

        if (args.length > 0) {
            sender.sendMessage("Too many arguments!");
            return true;
        }

        Player player = (Player) sender;
        FileConfiguration config = Main.getPlugin(Main.class).getConfig();

        if (!config.contains(player.getName())) {
            sender.sendMessage(ChatColor.RED + "You didn’t set your home!\nYou can set it with /sethome");
            return true;
        }

        player.teleport(config.getLocation(player.getName()));

        return true;
    }
}
