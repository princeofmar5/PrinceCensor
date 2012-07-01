package com.github.princeofmar5;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PCensorCommandExecutor implements CommandExecutor 
{
	@SuppressWarnings("unused")
	private PCensor plugin;
	
	public PCensorCommandExecutor(PCensor plugin) 
	{
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) 
	{
		Player player = null;
		if (sender instanceof Player) 
		{
			player = (Player) sender;
		}
		
		if (cmd.getName().equalsIgnoreCase("testchat"))
		{
			if (player == null)
			{
				sender.sendMessage("This command can only be run by a pleyer.");
			} else if (args.length > 0)
			{
				sender.sendMessage(ChatColor.RED + "Too many arguments!");
				return false;
			} else
			{
				player.chat("TACO!");
			}
			return true;
		}
		return false;
	}
	
}
