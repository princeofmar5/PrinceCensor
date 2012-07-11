package com.github.princeofmar5;

import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;
 
public class PCensorLoginListener implements Listener 
{
    public PCensorLoginListener(PCensor plugin) 
    {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
 
    @EventHandler
    public void normalLogin(PlayerLoginEvent event) 
    {
    	event.disallow(Result.KICK_OTHER, "You are not welcome");
    }
}