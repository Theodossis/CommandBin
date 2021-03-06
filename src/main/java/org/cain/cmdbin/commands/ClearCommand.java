package org.cain.cmdbin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.cain.cmdbin.CommandBin;
import org.cain.cmdbin.utilities.Chat;

public class ClearCommand
  implements CommandExecutor
{
  public boolean onCommand(CommandSender s, Command c, String l, String[] args)
  {
    if (l.equalsIgnoreCase("clear")) {
      if (!(s instanceof Player)) {
    	  Chat.consoleMessage("You cannot clear your inventory in console.");
    	  return true;
      }
      if (!CommandBin.permissionCheck((Player)s, "CommandBin.clear")) {
        Chat.noPermissionMessage((Player)s);
        return true;
      }
      if(args.length < 1) {
      ((Player)s).getInventory().clear();
      Chat.pMessage((Player)s, "Inventory cleared");
      return true;
      } else {
    	  Player target = Bukkit.getServer().getPlayer(args[0]);
    	  if(target != null) {
    		  target.getInventory().clear();
    		  Chat.pMessage((Player) s, target.getName() + "'s inventory cleared");
    		  return true;
    	  }
      }
    }
    return true;
  }
}