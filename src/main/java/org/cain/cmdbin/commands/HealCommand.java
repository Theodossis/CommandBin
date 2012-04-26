package org.cain.cmdbin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.cain.cmdbin.CommandBin;
import org.cain.cmdbin.utilities.Chat;
import org.cain.cmdbin.utilities.Heal;

public class HealCommand
  implements CommandExecutor
{
  public boolean onCommand(CommandSender s, Command c, String l, String[] args)
  {
    if (l.equalsIgnoreCase("heal")) {
      if (!(s instanceof Player)) return false;
      if (!CommandBin.permissionCheck((Player)s, "CommandBin.heal")) {
        Chat.noPermissionMessage((Player)s);
        return true;
      }
      Heal.healPlayer((Player)s);
      Chat.pMessage((Player)s, "Healed!");
    }
    return true;
  }
}