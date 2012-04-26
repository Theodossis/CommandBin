package org.cain.cmdbin.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.cain.cmdbin.CommandBin;
import org.cain.cmdbin.utilities.Chat;

public class HoleCommand
  implements CommandExecutor
{
  public boolean onCommand(CommandSender s, Command c, String l, String[] args)
  {
    if (l.equalsIgnoreCase("hole")) {
      if (args.length < 1) return false;
      if (!(s instanceof Player)) return false;
      if (!CommandBin.permissionCheck((Player)s, "CommandBin.hole")) {
        Chat.noPermissionMessage((Player)s);
        return true;
      }
      int i = 0;

      Player target = Bukkit.getServer().getPlayer(args[0]);
      if (target != null) {
        while (i < 50) {
          target.getLocation().getBlock().getRelative(BlockFace.DOWN, i).setType(Material.AIR);
          i++;
        }
        Chat.pMessage((Player)s, "You sent " + target.getName() + " down a big hole!");
      }
    }
    return true;
  }
}