package org.cain.cmdbin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.cain.cmdbin.CommandBin;
import org.cain.cmdbin.utilities.Chat;
import org.cain.cmdbin.utilities.Warp;

public class WarpCommand
  implements CommandExecutor
{
  public boolean onCommand(CommandSender s, Command c, String l, String[] args)
  {
    if (l.equalsIgnoreCase("warp")) {
      if (args.length < 1) return false;
      if (!(s instanceof Player)) return false;
      if (!CommandBin.permissionCheck((Player)s, "CommandBin.warp")) {
        Chat.noPermissionMessage((Player)s);
        return true;
      }
      if (CommandBin.plugin.getConfig().get("warps." + args[0]) != null) {
        ((Player)s).teleport(Warp.teleportToWarp((Player)s, args[0]));
        Chat.pMessage((Player)s, "Teleported to warp '" + args[0] + "'");
      } else {
        Chat.pMessage((Player)s, "This warp does not exist.");
      }
    }
    return true;
  }
}