package com.timiette.loottables;

import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;


public class SkyWarsLoot extends Loot {

    public void initiate() {

        chestInventory.put(new ItemStack(Material.LEATHER_HELMET, 1), 40.0);
        chestInventory.put(new ItemStack(Material.DIAMOND_CHESTPLATE,1), 25.0);
        chestInventory.put(new ItemStack(Material.IRON_LEGGINGS,1), 25.0);
        chestInventory.put(new ItemStack(Material.IRON_BOOTS,1), 25.0);
        chestInventory.put(new ItemStack(Material.IRON_HELMET, 1), 25.0);
        chestInventory.put(new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1), 30.0);
        chestInventory.put(new ItemStack(Material.CHAINMAIL_LEGGINGS, 1), 30.0);


        chestInventory.put(new ItemStack(Material.STONE_SWORD, 1), 38.0);
        chestInventory.put(new ItemStack(Material.DIAMOND_SWORD, 1), 28.0);
        chestInventory.put(new ItemStack(Material.BOW, 1), 36.0);

        chestInventory.put(new ItemStack(Material.SNOWBALL, 16), 39.0);
        chestInventory.put(new ItemStack(Material.EGG,16), 39.0);
        chestInventory.put(new ItemStack(Material.FLINT_AND_STEEL, 1), 20.0);
        chestInventory.put(new ItemStack(Material.WATER_BUCKET, 1), 25.0);
        chestInventory.put(new ItemStack(Material.FIRE_CHARGE, 1), 25.0);

        chestInventory.put(new ItemStack(Material.OAK_LOG, 14), 30.0);
        chestInventory.put(new ItemStack(Material.STONE, 16), 30.0);


    }



}
