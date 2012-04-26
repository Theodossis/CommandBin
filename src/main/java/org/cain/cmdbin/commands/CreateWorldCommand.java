package org.cain.cmdbin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.cain.cmdbin.CommandBin;
import org.cain.cmdbin.utilities.Chat;
import org.cain.cmdbin.utilities.WorldUtil;

public class CreateWorldCommand
  implements CommandExecutor
{
  public boolean onCommand(CommandSender s, Command c, String l, String[] args)
  {
    if (l.equalsIgnoreCase("createworld")) {
      if (args.length < 1) return false;
      if (!(s instanceof Player)) {
    	  WorldUtil.createWorld(args[0]);
    	  Chat.consoleMessage("The world '" + args[0] + "' has been created.");
    	  return true;
      }
      if (!CommandBin.permissionCheck((Player)s, "CommandBin.createworld")) {
        Chat.noPermissionMessage((Player)s);
        return true;
      }
      Chat.pMessage((Player)s, "Creating world.. please wait");
      WorldUtil.createWorld(args[0]);
      Chat.pMessage((Player)s, "World created");
    }
    return true;
  }
}