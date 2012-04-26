package org.cain.cmdbin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.cain.cmdbin.CommandBin;
import org.cain.cmdbin.utilities.Chat;

public class EnableHardcoreCommand
  implements CommandExecutor
{
  public static String HardcoreWorld;
  public static String DeathWorld;
  public static boolean HardcoreMode;

  public boolean onCommand(CommandSender s, Command c, String l, String[] args)
  {
    if (l.equalsIgnoreCase("enablehardcore")) {
      if (args.length < 2) return false;
      if (!(s instanceof Player)) {
          if ((Bukkit.getServer().getWorld(args[0]) != null) && (Bukkit.getServer().getWorld(args[1]) != null)) {
              HardcoreWorld = args[0];
              DeathWorld = args[1];
              Chat.broadcastMessage("Hardcore Mode has started on '" + args[0] + "'");
              Chat.broadcastMessage("If one player dies, all will be banished to '" + DeathWorld + "' !");
              Chat.broadcastMessage("And the '" + args[0] + "' world will be unloaded.");
              HardcoreMode = true;
            }
          return true;
      }
      if (!CommandBin.permissionCheck((Player)s, "CommandBin.enablehardcore")) {
        Chat.noPermissionMessage((Player)s);
        return true;
      }
      if ((Bukkit.getServer().getWorld(args[0]) != null) && (Bukkit.getServer().getWorld(args[1]) != null)) {
        HardcoreWorld = args[0];
        DeathWorld = args[1];
        Chat.broadcastMessage("Hardcore Mode has started on '" + args[0] + "'");
        Chat.broadcastMessage("If one player dies, all will be banished to '" + DeathWorld + "' !");
        Chat.broadcastMessage("And the '" + args[0] + "' world will be unloaded.");
        HardcoreMode = true;
      }
    }
    return true;
  }
}