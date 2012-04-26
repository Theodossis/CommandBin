package org.cain.cmdbin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.cain.cmdbin.CommandBin;
import org.cain.cmdbin.utilities.Chat;
import org.cain.cmdbin.utilities.Mute;

public class UnMuteCommand
  implements CommandExecutor
{
  public boolean onCommand(CommandSender s, Command c, String l, String[] args)
  {
    if (l.equalsIgnoreCase("unmute")) {
      if (args.length < 1) return false;
      if (!(s instanceof Player)) return false;
      if (!CommandBin.permissionCheck((Player)s, "CommandBin.unmute")) {
        Chat.noPermissionMessage((Player)s);
        return true;
      }
      Player target = Bukkit.getServer().getPlayer(args[0]);
      if (target != null) {
        Mute.unmutePlayer(target);
        Chat.pMessage((Player)s, "Unmuted player");
      } else {
        Chat.pMessage((Player)s, "Player is offline");
      }
    }
    return true;
  }
}