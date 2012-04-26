package org.cain.cmdbin.commands;

import java.util.HashMap;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.cain.cmdbin.CommandBin;
import org.cain.cmdbin.utilities.Chat;
import org.cain.cmdbin.utilities.God;

public class GodCommand
  implements CommandExecutor
{
  static HashMap<String, Boolean> godToggle = new HashMap<String, Boolean>();

  public boolean onCommand(CommandSender s, Command c, String l, String[] args) {
    if (l.equalsIgnoreCase("god")) {
      if (!(s instanceof Player)) return false;
      if (!CommandBin.permissionCheck((Player)s, "CommandBin.god")) {
        Chat.noPermissionMessage((Player)s);
        return true;
      }
      if (!godToggle.containsKey(((Player)s).getName())) {
        God.disableGodMode((Player)s);
        Chat.pMessage((Player)s, "God Mode Disabled!");
        godToggle.put(((Player)s).getName(), Boolean.valueOf(true));
        return true;
      }
      God.enableGodMode((Player)s);
      Chat.pMessage((Player)s, "God Mode Enabled!");
      godToggle.remove(((Player)s).getName());
      return true;
    }

    return true;
  }
}