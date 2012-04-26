package org.cain.cmdbin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.cain.cmdbin.CommandBin;
import org.cain.cmdbin.utilities.Chat;

public class NickCommand
  implements CommandExecutor
{
  public boolean onCommand(CommandSender s, Command c, String l, String[] args)
  {
    if (l.equalsIgnoreCase("nick")) {
      if (args.length < 1) return false;
      if (!(s instanceof Player)) return false;
      if (!CommandBin.permissionCheck((Player)s, "CommandBin.nick")) {
        Chat.noPermissionMessage((Player)s);
        return true;
      }
      ((Player)s).setDisplayName(args[0]);
      ((Player)s).setPlayerListName(args[0]);
      Chat.pMessage((Player)s, "Display name set to " + args[0]);
    }
    return true;
  }
}