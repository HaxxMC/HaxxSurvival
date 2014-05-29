package me.Haxx.HaxxServer;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public class Join implements Listener {

	private static Plugin plugin;

	public static Plugin getPlugin() {
		return plugin;
	}

	public void sendWelcMsg(PlayerJoinEvent e, Player p) {

		if (!p.hasPlayedBefore()) {
			e.setJoinMessage("§c§l" + p.getName()
					+ " §7is new to the server! Say Hi!");
			p.sendMessage("§7Welcome to the §oHaxx Survival Server!");
		} else {
			e.setJoinMessage("§6[§a+§6] §r" + p.getName());
		}
	}

	public void giveStarterKit(Player p) {
		if (!p.hasPlayedBefore()) {
			ItemStack[] items = { new ItemStack(Material.IRON_SWORD),
					new ItemStack(Material.IRON_PICKAXE),
					new ItemStack(Material.IRON_SPADE),
					new ItemStack(Material.COOKED_BEEF, 10),
					new ItemStack(Material.WOOD, 20) };
			p.getInventory().addItem(items);
			ItemStack[] armor = { new ItemStack(Material.IRON_HELMET),
					new ItemStack(Material.IRON_CHESTPLATE),
					new ItemStack(Material.IRON_LEGGINGS),
					new ItemStack(Material.IRON_BOOTS) };
			p.getInventory().setArmorContents(armor);
		}
	}

	@EventHandler
	public void sendWelcome(PlayerJoinEvent e) {
		sendWelcMsg(e, e.getPlayer());
		giveStarterKit(e.getPlayer());
	}
}
