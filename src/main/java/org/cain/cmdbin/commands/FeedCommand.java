package org.cain.cmdbin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.cain.cmdbin.CommandBin;
import org.cain.cmdbin.utilities.Chat;
import org.cain.cmdbin.utilities.Feed;

public class FeedCommand
  implements CommandExecutor
{
  public boolean onCommand(CommandSender s, Command c, String l, String[] args)
  {
    if (l.equalsIgnoreCase("feed")) {
    	if(!(s instanceof Player)) {
    		if(args.length < 1) {
    			Chat.consoleMessage("You cannot feed yourself. To feed someone, type /feed <player>");
    			return true;
    		}
    		
    		Player target = Bukkit.getServer().getPlayer(args[0]);
    		if(target != null) {
    			Feed.feedPlayer(target);
    			Chat.consoleMessage("You fed " + target.getName());
    			return true;
    		} else {
    			Chat.consoleMessage("That player is offline.");
    		}
    		return true;
    	}
    	
    	if(args.length < 1) {
    		if(CommandBin.permissionCheck((Player) s, "CommandBin.feed")) {
    			Feed.feedPlayer((Player) s);
    			Chat.pMessage((Player) s, "You fed yourself! Omnom");
    		}
    	} else {
    		if(CommandBin.permissionCheck((Player) s, "CommandBin.feed.others")) {
    			Player target = Bukkit.getServer().getPlayer(args[0]);
    			if(target != null) {
    				Feed.feedPlayer(target);
    				Chat.pMessage((Player) s, "You fed " + target.getName());
    			}
    		}
    	}
    }
    
    return true;
	}
}