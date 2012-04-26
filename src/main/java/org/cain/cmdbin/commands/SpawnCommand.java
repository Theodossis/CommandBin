package org.cain.cmdbin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.cain.cmdbin.CommandBin;
import org.cain.cmdbin.utilities.Chat;

public class SpawnCommand
  implements CommandExecutor
{
  public boolean onCommand(CommandSender s, Command c, String l, String[] args)
  {
    if (l.equalsIgnoreCase("spawn")) {
      if (!(s instanceof Player)) return false;
      if (!CommandBin.permissionCheck((Player)s, "CommandBin.spawn")) {
        Chat.noPermissionMessage((Player)s);
        return true;
      }
      ((Player)s).teleport(((Player)s).getWorld().getSpawnLocation());
      Chat.pMessage((Player)s, "Successfully teleported to spawn!");
    }
    return true;
  }
}