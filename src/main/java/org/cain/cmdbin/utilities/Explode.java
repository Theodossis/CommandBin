package org.cain.cmdbin.utilities;

import org.bukkit.entity.Player;

public class Explode
{
  public static void explodePlayer(Player p)
  {
    p.getWorld().createExplosion(p.getLocation(), 5.0F);
  }

  public static void explodeAtLocation(Player p) {
    p.getWorld().createExplosion(p.getTargetBlock(null, 0).getLocation(), 5.0F);
  }
}