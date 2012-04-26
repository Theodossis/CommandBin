package org.cain.cmdbin.utilities;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Color
{
  public static void setOpColor(Player p)
  {
    p.setDisplayName(ChatColor.RED + p.getName());
    p.setPlayerListName(ChatColor.RED + p.getName() + ChatColor.WHITE);
  }
}