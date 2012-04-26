package org.cain.cmdbin.commands;

import java.util.HashMap;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.cain.cmdbin.CommandBin;
import org.cain.cmdbin.utilities.Chat;
import org.cain.cmdbin.utilities.ExplosionBow;

public class ExplosionBowCommand
  implements CommandExecutor
{
  static HashMap<String, Boolean> playerList = new HashMap<String, Boolean>();

  public boolean onCommand(CommandSender s, Command c, String l, String[] args) {
    if (l.equalsIgnoreCase("explosionbow")) {
      if (!(s instanceof Player)) {
    	  Chat.consoleMessage("You cannot enable/disable the explosionbow in console.");
    	  return true;
      }
      if (!CommandBin.permissionCheck((Player)s, "CommandBin.explosionbow")) {
        Chat.noPermissionMessage((Player)s);
        return true;
      }
      if (playerList.containsKey(((Player)s).getName())) {
        playerList.remove(((Player)s).getName());
        Chat.pMessage((Player)s, "Explosion bow disabled.");
        ExplosionBow.removeExplosionBowFromPlayer((Player)s);
      } else {
        playerList.put(((Player)s).getName(), Boolean.valueOf(true));
        Chat.pMessage((Player)s, "Explosion bow enabled.");
        ExplosionBow.addExplosionBowToPlayer((Player)s);
      }
    }
    return true;
  }
}