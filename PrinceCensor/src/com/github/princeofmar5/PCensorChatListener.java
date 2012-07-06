package com.github.princeofmar5;

import java.util.List;

import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerChatEvent;
 
public class PCensorChatListener implements Listener 
{
    PCensor plugin;
	
	public PCensorChatListener(PCensor instance) 
    {
        plugin = instance;
    }
 
    @EventHandler
    public void onPlayerChat(PlayerChatEvent event) 
    {
    	List<String> words = plugin.getConfig().getStringList("words");
    	String message = event.getMessage().toLowerCase();
    	for(String s : words)
    	{
    		String word = s;
    		String sub = "";
    		int i = 0;
    		while (i < s.length())
    		{
    			sub = sub + "*";
    			i++;
    		}
    		String result = "";
    		int j;
    		do
    		{
    			j = message.indexOf(word);
    			if (j != -1)
    			{
    				result = message.substring(0, j);
    				result = result + sub;
    				result = result + message.substring(j + word.length());
    				message = result;
    			}
    		} while(j != -1);
    	}
    	event.setMessage(message);
    }
}