package com.github.princeofmar5;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class PCensor extends JavaPlugin
{
	private PCensorCommandExecutor myExecutor;
	
	public void onEnable()
	{
		getConfig();
		getLogger().info("PCensor enabled!");
		myExecutor = new PCensorCommandExecutor(this);
		getCommand("pcensor").setExecutor(myExecutor);
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new PCensorChatListener(this), this);
	}
	
	public void onDisable()
	{
		getLogger().info("PCensor disabled!");
	}
	
	
}
