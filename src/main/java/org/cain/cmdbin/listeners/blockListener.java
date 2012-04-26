package org.cain.cmdbin.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.cain.cmdbin.CommandBin;
import org.cain.cmdbin.utilities.Block;
import org.cain.cmdbin.utilities.Lock;

public class blockListener
  implements Listener
{
  @EventHandler(priority=EventPriority.NORMAL)
  public void onBlockPlace(BlockPlaceEvent e)
  {
    if (Block.block.containsKey(e.getPlayer())) e.setCancelled(true);

    if ((!CommandBin.permissionCheck(e.getPlayer(), "CommandBin.lock")) && 
      (Lock.lockhash.containsKey("yes"))) e.setCancelled(true); 
  }

  @EventHandler(priority=EventPriority.NORMAL)
  public void onBlockBreak(BlockBreakEvent e)
  {
    if (Block.block.containsKey(e.getPlayer())) e.setCancelled(true);

    if ((!CommandBin.permissionCheck(e.getPlayer(), "CommandBin.lock")) && 
      (Lock.lockhash.containsKey("yes"))) e.setCancelled(true);
  }
}