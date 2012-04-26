package org.cain.cmdbin.commands;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.cain.cmdbin.CommandBin;
import org.cain.cmdbin.utilities.Chat;

public class TPcCommand
  implements CommandExecutor
{
  public boolean onCommand(CommandSender s, Command c, String l, String[] args)
  {
    if (l.equalsIgnoreCase("tpc")) {
      if (args.length < 3) return false;
      if (!(s instanceof Player)) return false;
      if (!CommandBin.permissionCheck((Player)s, "CommandBin.tpc")) {
        Chat.noPermissionMessage((Player)s);
        return true;
      }
      try
      {
        int x = Integer.parseInt(args[0]);
        int y = Integer.parseInt(args[1]);
        int z = Integer.parseInt(args[2]);
        ((Player)s).teleport(new Location(((Player)s).getWorld(), x, y, z));
        Chat.pMessage((Player)s, "Teleported to co-ordinates " + x + ", " + y + ", " + z);
      } catch (NumberFormatException e) {
        Chat.pMessage((Player)s, "Invalid format for co-ordinates.");
      }
    }
    return true;
  }
}