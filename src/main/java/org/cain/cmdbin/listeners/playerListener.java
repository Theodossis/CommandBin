package org.cain.cmdbin.listeners;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.block.Sign;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.cain.cmdbin.CommandBin;
import org.cain.cmdbin.commands.AfkCommand;
import org.cain.cmdbin.commands.EnableHardcoreCommand;
import org.cain.cmdbin.commands.VanishCommand;
import org.cain.cmdbin.utilities.Chat;
import org.cain.cmdbin.utilities.ExplosionBow;
import org.cain.cmdbin.utilities.Freeze;
import org.cain.cmdbin.utilities.God;
import org.cain.cmdbin.utilities.Handicap;
import org.cain.cmdbin.utilities.Lock;
import org.cain.cmdbin.utilities.Mute;
import org.cain.cmdbin.utilities.Vanish;
import org.cain.cmdbin.utilities.Warp;

public class playerListener
  implements Listener
{
  public static HashMap<String, Double> playerHashX = new HashMap<String, Double>();
  public static HashMap<String, Double> playerHashY = new HashMap<String, Double>();
  public static HashMap<String, Double> playerHashZ = new HashMap<String, Double>();
  public static HashMap<String, String> playerHashWorld = new HashMap<String, String>();

  @EventHandler(priority=EventPriority.NORMAL)
  public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent e) { if (Handicap.hash.containsKey(e.getPlayer())) e.setCancelled(true);

    if (CommandBin.plugin.getConfig().getBoolean("enable-debug-mode"))
      System.out.println("[CommandBin] " + e.getPlayer().getName() + " entered command: " + e.getMessage());
  }

  @EventHandler(priority=EventPriority.NORMAL)
  public void onPlayerChat(PlayerChatEvent e)
  {
    if (Mute.hash.containsKey(e.getPlayer())) e.setCancelled(true);

    if ((!CommandBin.permissionCheck(e.getPlayer(), "CommandBin.lock")) && 
      (Lock.lockhash.containsKey("yes"))) e.setCancelled(true);

    if (CommandBin.permissionCheck(e.getPlayer(), "CommandBin.utils.colorchat")) {
      String colorSupportedMessage = e.getMessage().toString().trim().replace("&", "§");
      e.setMessage(colorSupportedMessage);
    }
  }

  @EventHandler(priority=EventPriority.NORMAL)
  public void onPlayerMove(PlayerMoveEvent e) {
    if (Freeze.freeze_hash.containsKey(e.getPlayer())) e.setCancelled(true);
    if (AfkCommand.afkPlayers.contains(e.getPlayer().getName())) {
      AfkCommand.afkPlayers.remove(e.getPlayer().getName());
      Chat.broadcastMessage(ChatColor.BLUE + e.getPlayer().getName() + " is no longer AFK!");
    }
  }

  @EventHandler(priority=EventPriority.NORMAL)
  public void onPlayerJoin(PlayerJoinEvent e) {
    if (VanishCommand.vanish.containsKey(e.getPlayer().getName())) {
      for (Player otherPlayers : Bukkit.getServer().getOnlinePlayers()) {
        otherPlayers.hidePlayer(e.getPlayer());
      }
    }

    if ((e.getPlayer().isOp()) && (CommandBin.updateAvailable) && (CommandBin.plugin.getConfig().getBoolean("enable-in-game-autoupdate"))) {
      Chat.pMessage(e.getPlayer(), ChatColor.BOLD + "== A new update is available for CommandBin! (v" + CommandBin.updateVersion + ")");
      Chat.pMessage(e.getPlayer(), "== This server is running: v" + CommandBin.plugin.getDescription().getVersion());
      Chat.pMessage(e.getPlayer(), "== Download at http://dev.bukkit.org/server-mods/CommandBin");
    }
  }

  @EventHandler(priority=EventPriority.NORMAL)
  public void onEntityDamage(EntityDamageEvent e) {
    if ((e.getEntity() instanceof Player)) {
      Player godGuy = (Player)e.getEntity();
      if (God.godlist.containsKey(godGuy.getName())) {
        e.setCancelled(true);
        godGuy.getWorld().playEffect(godGuy.getLocation(), Effect.SMOKE, 20);
      }
    }
  }

  @EventHandler(priority=EventPriority.NORMAL)
  public void onProjectileHit(ProjectileHitEvent e) {
    if (((e.getEntity() instanceof Arrow)) && 
      ((((Arrow)e.getEntity()).getShooter() instanceof Player))) {
      Player theShooter = (Player)((Arrow)e.getEntity()).getShooter();
      Entity theArrow = (Arrow)e.getEntity();
      if (ExplosionBow.Explosionbow.containsKey(theShooter.getName())) {
        theArrow.getWorld().createExplosion(theArrow.getLocation(), 5.0F);
        theArrow.remove();
      }
    }
  }

  @EventHandler(priority=EventPriority.MONITOR)
  public void onPlayerRespawn(PlayerRespawnEvent e)
  {
    if (Vanish.invisiblePlayers.containsKey(e.getPlayer().getName())) {
      Vanish.makePlayerInvisible(e.getPlayer());
      Chat.pMessage(e.getPlayer(), "You now have vanish re-given!");
    }

    if (EnableHardcoreCommand.HardcoreMode)
      e.setRespawnLocation(Bukkit.getServer().getWorld(EnableHardcoreCommand.DeathWorld).getSpawnLocation());
  }

  @EventHandler(priority=EventPriority.NORMAL)
  public void onEntityDeath(EntityDeathEvent e)
  {
    if ((e.getEntity() instanceof Player)) {
      Player deathGuy = (Player)e.getEntity();
      if ((deathGuy.getWorld().getName().equalsIgnoreCase(EnableHardcoreCommand.HardcoreWorld)) && 
        (EnableHardcoreCommand.HardcoreMode)) {
        Chat.broadcastMessage(deathGuy.getName() + " got killed!");
        Chat.broadcastMessage("'" + EnableHardcoreCommand.HardcoreWorld + "' will be unloaded and '" + EnableHardcoreCommand.DeathWorld + "' will be your banish spot!");
        for (Player p : Bukkit.getServer().getOnlinePlayers()) {
          p.teleport(Bukkit.getServer().getWorld(EnableHardcoreCommand.DeathWorld).getSpawnLocation());
        }
        Bukkit.getServer().unloadWorld(EnableHardcoreCommand.HardcoreWorld, true);
      }

      playerHashX.put(deathGuy.getName(), Double.valueOf(deathGuy.getLocation().getX()));
      playerHashY.put(deathGuy.getName(), Double.valueOf(deathGuy.getLocation().getY()));
      playerHashZ.put(deathGuy.getName(), Double.valueOf(deathGuy.getLocation().getZ()));
    }
  }

  @EventHandler(priority=EventPriority.NORMAL)
  public void onPlayerTeleport(PlayerTeleportEvent e) {
    playerHashX.put(e.getPlayer().getName(), Double.valueOf(e.getFrom().getX()));
    playerHashY.put(e.getPlayer().getName(), Double.valueOf(e.getFrom().getY()));
    playerHashZ.put(e.getPlayer().getName(), Double.valueOf(e.getFrom().getZ()));
    playerHashWorld.put(e.getPlayer().getName(), e.getFrom().getWorld().getName());
  }
  @EventHandler(priority=EventPriority.NORMAL)
  public void onPlayerInteract(PlayerInteractEvent e) {
    if (((e.getAction() == Action.RIGHT_CLICK_BLOCK) || (e.getAction() == Action.LEFT_CLICK_BLOCK)) && 
      (e.getClickedBlock().getType() == Material.STONE_BUTTON) && 
      (e.getClickedBlock().getRelative(BlockFace.DOWN, 1).getType() == Material.WALL_SIGN)) {
      Sign stuff = (Sign)e.getClickedBlock().getRelative(BlockFace.DOWN, 1).getState();
      String confirmLine = stuff.getLine(0);
      String commandName = stuff.getLine(1);
      if (confirmLine.equalsIgnoreCase("[Warp]")) {
        stuff.setLine(0, ChatColor.GREEN + "[Warp]");
        stuff.update();
      }
      if (((confirmLine.equalsIgnoreCase("[Warp]")) || (confirmLine.equalsIgnoreCase(ChatColor.GREEN + "[Warp]"))) && (CommandBin.plugin.getConfig().get("warps." + commandName) != null)) {
        e.getPlayer().teleport(Warp.teleportToWarp(e.getPlayer(), commandName));
        Chat.pMessage(e.getPlayer(), "Teleported to warp '" + commandName + "'");
      }
    }
  }
}