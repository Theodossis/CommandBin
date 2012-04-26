package org.cain.cmdbin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.cain.cmdbin.CommandBin;
import org.cain.cmdbin.utilities.Chat;
import org.cain.cmdbin.utilities.Home;

public class SetHomeCommand
  implements CommandExecutor
{
  public boolean onCommand(CommandSender s, Command c, String l, String[] args)
  {
    if (l.equalsIgnoreCase("sethome")) {
      if (!(s instanceof Player)) return false;
      if (!CommandBin.permissionCheck((Player)s, "CommandBin.sethome")) {
        Chat.noPermissionMessage((Player)s);
        return true;
      }
      Home.saveHomeLocation((Player)s);
      Chat.pMessage((Player)s, "Home set. Type /home to teleport.");
    }
    return true;
  }
}