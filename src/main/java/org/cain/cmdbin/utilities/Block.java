package org.cain.cmdbin.utilities;

import java.util.HashMap;

import org.bukkit.entity.Player;

public class Block
{
  public static HashMap<Player, Boolean> block = new HashMap<Player, Boolean>();

  public static void blockPlayer(Player p) {
    block.put(p, Boolean.valueOf(true));
  }

  public static void unblockPlayer(Player p) {
    block.remove(p);
  }
}