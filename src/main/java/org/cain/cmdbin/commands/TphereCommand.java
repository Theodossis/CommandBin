package org.cain.cmdbin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.cain.cmdbin.CommandBin;
import org.cain.cmdbin.utilities.Chat;

public class TphereCommand
  implements CommandExecutor
{
  public boolean onCommand(CommandSender s, Command c, String l, String[] args)
  {
    if (l.equalsIgnoreCase("tphere")) {
      if (args.length < 1) return false;
      Player target = Bukkit.getServer().getPlayer(args[0]);
      if (target != null) {
        if (!CommandBin.permissionCheck((Player)s, "CommandBin.tphere")) {
          Chat.noPermissionMessage((Player)s);
          return true;
        }
        target.teleport(((Player)s).getLocation());
        Chat.pMessage((Player)s, "Successfully teleported " + target.getName() + " to you!");
      }
    }
    return true;
  }
}