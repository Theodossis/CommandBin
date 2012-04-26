package org.cain.cmdbin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.cain.cmdbin.CommandBin;
import org.cain.cmdbin.utilities.Chat;

public class CommandBinCommand
  implements CommandExecutor
{
  public boolean onCommand(CommandSender s, Command c, String l, String[] args)
  {
    if (l.equalsIgnoreCase("commandbin")) {
      if (args.length < 1) return false;
      if (!(s instanceof Player)) {
    	  Chat.consoleMessage("You can only run /commandbin in-game.");
    	  return true;
      }

      if (args[0].equalsIgnoreCase("update")) {
        if (!CommandBin.permissionCheck((Player)s, "CommandBin.commandbin.update")) {
          Chat.noPermissionMessage((Player)s);
          return true;
        }
        CommandBin.downloadCommandBin();
        Chat.pMessage((Player)s, "CommandBin has been updated to version: v" + CommandBin.updateVersion);
        Chat.pMessage((Player)s, "Please reload your server for changes to take effect.");
      }

      if (args[0].equalsIgnoreCase("version")) {
        Chat.pMessage((Player)s, "CommandBin Version");
        Chat.pMessage((Player)s, "Current Version: v" + CommandBin.plugin.getDescription().getVersion());
        Chat.pMessage((Player)s, "Latest Version: v" + CommandBin.updateVersion);
      }

      if (args[0].equalsIgnoreCase("credits")) {
        Chat.pMessage((Player)s, "CommandBin Credits");
        Chat.pMessage((Player)s, "Developer/Author/Coder: CainFoool");
      }
    }
    return true;
  }
}