package org.cain.cmdbin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.cain.cmdbin.CommandBin;
import org.cain.cmdbin.utilities.Chat;

public class BoldCommand
  implements CommandExecutor
{
  public boolean onCommand(CommandSender s, Command c, String l, String[] args)
  {
    if (l.equalsIgnoreCase("bold")) {
      if (args.length < 1) return false;
      if (!(s instanceof Player)) {
    	  Chat.consoleMessage("Use /broadcast &lYour message to write in bold.");
    	  return true;
      }
      if (!CommandBin.permissionCheck((Player)s, "CommandBin.bold")) {
        Chat.noPermissionMessage((Player)s);
        return true;
      }
      StringBuilder message = new StringBuilder();
      for (int x = 0; x < args.length; x++) {
        message.append(args[x] + " ");
      }

      Chat.sendBoldMessage((Player)s, message.toString().trim());
    }
    return true;
  }
}