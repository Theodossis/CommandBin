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

public class BlindCommand
  implements CommandExecutor
{
  public boolean onCommand(CommandSender s, Command c, String l, String[] args)
  {
    if (l.equalsIgnoreCase("blind")) {
      if (args.length < 1) return false;
      if (!(s instanceof Player)) {
    	  Player target = Bukkit.getServer().getPlayer(args[0]);
    	  if(target != null) {
    		  target.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 400, 1000));
    		  Chat.consoleMessage("You blinded " + target.getName());
    	  }
    	  return true;
      }
      if (!CommandBin.permissionCheck((Player)s, "CommandBin.blind")) {
        Chat.noPermissionMessage((Player)s);
        return true;
      }
      Player target = Bukkit.getServer().getPlayer(args[0]);
      if (target != null) {
        Chat.pMessage((Player)s, "You blinded " + target.getName());
        target.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 400, 1000));
      }
    }
    return true;
  }
}