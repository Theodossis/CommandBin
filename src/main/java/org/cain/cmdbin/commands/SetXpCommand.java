package org.cain.cmdbin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.cain.cmdbin.CommandBin;
import org.cain.cmdbin.utilities.Chat;
import org.cain.cmdbin.utilities.XP;

public class SetXpCommand
  implements CommandExecutor
{
  public boolean onCommand(CommandSender s, Command c, String l, String[] args)
  {
    if (l.equalsIgnoreCase("setxp")) {
      if (args.length < 2) return false;
      if (!(s instanceof Player)) return false;
      if (!CommandBin.permissionCheck((Player)s, "CommandBin.setxp")) {
        Chat.noPermissionMessage((Player)s);
        return true;
      }
      Player target = Bukkit.getServer().getPlayer(args[0]);
      if (target != null) {
        try {
          XP.setExperience(target, Integer.parseInt(args[1]));
          Chat.pMessage((Player)s, target.getName() + "'s experience has been set to " + args[1]);
        } catch (NumberFormatException e) {
          Chat.pMessage((Player)s, "You did not enter a valid number.");
        }
      }
    }
    return true;
  }
}