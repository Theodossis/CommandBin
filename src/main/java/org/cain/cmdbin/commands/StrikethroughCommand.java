package org.cain.cmdbin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.cain.cmdbin.CommandBin;
import org.cain.cmdbin.utilities.Chat;

public class StrikethroughCommand
  implements CommandExecutor
{
  public boolean onCommand(CommandSender s, Command c, String l, String[] args)
  {
    if (l.equalsIgnoreCase("strikethrough")) {
      if (args.length < 1) return false;
      if (!(s instanceof Player)) return false;
      if (!CommandBin.permissionCheck((Player)s, "CommandBin.strikethrough")) {
        Chat.noPermissionMessage((Player)s);
        return true;
      }
      StringBuilder message = new StringBuilder();
      for (int x = 0; x < args.length; x++) {
        message.append(args[x] + " ");
      }

      Chat.sendStrikethroughMessage((Player)s, message.toString().trim());
    }
    return true;
  }
}