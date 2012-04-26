package org.cain.cmdbin.commands;

import java.util.HashSet;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.cain.cmdbin.CommandBin;
import org.cain.cmdbin.utilities.Chat;

public class AfkCommand
  implements CommandExecutor
{
  public static HashSet<String> afkPlayers = new HashSet<String>();

  public boolean onCommand(CommandSender s, Command c, String l, String[] args) {
    if (l.equalsIgnoreCase("afk")) {
      if (!(s instanceof Player)) {
    	  Chat.consoleMessage("You cannot appear AFK in console.");
    	  return true;
      }
      if (!CommandBin.permissionCheck((Player)s, "CommandBin.afk")) {
        Chat.noPermissionMessage((Player)s);
        return true;
      }
      if (args.length == 0) {
        afkPlayers.add(((Player)s).getName());
        Chat.broadcastMessage(ChatColor.BLUE + ((Player)s).getName() + " is now AFK!");
      } else {
        Player target = Bukkit.getServer().getPlayer(args[0]);
        if (target != null) {
          if (afkPlayers.contains(target.getName()))
            Chat.pMessage((Player)s, target.getName() + " is currently AFK!");
          else {
            Chat.pMessage((Player)s, target.getName() + " is not currently AFK!");
          }
        }
      }
    }
    return true;
  }
}