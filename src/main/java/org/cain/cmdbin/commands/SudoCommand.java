package org.cain.cmdbin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.cain.cmdbin.CommandBin;
import org.cain.cmdbin.utilities.Chat;

public class SudoCommand
  implements CommandExecutor
{
  public boolean onCommand(CommandSender s, Command c, String l, String[] args)
  {
    if (l.equalsIgnoreCase("sudo")) {
      if (args.length < 1) return false;
      if (!(s instanceof Player)) return false;
      if (!CommandBin.permissionCheck((Player)s, "CommandBin.sudo")) {
        Chat.noPermissionMessage((Player)s);
        return true;
      }
      StringBuilder x = new StringBuilder();

      for (int i = 0; i < args.length; i++) {
        x.append(args[i] + " ");
      }
      Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), x.toString().trim());
      Chat.pMessage((Player)s, "Sudo message sent to console.");
      Chat.pMessage((Player)s, "Command Entered: '" + x.toString().trim() + "'");
    }
    return true;
  }
}