package org.cain.cmdbin.utilities;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.cain.cmdbin.CommandBin;

public class Warp
{
  public static void setWarpLocation(Player p, String warpname)
  {
    CommandBin.plugin.getConfig().set("warps." + warpname + ".x", Double.valueOf(p.getLocation().getX()));
    CommandBin.plugin.getConfig().set("warps." + warpname + ".y", Double.valueOf(p.getLocation().getY()));
    CommandBin.plugin.getConfig().set("warps." + warpname + ".z", Double.valueOf(p.getLocation().getZ()));
    CommandBin.plugin.getConfig().set("warps." + warpname + ".world", p.getWorld().getName());
    CommandBin.plugin.saveConfig();
  }

  public static Location teleportToWarp(Player p, String warpname) {
    String worldName = CommandBin.plugin.getConfig().get("warps." + warpname + ".world").toString();
    int locX = CommandBin.plugin.getConfig().getInt("warps." + warpname + ".x");
    int locY = CommandBin.plugin.getConfig().getInt("warps." + warpname + ".y");
    int locZ = CommandBin.plugin.getConfig().getInt("warps." + warpname + ".z");
    return new Location(Bukkit.getServer().getWorld(worldName), locX, locY, locZ);
  }
}