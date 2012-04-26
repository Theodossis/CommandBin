package org.cain.cmdbin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.cain.cmdbin.CommandBin;
import org.cain.cmdbin.utilities.Chat;
import org.cain.cmdbin.utilities.Home;

public class HomeCommand
  implements CommandExecutor
{
  public boolean onCommand(CommandSender s, Command c, String l, String[] args)
  {
    if (l.equalsIgnoreCase("home")) {
      if (!(s instanceof Player)) return false;
      if (!CommandBin.permissionCheck((Player)s, "CommandBin.home")) {
        Chat.noPermissionMessage((Player)s);
        return true;
      }
      if (CommandBin.plugin.getConfig().getBoolean(((Player)s).getName() + ".home.enabled")) {
        ((Player)s).teleport(Home.teleportHome((Player)s));
        Chat.pMessage((Player)s, "Teleported to your home");
      } else {
        Chat.pMessage((Player)s, "You have not yet /sethome'd");
      }
    }
    return true;
  }
}