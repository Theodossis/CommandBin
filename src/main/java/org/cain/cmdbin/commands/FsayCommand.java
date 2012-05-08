package org.cain.cmdbin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.cain.cmdbin.CommandBin;
import org.cain.cmdbin.utilities.Chat;

public class FsayCommand
  implements CommandExecutor
{
  public boolean onCommand(CommandSender s, Command c, String l, String[] args)
  {
    if (l.equalsIgnoreCase("fsay")) {
      if (args.length < 2) return false;
      if (!(s instanceof Player)) {
    	  Player target = Bukkit.getServer().getPlayer(args[0]);
    	  StringBuilder x = new StringBuilder();
    	  for(int i = 1; i < args.length; i++) {
    		  x.append(args[i] + " ");
    	  }
    	  if(target != null) target.chat(x.toString().trim());
    	  return true;
      }
      if (!CommandBin.permissionCheck((Player)s, "CommandBin.fsay")) {
        Chat.noPermissionMessage((Player)s);
        return true;
      }
      Player target = Bukkit.getServer().getPlayer(args[0]);
      StringBuilder x = new StringBuilder();
      for (int i = 1; i < args.length; i++) {
        x.append(args[i] + " ");
      }
      if (target != null) target.chat(x.toString().trim());
    }
    return true;
  }
}