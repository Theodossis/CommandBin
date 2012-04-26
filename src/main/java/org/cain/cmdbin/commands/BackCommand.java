package org.cain.cmdbin.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.cain.cmdbin.CommandBin;
import org.cain.cmdbin.listeners.playerListener;
import org.cain.cmdbin.utilities.Chat;

public class BackCommand
  implements CommandExecutor
{
  public boolean onCommand(CommandSender s, Command c, String l, String[] args)
  {
    if (l.equalsIgnoreCase("back")) {
      if (!(s instanceof Player)) {
    	  Chat.consoleMessage("You cannot teleport back to your previous location in console.");
    	  return true;
      }
      if (!CommandBin.permissionCheck((Player)s, "CommandBin.back")) {
        Chat.noPermissionMessage((Player)s);
        return true;
      }
      try
      {
        Double fromX = (Double)playerListener.playerHashX.get(((Player)s).getName());
        Double fromY = (Double)playerListener.playerHashY.get(((Player)s).getName());
        Double fromZ = (Double)playerListener.playerHashZ.get(((Player)s).getName());
        String fromWorld = (String)playerListener.playerHashWorld.get(((Player)s).getName());
        ((Player)s).teleport(new Location(Bukkit.getServer().getWorld(fromWorld), fromX.doubleValue(), fromY.doubleValue(), fromZ.doubleValue()));
        Chat.pMessage((Player)s, "Returned to your previous location!");
      } catch (NullPointerException e) {
        Chat.pMessage((Player)s, "You gotta teleport first to be able to use /back!");
      }
    }
    return true;
  }
}