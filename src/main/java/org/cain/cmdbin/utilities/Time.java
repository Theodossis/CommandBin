package org.cain.cmdbin.utilities;

import org.bukkit.entity.Player;

public class Time
{
  public static void setDay(Player p)
  {
    p.getWorld().setTime(0L);
  }

  public static void setNight(Player p) {
    p.getWorld().setTime(18200L);
  }
}