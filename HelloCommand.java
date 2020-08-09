package me.Daniel.CrossbowGunPlugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Class that is used for basic debugging purposes.
 * @author Daniel / Haocheng Li
 * @since 2020-8-8
 * */
public class HelloCommand implements CommandExecutor {

	private static CrossbowGun plugin;
	
	/*
	 * Constructor for the class 
	 * */
	public HelloCommand(CrossbowGun plugin) {
		this.plugin = plugin;
		plugin.getCommand("hello").setExecutor(this);
	}
	
	/*
	 * Method that handles commands from the player
	 * @param object that sent the command
	 * @param the Command object itself
	 * @param the name of the command
	 * @param arguments in the command
	 * @return boolean value
	 * */
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		// check if command is hello
		if (label.equalsIgnoreCase("hello")) {
			// check if command came from player, not console
			if (sender instanceof Player) {
				//
				Player p = (Player) sender;
				p.sendMessage("Hello there!");
				
				return true;
			} 
		}
		
		return false;
	}
}
