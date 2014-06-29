package me.haxx.BackEnd;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
public class PlayerJoinLeave implements Listener {
	
	public void FirstJoin(Player p, Event e) {
		if (!p.hasPlayedBefore()) {
			ItemStack[] items = { new ItemStack(Material.IRON_SWORD),
					new ItemStack(Material.IRON_PICKAXE),
					new ItemStack(Material.IRON_SPADE),
					new ItemStack(Material.COOKED_BEEF, 10),
					new ItemStack(Material.WOOD, 20) };
			p.getInventory().addItem(items);
			
			p.getInventory().setHelmet(new ItemStack(Material.IRON_HELMET));
			p.getInventory().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
			p.getInventory().setLeggings(new ItemStack(Material.IRON_LEGGINGS));
			p.getInventory().setBoots(new ItemStack(Material.IRON_BOOTS));
			
			long l = System.currentTimeMillis();
			if(System.currentTimeMillis()-l>=1000)
            {
                p.sendMessage("§3Testing");
            }
			if(System.currentTimeMillis()-l>=1000)
            {
                p.sendMessage("§3Testing2");
            }
		}
	}
	
	@EventHandler
	public void PlayerJoin(PlayerJoinEvent e) {
		FirstJoin(e.getPlayer(), e);
	}
	
	@EventHandler
	public void PlayerLeave(PlayerQuitEvent e) {

	}
}
