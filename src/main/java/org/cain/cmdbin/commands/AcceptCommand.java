package org.cain.cmdbin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.cain.cmdbin.CommandBin;
import org.cain.cmdbin.utilities.Chat;

public class AcceptCommand
  implements CommandExecutor
{
  public boolean onCommand(CommandSender s, Command c, String l, String[] args)
  {
    if (l.equalsIgnoreCase("accept")) {
      if (args.length < 1) return false;
      if (!(s instanceof Player)) {
    	  Chat.consoleMessage("You can't accept teleports in console.");
    	  return true;
      }
      if (!CommandBin.permissionCheck((Player)s, "CommandBin.accept")) {
        Chat.noPermissionMessage((Player)s);
        return true;
      }
      Player target = Bukkit.getServer().getPlayer(args[0]);
      if (target != null) {
        try {
          if (((String)AskCommand.teleportRequest.get(target.getName())).equalsIgnoreCase(((Player)s).getName())) {
            target.teleport(((Player)s).getLocation());
            AskCommand.teleportRequest.remove(target.getName());
            Chat.pMessage((Player)s, "Teleportation accepted. Teleported player to you.");
            Chat.pMessage(target, ((Player)s).getName() + " accepted your request.");
          }
        }
        catch (NullPointerException e) {
          Chat.pMessage((Player)s, "This person did not send you a request.");
        }
      }
    }
    return true;
  }
}