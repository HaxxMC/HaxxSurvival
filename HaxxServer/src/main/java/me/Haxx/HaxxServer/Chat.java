package me.Haxx.HaxxServer;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class Chat implements Listener {

	@EventHandler
	public void onChat(AsyncPlayerChatEvent e){
		if (e.getMessage().startsWith("/bukkit:")){
			e.setCancelled(true);
			e.getPlayer().sendMessage("§b[§eHaxx§b] §7Most of our plugins are custom made or modified. If you have a question about a plugin, ask a staff member!");
		}
	}
		
}
