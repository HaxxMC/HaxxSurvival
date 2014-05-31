package me.Haxx.HaxxServer;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import ru.tehkode.permissions.bukkit.PermissionsEx;

public class Chat implements Listener {

	@EventHandler
	public void onChat(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		String prefix = PermissionsEx.getUser(p).getPrefix();
		e.setFormat(prefix.replace("&", "§") + " §3" + p.getName() + " §7> §f" + e.getMessage());
	}
	
	@EventHandler
	public void onBukkitCommand(PlayerCommandPreprocessEvent e) {
		if (e.getMessage().startsWith("/bukkit:") || e.getMessage().startsWith("/pl") || e.getMessage().startsWith("/?")) {
			if (!e.getPlayer().isOp()) {
				e.setCancelled(true);
				e.getPlayer()
						.sendMessage(
								"§b[§eHaxx§b] §7Most of our plugins are custom made or modified. If you have a question about a plugin, ask a staff member!");
			}
		}
	}

}
