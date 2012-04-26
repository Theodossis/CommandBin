package org.cain.cmdbin.commands;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.cain.cmdbin.CommandBin;
import org.cain.cmdbin.utilities.Chat;
import org.cain.cmdbin.utilities.Gamemode;

public class GmCommand
  implements CommandExecutor
{
  public boolean onCommand(CommandSender s, Command c, String l, String[] args)
  {
    if (l.equalsIgnoreCase("gm")) {
      if (!(s instanceof Player)) return false;
      if (!CommandBin.permissionCheck((Player)s, "CommandBin.gm")) {
        Chat.noPermissionMessage((Player)s);
        return true;
      }

      if (args.length < 1) {
        Gamemode.modeCheck((Player)s);
        Chat.pMessage((Player)s, "Game mode switched!");
      } else {
        Player target = Bukkit.getServer().getPlayer(args[0]);
        if (target != null) {
          if (target.getGameMode() == GameMode.CREATIVE) {
            target.setGameMode(GameMode.SURVIVAL);
            Chat.pMessage((Player)s, "Game mode changed to survival");
          } else {
            target.setGameMode(GameMode.CREATIVE);
            Chat.pMessage((Player)s, "Game mode changed to creative");
          }
        }
      }
    }
    return true;
  }
}