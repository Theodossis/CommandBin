package org.cain.cmdbin.commands;

import org.bukkit.Material;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.cain.cmdbin.CommandBin;
import org.cain.cmdbin.utilities.Chat;

public class SpawnerCommand
  implements CommandExecutor
{
  public boolean onCommand(CommandSender s, Command c, String l, String[] args)
  {
    if (l.equalsIgnoreCase("spawner")) {
      if (args.length < 1) return false;
      if (!(s instanceof Player)) return false;
      if (!CommandBin.permissionCheck((Player)s, "CommandBin.spawner." + args[0].toLowerCase())) {
        Chat.noPermissionMessage((Player)s);
        return true;
      }

      if (((Player)s).getTargetBlock(null, 0).getType() == Material.MOB_SPAWNER) {
        CreatureSpawner theSpawner = (CreatureSpawner)((Player)s).getTargetBlock(null, 0).getState();
        try {
          theSpawner.setCreatureTypeByName(args[0].toLowerCase());
          theSpawner.update();
          Chat.pMessage((Player)s, "Mob Spawner set to " + args[0]);
        } catch (Exception e) {
          Chat.pMessage((Player)s, "This mob does not exist!");
        }
      }
    }
    return true;
  }
}