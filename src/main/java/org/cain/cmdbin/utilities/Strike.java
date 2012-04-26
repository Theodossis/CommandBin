package org.cain.cmdbin.utilities;

import org.bukkit.entity.Player;

public class Strike
{
  public static void strikePlayer(Player p)
  {
    p.getWorld().strikeLightning(p.getLocation());
  }
}