package me.Haxx.HaxxServer;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class Leave implements Listener {

	@EventHandler
	public void sendWelcome(PlayerQuitEvent e) {
		Player p = e.getPlayer();

		e.setQuitMessage("§6[§c-§6] §r" + p.getName());
	}
}
