package org.cain.cmdbin.utilities;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public class LocationUtil
{
  public static void skyPlayer(Player p)
  {
    int x = (int)p.getLocation().getX();
    int y = 1000;
    int z = (int)p.getLocation().getZ();
    Location loc = new Location(p.getWorld(), x, y, z);
    p.teleport(loc);
  }

  public static void voidPlayer(Player p) {
    int x = (int)p.getLocation().getX();
    int y = -1;
    int z = (int)p.getLocation().getZ();
    Location loc = new Location(p.getWorld(), x, y, z);
    p.teleport(loc);
  }
}