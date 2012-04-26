package org.cain.cmdbin.utilities;

import java.util.HashMap;
import org.bukkit.entity.Player;

public class Handicap
{
  public static HashMap<Player, Boolean> hash = new HashMap<Player, Boolean>();

  public static void handicapPlayer(Player p) {
    hash.put(p, Boolean.valueOf(true));
  }

  public static void unhandicapPlayer(Player p) {
    hash.remove(p);
  }
}