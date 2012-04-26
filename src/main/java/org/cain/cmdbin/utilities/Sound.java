package org.cain.cmdbin.utilities;

import org.bukkit.Effect;
import org.bukkit.entity.Player;

public class Sound
{
  public static void playSound(Player p, Effect effect)
  {
    p.getWorld().playEffect(p.getLocation(), effect, 5);
  }
}