package org.cain.cmdbin.utilities;

import org.bukkit.entity.Player;

public class Feed
{
  public static void feedPlayer(Player p)
  {
    p.setFoodLevel(20);
  }
}