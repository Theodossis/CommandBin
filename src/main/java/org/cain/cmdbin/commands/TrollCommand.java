package org.cain.cmdbin.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.cain.cmdbin.CommandBin;
import org.cain.cmdbin.utilities.Chat;

public class TrollCommand
  implements CommandExecutor
{
  public boolean onCommand(CommandSender s, Command c, String l, String[] args)
  {
    if (l.equalsIgnoreCase("troll")) {
      if (args.length < 1) return false;
      if (!(s instanceof Player)) return false;
      if (!CommandBin.permissionCheck((Player)s, "CommandBin.troll")) {
        Chat.noPermissionMessage((Player)s);
        return true;
      }

      Player target = Bukkit.getServer().getPlayer(args[0]);
      if (target != null)
      {
        for (int i = (int)target.getLocation().getY(); i < 129; i++) {
          target.getWorld().dropItem(new Location(target.getWorld(), target.getLocation().getX(), i, target.getLocation().getZ()), new ItemStack(Material.DIAMOND, 0));
        }
        Chat.pMessage((Player)s, "Trolled " + target.getName() + " with loads of diamond!");
      }
    }
    return true;
  }
}