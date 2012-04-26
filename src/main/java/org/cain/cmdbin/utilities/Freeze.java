package org.cain.cmdbin.utilities;

import java.util.HashMap;
import org.bukkit.entity.Player;

public class Freeze
{
  public static HashMap<Player, Boolean> freeze_hash = new HashMap<Player, Boolean>();

  public static void freezePlayer(Player p) {
    freeze_hash.put(p, Boolean.valueOf(true));
  }

  public static void unfreezePlayer(Player p) {
    freeze_hash.remove(p);
  }
}