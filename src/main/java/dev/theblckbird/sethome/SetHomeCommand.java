package dev.theblckbird.sethome;

import java.io.IOException;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class SetHomeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "You must be a player to use this command!");
            return true;
        }

        if (args.length > 0) {
            sender.sendMessage(ChatColor.RED + "Too many arguments!");
            return true;
        }

        FileConfiguration config = Main.getPlugin(Main.class).getConfig();
        config.set(((Player) sender).getName(), ((Player) sender).getLocation());

        try {
            config.save("homes.yml");
        } catch (IOException e) {
            e.printStackTrace();
            sender.sendMessage(
                    ChatColor.RED + "Whoops, something failed! Please contact the server administrator. Thanks!");
            return true;
        }

        sender.sendMessage("Your home has been set!");

        return true;
    }
}
