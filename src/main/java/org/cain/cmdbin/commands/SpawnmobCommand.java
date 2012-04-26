package org.cain.cmdbin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.cain.cmdbin.CommandBin;
import org.cain.cmdbin.utilities.Chat;

public class SpawnmobCommand
  implements CommandExecutor
{
  public boolean onCommand(CommandSender s, Command c, String l, String[] args)
  {
    if (l.equalsIgnoreCase("spawnmob")) {
      if (args.length < 2) return false;
      if (!(s instanceof Player)) return false;
      if (!CommandBin.permissionCheck((Player)s, "CommandBin.spawnmob")) {
        Chat.noPermissionMessage((Player)s);
        return true;
      }

      for (int i = 0; i < Integer.parseInt(args[1]); i++) {
        ((Player)s).getWorld().spawnCreature(((Player)s).getTargetBlock(null, 0).getLocation(), EntityType.fromName(args[0].toLowerCase()));
      }
      Chat.pMessage((Player)s, args[1] + " " + args[0] + "'s have been spawned!");
    }

    return true;
  }
}