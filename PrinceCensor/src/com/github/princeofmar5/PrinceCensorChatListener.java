package com.github.princeofmar5;

import java.util.List;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerChatEvent;
 
public class PrinceCensorChatListener implements Listener 
{
    PrinceCensor plugin;
	
	public PrinceCensorChatListener(PrinceCensor instance) 
    {
        plugin = instance;
    }
 
    @EventHandler
    public void onPlayerChat(PlayerChatEvent event) 
    {
    	List<String> words = plugin.getConfig().getStringList("words");
    	String[] message = event.getMessage().split(" ");
    	String newMessage = "";
    	for(String s : message)
    	{
    		for(String t : words)
    		{
    			String censor = "";
    			for (int i = 0; i < s.length(); i++)
    			{
    				censor = censor + "*";
    			}
    			if (s.equalsIgnoreCase(t))
    			{
    				s = censor;
    			}
    		}
    		newMessage = newMessage + s + " ";
    	}
    	event.setMessage(newMessage);
    }
}