package org.cain.cmdbin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.cain.cmdbin.CommandBin;
import org.cain.cmdbin.utilities.Chat;

public class TpallCommand
  implements CommandExecutor
{
  public boolean onCommand(CommandSender s, Command c, String l, String[] args)
  {
    if (l.equalsIgnoreCase("tpall")) {
      if (!(s instanceof Player)) return false;
      if (!CommandBin.permissionCheck((Player)s, "CommandBin.tpall")) {
        Chat.noPermissionMessage((Player)s);
        return true;
      }
      for (Player p : Bukkit.getServer().getOnlinePlayers()) {
        p.teleport(((Player)s).getLocation());
      }
      Chat.pMessage((Player)s, "Successfully teleported all online players to you!");
    }
    return true;
  }
}