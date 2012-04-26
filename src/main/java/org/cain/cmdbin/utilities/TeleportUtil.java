package org.cain.cmdbin.utilities;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class TeleportUtil
{
  static HashMap<String, String> telehash = new HashMap<String, String>();

  public static void askPlayer(Player from, Player to) {
    telehash.put(to.getName(), from.getName());
    Chat.pMessage(from, "Request sent to teleport to " + to.getName());
    Chat.pMessage(to, from.getName() + " has asked to teleport to you. /accept or /deny");
  }

  public static void acceptTeleport(Player from) {
    Player to = Bukkit.getServer().getPlayer((String)telehash.get(from.getName()));
    from.teleport(to.getLocation());
    Chat.pMessage(from, to.getName() + " accepted your teleport request.");
    Chat.pMessage(to, "Request accepted. Teleporting " + from.getName() + " to you");
  }

  public static void denyTeleport(Player from, Player to)
  {
  }
}