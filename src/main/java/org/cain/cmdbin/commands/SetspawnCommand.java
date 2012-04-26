package org.cain.cmdbin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.cain.cmdbin.CommandBin;
import org.cain.cmdbin.utilities.Chat;

public class SetspawnCommand
  implements CommandExecutor
{
  public boolean onCommand(CommandSender s, Command c, String l, String[] args)
  {
    if (l.equalsIgnoreCase("setspawn")) {
      if (!(s instanceof Player)) return false;
      if (!CommandBin.permissionCheck((Player)s, "CommandBin.setspawn")) {
        Chat.noPermissionMessage((Player)s);
        return true;
      }
      int x = (int)((Player)s).getLocation().getX();
      int y = (int)((Player)s).getLocation().getY();
      int z = (int)((Player)s).getLocation().getZ();
      ((Player)s).getWorld().setSpawnLocation(x, y, z);
      Chat.pMessage((Player)s, "Spawn set for world '" + ((Player)s).getWorld().getName() + "'");
    }
    return true;
  }
}