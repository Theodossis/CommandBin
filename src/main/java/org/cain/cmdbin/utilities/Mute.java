package org.cain.cmdbin.utilities;

import java.util.HashMap;

import org.bukkit.entity.Player;

public class Mute
{
  public static HashMap<Player, Boolean> hash = new HashMap<Player, Boolean>();

  public static void mutePlayer(Player p) {
    hash.put(p, Boolean.valueOf(true));
  }

  public static void unmutePlayer(Player p) {
    hash.remove(p);
  }
}