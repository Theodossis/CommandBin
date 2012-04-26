package org.cain.cmdbin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.cain.cmdbin.CommandBin;
import org.cain.cmdbin.utilities.Chat;

public class ItalicCommand
  implements CommandExecutor
{
  public boolean onCommand(CommandSender s, Command c, String l, String[] args)
  {
    if (l.equalsIgnoreCase("italic")) {
      if (args.length < 1) return false;
      if (!(s instanceof Player)) return false;
      if (!CommandBin.permissionCheck((Player)s, "CommandBin.italic")) {
        Chat.noPermissionMessage((Player)s);
        return true;
      }
      StringBuilder message = new StringBuilder();
      for (int x = 0; x < args.length; x++) {
        message.append(args[x] + " ");
      }

      Chat.sendItalicMessage((Player)s, message.toString().trim());
    }
    return true;
  }
}