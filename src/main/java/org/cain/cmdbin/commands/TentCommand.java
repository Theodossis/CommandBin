package org.cain.cmdbin.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.cain.cmdbin.CommandBin;
import org.cain.cmdbin.utilities.Chat;

public class TentCommand
  implements CommandExecutor
{
  public boolean onCommand(CommandSender s, Command c, String l, String[] args)
  {
    if (l.equalsIgnoreCase("tent")) {
      if (!(s instanceof Player)) return false;
      if (!CommandBin.permissionCheck((Player)s, "CommandBin.tent")) {
        Chat.noPermissionMessage((Player)s);
        return true;
      }

      generateTent((Player)s);
    }
    return true;
  }

  public void generateTent(Player p) {
    p.getLocation().getBlock().getRelative(0, -1, 0).setType(Material.WOOL);
    p.getLocation().getBlock().getRelative(1, -1, 0).setType(Material.WOOL);
    p.getLocation().getBlock().getRelative(-1, -1, 0).setType(Material.WOOL);
    p.getLocation().getBlock().getRelative(-1, -1, -1).setType(Material.WOOL);
    p.getLocation().getBlock().getRelative(0, -1, -1).setType(Material.WOOL);
    p.getLocation().getBlock().getRelative(1, -1, -1).setType(Material.WOOL);
    p.getLocation().getBlock().getRelative(0, -1, 1).setType(Material.WOOL);
    p.getLocation().getBlock().getRelative(-1, -1, 1).setType(Material.WOOL);
    p.getLocation().getBlock().getRelative(1, -1, 1).setType(Material.WOOL);

    p.getLocation().getBlock().getRelative(2, 0, 1).setType(Material.WOOL);
    p.getLocation().getBlock().getRelative(2, 0, 0).setType(Material.WOOL);
    p.getLocation().getBlock().getRelative(2, 0, -1).setType(Material.WOOL);
    p.getLocation().getBlock().getRelative(0, 0, -2).setType(Material.WOOL);
    p.getLocation().getBlock().getRelative(1, 0, -2).setType(Material.WOOL);
    p.getLocation().getBlock().getRelative(-1, 0, -2).setType(Material.WOOL);
    p.getLocation().getBlock().getRelative(-2, 0, -1).setType(Material.WOOL);
    p.getLocation().getBlock().getRelative(-2, 0, 0).setType(Material.WOOL);
    p.getLocation().getBlock().getRelative(-2, 0, 1).setType(Material.WOOL);

    p.getLocation().getBlock().getRelative(2, 1, 1).setType(Material.WOOL);
    p.getLocation().getBlock().getRelative(2, 1, 0).setType(Material.WOOL);
    p.getLocation().getBlock().getRelative(2, 1, -1).setType(Material.WOOL);
    p.getLocation().getBlock().getRelative(0, 1, -2).setType(Material.FENCE);
    p.getLocation().getBlock().getRelative(1, 1, -2).setType(Material.FENCE);
    p.getLocation().getBlock().getRelative(-1, 1, -2).setType(Material.FENCE);
    p.getLocation().getBlock().getRelative(-2, 1, -1).setType(Material.WOOL);
    p.getLocation().getBlock().getRelative(-2, 1, 0).setType(Material.WOOL);
    p.getLocation().getBlock().getRelative(-2, 1, 1).setType(Material.WOOL);

    p.getLocation().getBlock().getRelative(0, 1, 1).setType(Material.FENCE);
    p.getLocation().getBlock().getRelative(0, 0, 1).setType(Material.FENCE);

    p.getLocation().getBlock().getRelative(-1, 0, -1).setType(Material.WORKBENCH);
    p.getLocation().getBlock().getRelative(0, 0, -1).setType(Material.FURNACE);
    p.getLocation().getBlock().getRelative(1, 0, -1).setType(Material.CHEST);

    p.getLocation().getBlock().getRelative(0, 2, 0).setType(Material.WOOL);
    p.getLocation().getBlock().getRelative(1, 2, 0).setType(Material.WOOL);
    p.getLocation().getBlock().getRelative(-1, 2, 0).setType(Material.WOOL);
    p.getLocation().getBlock().getRelative(-1, 2, -1).setType(Material.WOOL);
    p.getLocation().getBlock().getRelative(0, 2, -1).setType(Material.WOOL);
    p.getLocation().getBlock().getRelative(1, 2, -1).setType(Material.WOOL);
    p.getLocation().getBlock().getRelative(0, 2, 1).setType(Material.WOOL);
    p.getLocation().getBlock().getRelative(-1, 2, 1).setType(Material.WOOL);
    p.getLocation().getBlock().getRelative(1, 2, 1).setType(Material.WOOL);

    p.getLocation().getBlock().getRelative(-2, 1, 2).setType(Material.TORCH);
    p.getLocation().getBlock().getRelative(2, 1, 2).setType(Material.TORCH);
  }
}