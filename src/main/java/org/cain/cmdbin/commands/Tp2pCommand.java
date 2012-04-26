package org.cain.cmdbin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.cain.cmdbin.CommandBin;
import org.cain.cmdbin.utilities.Chat;

public class Tp2pCommand
  implements CommandExecutor
{
  public boolean onCommand(CommandSender s, Command c, String l, String[] args)
  {
    if (l.equalsIgnoreCase("tp2p")) {
      if (args.length < 2) return false;
      if (!(s instanceof Player)) return false;
      if (!CommandBin.permissionCheck((Player)s, "CommandBin.tp2p")) {
        Chat.noPermissionMessage((Player)s);
        return true;
      }
      Player target1 = Bukkit.getServer().getPlayer(args[0]);
      Player target2 = Bukkit.getServer().getPlayer(args[1]);
      if ((target1 != null) && (target2 != null)) {
        target1.teleport(target2.getLocation());
        Chat.pMessage((Player)s, "Teleported player1 to player2");
      } else {
        Chat.pMessage((Player)s, "One of these players are offline");
      }
    }
    return true;
  }
}