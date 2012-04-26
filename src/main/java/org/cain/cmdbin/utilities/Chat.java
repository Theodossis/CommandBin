package org.cain.cmdbin.utilities;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Chat
{
  public static void pMessage(Player p, String message)
  {
    p.sendMessage(ChatColor.DARK_AQUA + message);
  }

  public static void broadcastMessage(String message) {
    Bukkit.getServer().broadcastMessage(ChatColor.YELLOW + message);
  }

  public static void noPermissionMessage(Player p) {
    p.sendMessage(ChatColor.RED + "You have no permission to run this command.");
  }

  public static void sendBoldMessage(Player p, String args) {
    p.chat(ChatColor.BOLD + args);
  }
  public static void sendItalicMessage(Player p, String args) {
    p.chat(ChatColor.ITALIC + args);
  }
  public static void sendStrikethroughMessage(Player p, String args) {
    p.chat(ChatColor.STRIKETHROUGH + args);
  }
  public static void sendUnderlineMessage(Player p, String args) {
    p.chat(ChatColor.UNDERLINE + args);
  }
  
  public static void consoleMessage(String message) {
	System.out.println(message);
  }
  
}