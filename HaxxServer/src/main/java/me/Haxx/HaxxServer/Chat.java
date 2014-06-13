package me.Haxx.HaxxServer;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import ru.tehkode.permissions.bukkit.PermissionsEx;

public class Chat implements Listener {

	@EventHandler
	public void onBukkitCommand(PlayerCommandPreprocessEvent e) {
		if (e.getMessage().startsWith("/bukkit:")
				|| e.getMessage().equals("/pl")
				|| e.getMessage().startsWith("/plugins")
				|| e.getMessage().startsWith("/?")) {
			if (!e.getPlayer().isOp()) {
				e.setCancelled(true);
				e.getPlayer()
						.sendMessage(
								"�b[�eHaxx�b] �7Most of our plugins are custom made or modified. If you have a question about a plugin, ask a staff member!");
			}
		}
	}

	@EventHandler
	public void onChat(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		String prefix = PermissionsEx.getUser(p).getPrefix();
		String msg = e.getMessage().toLowerCase();
		
		if (msg.contains("staff") || msg.contains("op")) {
			if (msg.contains("apply")
					|| msg.contains("can i have")
					|| msg.contains("i have")) {
				e.setCancelled(true);
				p.sendMessage("�c�lDo not ask for staff on the server. �7�lInstead, read our rules, and then apply on the forum after being a server member for five days.");
			}
		}
		if (p.hasPermission("haxx.color")) {
			e.setFormat(prefix.replace("&", "�") + " �3" + p.getDisplayName()
					+ "�8: �7"
					+ e.getMessage().replace("%", "%%").replace("&", "�"));
		} else {
			e.setFormat(prefix.replace("&", "�") + " �3" + p.getDisplayName()
					+ "�8: �7" + e.getMessage().replace("%", "%%"));
		}
	}

}
