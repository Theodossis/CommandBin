package org.cain.cmdbin.utilities;

import org.bukkit.entity.Player;

public class Weather
{
  public static void createRain(Player p)
  {
    p.getWorld().setStorm(true);
  }

  public static void createSun(Player p) {
    p.getWorld().setStorm(false);
  }
}