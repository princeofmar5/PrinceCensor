package com.github.princeofmar5;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class PrinceCensor extends JavaPlugin
{
	private PrinceCensorCommandExecutor myExecutor;
	
	public void onEnable()
	{
		getConfig();
		getLogger().info("PrinceCensor enabled!");
		myExecutor = new PrinceCensorCommandExecutor(this);
		getCommand("pcensor").setExecutor(myExecutor);
		getCommand("pcreload").setExecutor(myExecutor);
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new PrinceCensorChatListener(this), this);
	}
	
	public void onDisable()
	{
		getLogger().info("PrinceCensor disabled!");
	}
	
	
}
