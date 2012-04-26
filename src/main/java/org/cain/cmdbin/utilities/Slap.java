package org.cain.cmdbin.utilities;

import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class Slap
{
  public static void slapPlayer(Player p)
  {
    p.setVelocity(new Vector(p.getVelocity().getX(), 2.0D, p.getVelocity().getY()));
  }
}