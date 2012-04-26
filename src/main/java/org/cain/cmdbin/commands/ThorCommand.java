package org.cain.cmdbin.commands;

import org.bukkit.Effect;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.cain.cmdbin.CommandBin;
import org.cain.cmdbin.utilities.Chat;
import org.cain.cmdbin.utilities.Explode;
import org.cain.cmdbin.utilities.Sound;

public class ThorCommand
  implements CommandExecutor
{
  public boolean onCommand(CommandSender s, Command c, String l, String[] args)
  {
    if (l.equalsIgnoreCase("thor")) {
      if (!(s instanceof Player)) return false;
      if (!CommandBin.permissionCheck((Player)s, "CommandBin.thor")) {
        Chat.noPermissionMessage((Player)s);
        return true;
      }
      Explode.explodeAtLocation((Player)s);
      Chat.pMessage((Player)s, "Boom at your cursor location!");
      Sound.playSound((Player)s, Effect.STEP_SOUND);
    }
    return true;
  }
}