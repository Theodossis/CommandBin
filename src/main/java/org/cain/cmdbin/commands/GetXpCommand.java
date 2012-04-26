package org.cain.cmdbin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.cain.cmdbin.CommandBin;
import org.cain.cmdbin.utilities.Chat;
import org.cain.cmdbin.utilities.XP;

public class GetXpCommand
  implements CommandExecutor
{
  public boolean onCommand(CommandSender s, Command c, String l, String[] args)
  {
    if (l.equalsIgnoreCase("getxp")) {
      if (args.length < 1) return false;
      if (!(s instanceof Player)) return false;
      if (!CommandBin.permissionCheck((Player)s, "CommandBin.getxp")) {
        Chat.noPermissionMessage((Player)s);
        return true;
      }
      Player target = Bukkit.getServer().getPlayer(args[0]);
      if (target != null) {
        Chat.pMessage((Player)s, target.getName() + " currently has " + XP.getExperience(target) + " experience points");
      }
    }
    return true;
  }
}