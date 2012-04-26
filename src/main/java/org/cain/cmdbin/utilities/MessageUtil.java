package org.cain.cmdbin.utilities;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class MessageUtil
{
  public static void sendMessage(Player from, Player to, String message)
  {
    if (to.getName() != from.getName()) {
      Chat.pMessage(from, "Message sent to " + to.getName());
      Chat.pMessage(to, ChatColor.GRAY + from.getName() + "> " + message);
      System.out.println("[CommandBin Messaging] (" + from.getName() + " > " + to.getName() + ") " + message);
    } else {
      Chat.pMessage(from, "You can't message yourself.");
    }
  }
}