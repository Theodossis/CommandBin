package org.cain.cmdbin.commands;

import java.util.HashMap;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.cain.cmdbin.CommandBin;
import org.cain.cmdbin.utilities.Chat;
import org.cain.cmdbin.utilities.Vanish;

public class VanishCommand
  implements CommandExecutor
{
  public static HashMap<String, Boolean> vanish = new HashMap<String, Boolean>();

  public boolean onCommand(CommandSender s, Command c, String l, String[] args) {
    if (l.equalsIgnoreCase("vanish")) {
      if (!(s instanceof Player)) return false;
      if (!CommandBin.permissionCheck((Player)s, "CommandBin.vanish")) {
        Chat.noPermissionMessage((Player)s);
        return true;
      }
      if (vanish.get(((Player)s).getName()) == null) {
        Vanish.makePlayerInvisible((Player)s);
        Chat.pMessage((Player)s, "You are now invisible from all players.");
        vanish.put(((Player)s).getName(), Boolean.valueOf(true));
      } else {
        Vanish.makePlayerVisible((Player)s);
        Chat.pMessage((Player)s, "You are now visible to all players.");
        vanish.remove(((Player)s).getName());
      }
    }
    return true;
  }
}