package org.cain.cmdbin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.cain.cmdbin.CommandBin;
import org.cain.cmdbin.utilities.Chat;

public class DisableHardcoreCommand
  implements CommandExecutor
{
  public boolean onCommand(CommandSender s, Command c, String l, String[] args)
  {
    if (l.equalsIgnoreCase("disablehardcore")) {
      if (!(s instanceof Player)) {
    	  EnableHardcoreCommand.HardcoreMode = false;
    	  Chat.broadcastMessage("Hardcore Mode has been disabled by Console");
    	  return true;
      }
      if (!CommandBin.permissionCheck((Player)s, "CommandBin.disablehardcore")) {
        Chat.noPermissionMessage((Player)s);
        return true;
      }
      EnableHardcoreCommand.HardcoreMode = false;
      Chat.broadcastMessage("Hardcore Mode has been disabled by " + ((Player)s).getName());
    }
    return true;
  }
}