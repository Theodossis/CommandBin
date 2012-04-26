package org.cain.cmdbin.utilities;

import org.bukkit.Bukkit;
import org.bukkit.WorldCreator;

public class WorldUtil
{
  public static void createWorld(String name)
  {
    Bukkit.getServer().createWorld(new WorldCreator(name));
  }

  public static void unloadWorld(String name) {
    Bukkit.getServer().unloadWorld(name, true);
  }
}