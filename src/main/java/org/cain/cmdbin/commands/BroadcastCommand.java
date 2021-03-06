package org.cain.cmdbin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.cain.cmdbin.CommandBin;
import org.cain.cmdbin.utilities.Chat;

public class BroadcastCommand
  implements CommandExecutor
{
  public boolean onCommand(CommandSender s, Command c, String l, String[] args)
  {
    if (l.equalsIgnoreCase("broadcast")) {
      if (args.length < 1) return false;
      StringBuilder x = new StringBuilder();
      for (int i = 0; i < args.length; i++) {
        x.append(args[i] + " ");
      }
      if (!(s instanceof Player)) {
        Chat.broadcastMessage(x.toString().trim());
        return true;
      }
      if (!CommandBin.permissionCheck((Player)s, "CommandBin.broadcast")) {
        Chat.noPermissionMessage((Player)s);
        return true;
      }

      String colorSupportedMessage = x.toString().trim().replace("&", "�");
      Chat.broadcastMessage(colorSupportedMessage);
    }
    return true;
  }
}