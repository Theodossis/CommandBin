package org.cain.cmdbin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.cain.cmdbin.CommandBin;
import org.cain.cmdbin.utilities.Chat;

public class TpCommand
  implements CommandExecutor
{
  public boolean onCommand(CommandSender s, Command c, String l, String[] args)
  {
    if (l.equalsIgnoreCase("tp")) {
      if (args.length < 1) return false;
      Player target = Bukkit.getServer().getPlayer(args[0]);

      if (args.length == 1) {
        if (!CommandBin.permissionCheck((Player)s, "CommandBin.tp")) {
          Chat.noPermissionMessage((Player)s);
          return true;
        }
        if (target != null) {
          ((Player)s).teleport(target.getLocation());
          Chat.pMessage((Player)s, "You teleported to " + target.getName());
        }
      }
      else {
        if (!CommandBin.permissionCheck((Player)s, "CommandBin.tp.others")) {
          Chat.noPermissionMessage((Player)s);
          return true;
        }
        Player target2 = Bukkit.getServer().getPlayer(args[1]);
        if ((target != null) && (target2 != null)) {
          target.teleport(target2.getLocation());
          Chat.pMessage((Player)s, "You teleported " + target.getName() + " to " + target2.getName());
        }
      }
    }
    return true;
  }
}