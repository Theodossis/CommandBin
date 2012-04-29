package org.cain.cmdbin.utilities;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.cain.cmdbin.CommandBin;
import org.dynmap.DynmapAPI;

public class Vanish
{
	
	static DynmapAPI dynapi;
  public static HashMap<String, Boolean> invisiblePlayers = new HashMap<String, Boolean>();

  public static void makePlayerInvisible(Player p) {
    for (Player otherPlayers : Bukkit.getServer().getOnlinePlayers()) {
      otherPlayers.hidePlayer(p);
      invisiblePlayers.put(p.getName(), Boolean.valueOf(true));
      if(CommandBin.DynmapEnabled) dynapi.setPlayerVisiblity(otherPlayers, false);
    }
  }

  public static void makePlayerVisible(Player p) {
    for (Player otherPlayers : Bukkit.getServer().getOnlinePlayers()) {
      otherPlayers.showPlayer(p);
      invisiblePlayers.remove(p.getName());
      if(CommandBin.DynmapEnabled) dynapi.setPlayerVisiblity(otherPlayers, true);
    }
  }
}