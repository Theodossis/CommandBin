package org.cain.cmdbin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.cain.cmdbin.CommandBin;
import org.cain.cmdbin.utilities.Chat;

public class BoltCommand
  implements CommandExecutor
{
  public boolean onCommand(CommandSender s, Command c, String l, String[] args)
  {
    if (l.equalsIgnoreCase("bolt")) {
      if (!(s instanceof Player)) {
    	  Chat.consoleMessage("You cannot bolt in console.");
    	  return true;
      }
      if (!CommandBin.permissionCheck((Player)s, "CommandBin.bolt")) {
        Chat.noPermissionMessage((Player)s);
        return true;
      }
      ((Player)s).getWorld().strikeLightningEffect(((Player)s).getTargetBlock(null, 0).getLocation());
    }
    return true;
  }
}