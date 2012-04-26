package org.cain.cmdbin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.cain.cmdbin.CommandBin;
import org.cain.cmdbin.utilities.Chat;

public class PotionCommand
  implements CommandExecutor
{
  public boolean onCommand(CommandSender s, Command c, String l, String[] args)
  {
    if (l.equalsIgnoreCase("potion")) {
      if (args.length < 3) return false;
      if (!(s instanceof Player)) return false;
      if (!CommandBin.permissionCheck((Player)s, "CommandBin.potion")) {
        Chat.noPermissionMessage((Player)s);
        return true;
      }
      Player target = Bukkit.getServer().getPlayer(args[0]);

      if (target != null) {
        try {
          try {
            target.addPotionEffect(new PotionEffect(PotionEffectType.getByName(args[1].toUpperCase()), Integer.parseInt(args[2]) * 20, 2147483647));
            Chat.pMessage((Player)s, "Potion '" + args[1].toUpperCase() + "' added to '" + target.getName() + "'");
          } catch (NumberFormatException e) {
            Chat.pMessage((Player)s, "You never entered a valid amount of time.");
          }
        } catch (IllegalArgumentException e) {
          Chat.pMessage((Player)s, "This potion does not exist '" + args[1].toUpperCase() + "'");
        }
      }
    }
    return true;
  }
}