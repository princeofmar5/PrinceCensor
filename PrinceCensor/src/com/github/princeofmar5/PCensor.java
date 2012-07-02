package com.github.princeofmar5;

import org.bukkit.plugin.java.JavaPlugin;

public class PCensor extends JavaPlugin
{
	private PCensorCommandExecutor myExecutor;
	
	public void onEnable()
	{
		getLogger().info("PrinceCensor enabled!");
		myExecutor = new PCensorCommandExecutor(this);
		getCommand("testchat").setExecutor(myExecutor);
		new PCensorLoginListener(this);
	}
	
	public void onDisable()
	{
		getLogger().info("PrinceCensor disabled!");
	}
	
	
}
