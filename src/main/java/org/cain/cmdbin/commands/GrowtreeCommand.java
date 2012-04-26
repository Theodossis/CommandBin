package org.cain.cmdbin.commands;

import org.bukkit.TreeType;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.cain.cmdbin.CommandBin;
import org.cain.cmdbin.utilities.Chat;

public class GrowtreeCommand
  implements CommandExecutor
{
  public boolean onCommand(CommandSender s, Command c, String l, String[] args)
  {
    if (l.equalsIgnoreCase("growtree")) {
      if (!(s instanceof Player)) return false;
      if (!CommandBin.permissionCheck((Player)s, "CommandBin.growtree")) {
        Chat.noPermissionMessage((Player)s);
        return true;
      }
      ((Player)s).getWorld().generateTree(((Player)s).getLocation(), TreeType.JUNGLE);
      Chat.pMessage((Player)s, "You grew a jungle tree where you are!");
    }
    return true;
  }
}