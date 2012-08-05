package com.github.princeofmar5;

import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class PrinceCensorCommandExecutor implements CommandExecutor 
{
	private PrinceCensor plugin;
	
	public PrinceCensorCommandExecutor(PrinceCensor instance) 
	{
		plugin = instance;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) 
	{
		if (cmd.getName().equalsIgnoreCase("pcensor"))
		{
			if (args.length > 2)
			{
				sender.sendMessage(ChatColor.RED + "Too many arguments!");
				return false;
			} else if (args.length < 2)
			{
				sender.sendMessage(ChatColor.RED + "Not enough arguments!");
				return false;
			} else
			{
				if (args[0].equals("add"))
				{
					if (sender.hasPermission("pcensor.add"))
					{
						List<String> words = plugin.getConfig().getStringList("words");
						if(!words.contains(args[1]))
						{
							words.add(args[1]);
							plugin.getConfig().set("words", words);
							plugin.saveConfig();
							sender.sendMessage(ChatColor.GREEN + "Word Added!");
						} else
						{
							sender.sendMessage(ChatColor.RED + "Word is already on the list!");
						}
					} else
					{
						sender.sendMessage(ChatColor.RED + "You don't have permission!");
					}
					return true;
				} else if (args[0].equals("remove"))
				{
					if (sender.hasPermission("pcensor.remove"))
					{
						List<String> words = plugin.getConfig().getStringList("words");
						if (words.contains(args[1]))
						{
							words.remove(args[1]);
							plugin.getConfig().set("words", words);
							plugin.saveConfig();
							sender.sendMessage(ChatColor.GREEN + "Word Removed!");
						} else
						{
							sender.sendMessage(ChatColor.RED + "Word isn't on the list!");
						}
					} else
					{
						sender.sendMessage(ChatColor.RED + "You don't have permission!");
					}
				}
				return true;
			}
		}
		if (cmd.getName().equalsIgnoreCase("pcreload"))
		{
			if (args.length > 0)
			{
				sender.sendMessage(ChatColor.RED + "Too many arguments!");
				return false;
			} else
			{
				plugin.reloadConfig();
				sender.sendMessage(ChatColor.GREEN + "Config Reloaded!");
				return true;
			}
		}
		return false;
	}
	
}
