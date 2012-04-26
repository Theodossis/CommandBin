package org.cain.cmdbin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.cain.cmdbin.CommandBin;
import org.cain.cmdbin.utilities.Chat;
import org.cain.cmdbin.utilities.Home;

public class MsethomeCommand
  implements CommandExecutor
{
  public boolean onCommand(CommandSender s, Command c, String l, String[] args)
  {
    if (l.equalsIgnoreCase("msethome")) {
      if (args.length < 1) return false;
      if (!(s instanceof Player)) return false;
      if (!CommandBin.permissionCheck((Player)s, "CommandBin.msethome")) {
        Chat.noPermissionMessage((Player)s);
        return true;
      }
      Home.saveMultihomeLocation((Player)s, args[0]);
      Chat.pMessage((Player)s, "Home has been saved as '" + args[0] + "'");
      Chat.pMessage((Player)s, "Use /mhome " + args[0] + " to teleport to it");
    }
    return true;
  }
}