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
    	String origMessage = event.getMessage();
    	String message = event.getMessage().toLowerCase();
    	for(String s : words)
    	{
    		String word = s.toLowerCase();
    		String sub = "";
    		int i = 0;
    		while (i < s.length())
    		{
    			sub = sub + "*";
    			i++;
    		}
    		String result = "";
    		int j;
    		int k = 0;
    		do
    		{
    			j = message.indexOf(word, k);
    			k = j + word.length();
    			if (j != -1)
    			{
    				if (j == 0 || message.charAt(j - 1) == ' ')
    				{
    					result = origMessage.substring(0, j);
        				result = result + sub;
        				result = result + origMessage.substring(j + word.length());
        				message = result.toLowerCase();
    					origMessage = result;
    				} else
    				{
    				}
    			}
    		} while(j != -1);
    	}
    	event.setMessage(origMessage);
    }
}