package org.cain.cmdbin.utilities;

import org.bukkit.entity.Player;

public class IP
{
  public static String playerIP(Player p)
  {
    return p.getAddress().toString();
  }
}