package org.cain.cmdbin.commands;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.cain.cmdbin.CommandBin;
import org.cain.cmdbin.utilities.Chat;

public class TpWorldCommand
  implements CommandExecutor
{
  public boolean onCommand(CommandSender s, Command c, String l, String[] args)
  {
    if (l.equalsIgnoreCase("tpworld")) {
      if (args.length < 1) return false;
      if (!(s instanceof Player)) return false;
      World w = Bukkit.getServer().getWorld(args[0]);
      if (!CommandBin.permissionCheck((Player)s, "CommandBin.tpworld")) {
        Chat.noPermissionMessage((Player)s);
        return true;
      }
      if (w != null) {
        ((Player)s).teleport(w.getSpawnLocation());
        Chat.pMessage((Player)s, "Successfully teleported to '" + w.getName() + "'s spawn!");
      }
    }
    return true;
  }
}