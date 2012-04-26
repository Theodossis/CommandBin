package org.cain.cmdbin.utilities;

import org.bukkit.entity.Player;

public class XP
{
  public static double getExperience(Player p)
  {
    return p.getExp();
  }

  public static void setExperience(Player p, float i) {
    p.setExp(i);
  }

  public static void addExperience(Player p, float i) {
    p.setExp(p.getExp() + i);
  }

  public static void setExperienceLevel(Player p, int i) {
    p.setLevel(i);
  }
}