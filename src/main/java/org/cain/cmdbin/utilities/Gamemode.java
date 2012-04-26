package org.cain.cmdbin.utilities;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;

public class Gamemode
{
  public static void setCreative(Player p)
  {
    p.setGameMode(GameMode.CREATIVE);
  }

  public static void setSurvival(Player p) {
    p.setGameMode(GameMode.SURVIVAL);
  }

  public static void modeCheck(Player p) {
    if (p.getGameMode() == GameMode.SURVIVAL)
      p.setGameMode(GameMode.CREATIVE);
    else
      p.setGameMode(GameMode.SURVIVAL);
  }
}