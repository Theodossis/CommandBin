package org.cain.cmdbin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.cain.cmdbin.CommandBin;
import org.cain.cmdbin.utilities.Block;
import org.cain.cmdbin.utilities.Chat;

public class BlockCommand
  implements CommandExecutor
{
  public boolean onCommand(CommandSender s, Command c, String l, String[] args)
  {
    if (l.equalsIgnoreCase("block")) {
      if (args.length < 1) return false;
      if (!(s instanceof Player)) {
    	  Player target = Bukkit.getServer().getPlayer(args[0]);
    	  if(target != null) {
    		  Block.blockPlayer(target);
    		  Chat.consoleMessage("This player can no longer place blocks.");
    	  }
    	  return true;
      }
      if (!CommandBin.permissionCheck((Player)s, "CommandBin.block")) {
        Chat.noPermissionMessage((Player)s);
        return true;
      }
      Player target = Bukkit.getServer().getPlayer(args[0]);
      if (target != null) {
        Block.blockPlayer(target);
        Chat.pMessage((Player)s, "Player can no longer place blocks");
      }
    }
    return true;
  }
}