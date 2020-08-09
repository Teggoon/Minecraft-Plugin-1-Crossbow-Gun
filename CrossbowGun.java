package me.Daniel.CrossbowGunPlugin;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.ProjectileHitEvent;

/**
 * Main class extending from JavaPlugin that connects all the functionalities together
 * @author Daniel / Haocheng Li
 * @since 2020-8-8
 * */
public class CrossbowGun extends JavaPlugin implements Listener {

	@Override
	public void onEnable() {
		// runs on startups, reloads, plugin reloads

		new RemoveBullet(this);
		new FireBullet(this);
		new HelloCommand(this);
		
	}
}
