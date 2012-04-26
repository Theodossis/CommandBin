package org.cain.cmdbin.utilities;

import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class Shoot
{
  public static void shootPlayer(Player p)
  {
    p.setVelocity(new Vector(p.getVelocity().getX(), 128.0D, p.getVelocity().getY()));
  }
}