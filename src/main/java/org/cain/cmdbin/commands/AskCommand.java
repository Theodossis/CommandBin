package org.cain.cmdbin.commands;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.cain.cmdbin.CommandBin;
import org.cain.cmdbin.utilities.Chat;

public class AskCommand
  implements CommandExecutor
{
  public static HashMap<String, String> teleportRequest = new HashMap<String, String>();

  public boolean onCommand(CommandSender s, Command c, String l, String[] args) {
    if (l.equalsIgnoreCase("ask")) {
      if (args.length < 1) return false;
      if (!(s instanceof Player)) {
    	  Chat.consoleMessage("You cannot ask to teleport to someone in console.");
    	  return true;
      }
      if (!CommandBin.permissionCheck((Player)s, "CommandBin.ask")) {
        Chat.noPermissionMessage((Player)s);
        return true;
      }
      Player target = Bukkit.getServer().getPlayer(args[0]);
      if (target != null) {
        Chat.pMessage(target, ((Player)s).getName() + " wants to teleport to you.");
        Chat.pMessage(target, "To accept, type /accept " + ((Player)s).getName());
        Chat.pMessage((Player)s, "Teleportation request sent. Wait for an answer.");
        teleportRequest.put(((Player)s).getName(), target.getName());
      }
    }
    return true;
  }
}