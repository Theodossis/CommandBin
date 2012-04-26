package org.cain.cmdbin.utilities;

import java.util.HashMap;
import org.bukkit.entity.Player;

public class ExplosionBow
{
  public static HashMap<String, Boolean> Explosionbow = new HashMap<String, Boolean>();

  public static void addExplosionBowToPlayer(Player p) {
    Explosionbow.put(p.getName(), Boolean.valueOf(true));
  }

  public static void removeExplosionBowFromPlayer(Player p) {
    Explosionbow.remove(p.getName());
  }
}