package org.cain.cmdbin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.cain.cmdbin.CommandBin;
import org.cain.cmdbin.utilities.Chat;
import org.cain.cmdbin.utilities.WorldUtil;

public class UnloadWorldCommand
  implements CommandExecutor
{
  public boolean onCommand(CommandSender s, Command c, String l, String[] args)
  {
    if (l.equalsIgnoreCase("unloadworld")) {
      if (args.length < 1) return false;
      if (!(s instanceof Player)) return false;
      if (!CommandBin.permissionCheck((Player)s, "CommandBin.unloadworld")) {
        Chat.noPermissionMessage((Player)s);
        return true;
      }
      if (Bukkit.getServer().getWorld(args[0]) != null) {
        WorldUtil.unloadWorld(args[0]);
        Chat.pMessage((Player)s, "World unloaded");
      } else {
        Chat.pMessage((Player)s, "This world is not loaded");
      }
    }
    return true;
  }
}