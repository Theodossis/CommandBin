package org.cain.cmdbin.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.cain.cmdbin.CommandBin;
import org.cain.cmdbin.utilities.Chat;

public class ItemCommand
  implements CommandExecutor
{
  public boolean onCommand(CommandSender s, Command c, String l, String[] args)
  {
    if (l.equalsIgnoreCase("item")) {
      if (args.length < 2) return false;
      if (!(s instanceof Player)) return false;
      if (!CommandBin.permissionCheck((Player)s, "CommandBin.item")) {
        Chat.noPermissionMessage((Player)s);
        return true;
      }
      try
      {
        String materialName = args[0].toUpperCase();
        int amount = Integer.parseInt(args[1]);

        ((Player)s).getInventory().addItem(new ItemStack[] { new ItemStack(Material.getMaterial(materialName), amount) });
        Chat.pMessage((Player)s, amount + " " + materialName + " has been added to your inventory!");
      } catch (Exception e) {
        Chat.pMessage((Player)s, "Something went wrong :( The item might not exist.");
      }
    }
    return true;
  }
}