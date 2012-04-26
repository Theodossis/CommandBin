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

public class DrunkCommand
  implements CommandExecutor
{
  public boolean onCommand(CommandSender s, Command c, String l, String[] args)
  {
    if (l.equalsIgnoreCase("drunk")) {
      if (args.length < 1) return false;
      if (!(s instanceof Player)) {
    	  Player target = Bukkit.getServer().getPlayer(args[0]);
    	  if(target != null) {
    		  target.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 1200, 1000));
    		  Chat.consoleMessage("You made " + target.getName() + " feel drunk!");
    	  }
    	  return true;
      }
      if (!CommandBin.permissionCheck((Player)s, "CommandBin.drunk")) {
        Chat.noPermissionMessage((Player)s);
        return true;
      }
      Player target = Bukkit.getServer().getPlayer(args[0]);
      if (target != null) {
        target.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 1200, 1000));
        Chat.pMessage((Player)s, "You made " + target.getName() + " feel drunk!");
        Chat.pMessage(target, "You feel slightly dizzy.. maybe " + ((Player)s).getName() + " gave you some vodka.");
      }
    }
    return true;
  }
}