package org.cain.cmdbin.utilities;

import java.util.HashMap;
import org.bukkit.entity.Player;

public class God
{
  public static HashMap<String, Boolean> godlist = new HashMap<String, Boolean>();

  public static void enableGodMode(Player p) {
    godlist.put(p.getName(), Boolean.valueOf(true));
  }

  public static void disableGodMode(Player p) {
    godlist.remove(p.getName());
  }
}