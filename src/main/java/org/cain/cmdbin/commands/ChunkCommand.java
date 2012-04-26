package org.cain.cmdbin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.cain.cmdbin.CommandBin;
import org.cain.cmdbin.utilities.Chat;
import org.cain.cmdbin.utilities.Chunk;

public class ChunkCommand
  implements CommandExecutor
{
  public boolean onCommand(CommandSender s, Command c, String l, String[] args)
  {
    if (l.equalsIgnoreCase("chunk")) {
      if (!(s instanceof Player)) {
    	  Chat.consoleMessage("You cannot reload the chunk you are standing in console.");
    	  return true;
      }
      if (!CommandBin.permissionCheck((Player)s, "CommandBin.chunk")) {
        Chat.noPermissionMessage((Player)s);
        return true;
      }
      Chunk.reloadChunk((Player)s);
      Chat.pMessage((Player)s, "Chunk reloaded!");
    }
    return true;
  }
}