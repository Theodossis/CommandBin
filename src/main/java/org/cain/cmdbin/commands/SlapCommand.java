package org.cain.cmdbin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.cain.cmdbin.CommandBin;
import org.cain.cmdbin.utilities.Chat;
import org.cain.cmdbin.utilities.Slap;

public class SlapCommand
  implements CommandExecutor
{
  public boolean onCommand(CommandSender s, Command c, String l, String[] args)
  {
    if (l.equalsIgnoreCase("slap")) {
      if (args.length < 1) return false;
      if (!CommandBin.permissionCheck((Player)s, "CommandBin.slap")) {
        Chat.noPermissionMessage((Player)s);
        return true;
      }
      if (!(s instanceof Player)) return false;
      Player target = Bukkit.getServer().getPlayer(args[0]);
      if (target != null) {
        Slap.slapPlayer(target);
        Chat.pMessage((Player)s, "Player slapped");
      } else {
        Chat.pMessage((Player)s, "Player is offline");
      }
    }
    return true;
  }
}