package org.cain.cmdbin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.cain.cmdbin.CommandBin;
import org.cain.cmdbin.utilities.Chat;

public class FakeopCommand
  implements CommandExecutor
{
  public boolean onCommand(CommandSender s, Command c, String l, String[] args)
  {
    if (l.equalsIgnoreCase("fakeop")) {
      if (args.length < 1) return false;
      if (!(s instanceof Player)) {
    	  Player target = Bukkit.getServer().getPlayer(args[0]);
    	  if(target != null) {
    		  Chat.consoleMessage("OP Message has been sent to " + target.getName());
    		  Chat.pMessage(target, ChatColor.YELLOW + "You are now op!");
    	  }
    	  return true;
      }
      if (!CommandBin.permissionCheck((Player)s, "CommandBin.fakeop")) {
        Chat.noPermissionMessage((Player)s);
        return true;
      }
      Player target = Bukkit.getServer().getPlayer(args[0]);
      if (target != null) {
        Chat.pMessage(target, ChatColor.YELLOW + "You are now op!");
        Chat.pMessage((Player)s, "Fake Op message sent to " + target.getName());
      }
    }
    return true;
  }
}