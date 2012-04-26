package org.cain.cmdbin.commands;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.cain.cmdbin.CommandBin;
import org.cain.cmdbin.utilities.Chat;

public class GmoCommand
  implements CommandExecutor
{
  static HashMap<String, Boolean> gameMode = new HashMap<String, Boolean>();

  public boolean onCommand(CommandSender s, Command c, String l, String[] args) {
    if (l.equalsIgnoreCase("gmo")) {
      if (args.length < 1) return false;
      if (!(s instanceof Player)) return false;
      if (!CommandBin.permissionCheck((Player)s, "CommandBin.gmo")) {
        Chat.noPermissionMessage((Player)s);
        return true;
      }
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
    return true;
  }
}