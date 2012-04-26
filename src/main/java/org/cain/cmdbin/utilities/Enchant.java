package org.cain.cmdbin.utilities;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;

public class Enchant
{
  public static void enchantItem(Player p, int level)
  {
    p.getItemInHand().addEnchantment(Enchantment.DAMAGE_ALL, level);
    p.getItemInHand().addEnchantment(Enchantment.DURABILITY, level);
    p.getItemInHand().addEnchantment(Enchantment.KNOCKBACK, level);
    p.getItemInHand().addEnchantment(Enchantment.LOOT_BONUS_BLOCKS, level);
    p.getItemInHand().addEnchantment(Enchantment.LOOT_BONUS_MOBS, level);
    p.getItemInHand().addEnchantment(Enchantment.SILK_TOUCH, level);
    p.getItemInHand().addEnchantment(Enchantment.WATER_WORKER, level);
  }
}