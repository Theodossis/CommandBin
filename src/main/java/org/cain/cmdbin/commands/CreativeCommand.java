package org.cain.cmdbin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.cain.cmdbin.CommandBin;
import org.cain.cmdbin.utilities.Chat;
import org.cain.cmdbin.utilities.Gamemode;

public class CreativeCommand
  implements CommandExecutor
{
  public boolean onCommand(CommandSender s, Command c, String l, String[] args)
  {
    if (l.equalsIgnoreCase("creative")) {
      if (!(s instanceof Player)) {
    	  Chat.consoleMessage("You cannot set your gamemode to creative in console.");
    	  return true;
      }
      if (!CommandBin.permissionCheck((Player)s, "CommandBin.creative")) {
        Chat.noPermissionMessage((Player)s);
        return true;
      }
      Gamemode.setCreative((Player)s);
      Chat.pMessage((Player)s, "Gamemode set to creative");
    }
    return true;
  }
}