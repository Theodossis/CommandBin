package org.cain.cmdbin.utilities;

import org.bukkit.entity.Player;

public class Chunk
{
  public static void reloadChunk(Player p)
  {
    p.getLocation().getChunk().load();
  }

  public static void unloadChunk(Player p) {
    p.getLocation().getChunk().unload(true);
  }
}