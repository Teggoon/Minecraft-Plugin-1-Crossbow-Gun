package me.Daniel.CrossbowGunPlugin;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;

/**
 * Class that handles the bullet firing of the gun 
 * @author Daniel / Haocheng Li
 * @since 2020-8-8
 * */
public class FireBullet implements Listener {

	// private variable connecting back to the main class
	private static CrossbowGun plugin;
	
	/*
	 * Constructor for the class
	 * @param a CrossbowGun object
	 * */
	public FireBullet(CrossbowGun plugin) {
		this.plugin = plugin;
		Bukkit.getPluginManager().registerEvents(this,plugin);
	}
	
	/*
	 * Method that handles the firing of a bullet upon player's actions
	 * @param the event of a player clicking with his/her mouse
	 * */
	@EventHandler
	public void fireBullet(PlayerInteractEvent event) {

		// Get Player variable
		Player p = (Player) event.getPlayer();
		
		// Get position and vector of direction of player
		Location eyeloc = p.getEyeLocation();
		Vector playerDirection = p.getEyeLocation().getDirection();
		
		// Get world player is in
		World world = p.getWorld();
		
		// if player is holding crossbow
		if (event.getMaterial() == Material.CROSSBOW) {
			// Right click: Assault Rifle
			if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
		
				float speed = 4;
				float spread = 1;
				
				// create bullet
				Arrow bullet = world.spawnArrow(eyeloc, playerDirection, speed, spread);

				// adding sound effect
				world.playSound(eyeloc, Sound.BLOCK_GILDED_BLACKSTONE_BREAK,1,1);
				
				//setting bullet attributes
				bullet.setDamage(10);
				bullet.setShooter(p);
				bullet.setFireTicks(500);
				bullet.setShotFromCrossbow(true);
				
			// Left click: Shotgun
			} else if (event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK) {
				float speed = 2;
				float spread = 14;
				
				// adding sound effect
				world.playSound(eyeloc, Sound.BLOCK_GILDED_BLACKSTONE_BREAK,1,1);
				
				// For loop to create 4 bullets
				for (int i = 0; i < 4; i++) {
					Arrow bullet = world.spawnArrow(eyeloc, playerDirection, speed, spread);
					
					// setting each bullet's attributes
					bullet.setShooter(p);
					bullet.setDamage(5);
					bullet.setFireTicks(500);
					bullet.setShotFromCrossbow(true);
				}
			}
		}
	}
}
