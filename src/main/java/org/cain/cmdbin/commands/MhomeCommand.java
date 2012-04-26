package org.cain.cmdbin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.cain.cmdbin.CommandBin;
import org.cain.cmdbin.utilities.Chat;
import org.cain.cmdbin.utilities.Home;

public class MhomeCommand
  implements CommandExecutor
{
  public boolean onCommand(CommandSender s, Command c, String l, String[] args)
  {
    if (l.equalsIgnoreCase("mhome")) {
      if (args.length < 1) return false;
      if (!(s instanceof Player)) return false;
      if (!CommandBin.permissionCheck((Player)s, "CommandBin.mhome")) {
        Chat.noPermissionMessage((Player)s);
        return true;
      }
      if (CommandBin.plugin.getConfig().get(((Player)s).getName()) + ".multihome." + args[0] + ".enabled" != null) {
        ((Player)s).teleport(Home.teleportMultihome((Player)s, args[0]));
        Chat.pMessage((Player)s, "Teleported to your home '" + args[0] + "'");
      } else {
        Chat.pMessage((Player)s, "This home '" + args[0] + "' does not exist.");
      }
    }
    return true;
  }
}