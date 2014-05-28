package me.Haxx.HaxxServer;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Plugins implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if (cmd.getName().equalsIgnoreCase("pl")
				|| cmd.getName().equalsIgnoreCase("plugins")
				|| cmd.getName().equalsIgnoreCase("?")) {
			sender.sendMessage("§7Most plugins on Haxx are Custom Coded or modified. If you have a question about a plugin, ask a staff member!");
		}
		return false;
	}
}
