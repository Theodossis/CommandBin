package org.cain.cmdbin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.cain.cmdbin.CommandBin;
import org.cain.cmdbin.utilities.Chat;

public class RamCommand
  implements CommandExecutor
{
  public boolean onCommand(CommandSender s, Command c, String l, String[] args)
  {
    if (l.equalsIgnoreCase("ram")) {
      if (!(s instanceof Player)) return false;
      if (!CommandBin.permissionCheck((Player)s, "CommandBin.ram")) {
        Chat.noPermissionMessage((Player)s);
        return true;
      }
      double freeram = Math.floor(Runtime.getRuntime().freeMemory() / 1024L / 1024L);
      double maxiram = Math.floor(Runtime.getRuntime().maxMemory() / 1024L / 1024L);
      Chat.pMessage((Player)s, "CommandBin - Available Memory");
      Chat.pMessage((Player)s, "Free: " + freeram + "M");
      Chat.pMessage((Player)s, "Max: " + maxiram + "M");
    }
    return true;
  }
}