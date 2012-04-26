package org.cain.cmdbin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.cain.cmdbin.CommandBin;
import org.cain.cmdbin.utilities.Chat;
import org.cain.cmdbin.utilities.Weather;

public class WeatherCommand
  implements CommandExecutor
{
  public boolean onCommand(CommandSender s, Command c, String l, String[] args)
  {
    if (l.equalsIgnoreCase("weather")) {
      if (args.length < 1) return false;
      if (!(s instanceof Player)) return false;
      if (!CommandBin.permissionCheck((Player)s, "CommandBin.weather")) {
        Chat.noPermissionMessage((Player)s);
        return true;
      }
      if (args[0].equalsIgnoreCase("sun")) {
        Weather.createSun((Player)s);
        Chat.pMessage((Player)s, "Weather set to sunny!");
      }
      if (args[0].equalsIgnoreCase("rain")) {
        Weather.createRain((Player)s);
        Chat.pMessage((Player)s, "Weather set to rainy!");
      }
    }
    return true;
  }
}