package org.cain.cmdbin.utilities;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.cain.cmdbin.CommandBin;

public class Home
{
  public static void saveHomeLocation(Player p)
  {
    CommandBin.plugin.getConfig().set(p.getName() + ".home.x", Double.valueOf(p.getLocation().getX()));
    CommandBin.plugin.getConfig().set(p.getName() + ".home.y", Double.valueOf(p.getLocation().getY()));
    CommandBin.plugin.getConfig().set(p.getName() + ".home.z", Double.valueOf(p.getLocation().getZ()));
    CommandBin.plugin.getConfig().set(p.getName() + ".home.world", p.getWorld().getName());
    CommandBin.plugin.getConfig().set(p.getName() + ".home.enabled", Boolean.valueOf(true));
    CommandBin.plugin.saveConfig();
  }

  public static Location teleportHome(Player p) {
    String world = CommandBin.plugin.getConfig().getString(p.getName() + ".home.world", p.getWorld().getName());
    return new Location(Bukkit.getServer().getWorld(world), CommandBin.plugin.getConfig().getInt(p.getName() + ".home.x"), CommandBin.plugin.getConfig().getInt(p.getName() + ".home.y"), CommandBin.plugin.getConfig().getInt(p.getName() + ".home.z"));
  }

  public static void saveMultihomeLocation(Player p, String homename) {
    CommandBin.plugin.getConfig().set(p.getName() + ".multihome." + homename + ".x", Double.valueOf(p.getLocation().getX()));
    CommandBin.plugin.getConfig().set(p.getName() + ".multihome." + homename + ".y", Double.valueOf(p.getLocation().getY()));
    CommandBin.plugin.getConfig().set(p.getName() + ".multihome." + homename + ".z", Double.valueOf(p.getLocation().getZ()));
    CommandBin.plugin.getConfig().set(p.getName() + ".multihome." + homename + ".world", p.getWorld().getName());
    CommandBin.plugin.getConfig().set(p.getName() + ".multihome." + homename + ".enabled", Boolean.valueOf(true));
    CommandBin.plugin.saveConfig();
  }

  public static Location teleportMultihome(Player p, String homename) {
    String world = CommandBin.plugin.getConfig().getString(p.getName() + ".multihome." + homename + ".world");
    return new Location(Bukkit.getServer().getWorld(world), CommandBin.plugin.getConfig().getInt(p.getName() + ".multihome." + homename + ".x"), CommandBin.plugin.getConfig().getInt(p.getName() + ".multihome." + homename + ".y"), CommandBin.plugin.getConfig().getInt(p.getName() + ".multihome." + homename + ".z"));
  }
}