package com.timiette.loottables;

import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;

public class LootEntry {
    private int weight;
    private ItemStack itemStack;
    private double chance;

    public LootEntry(ItemStack itemStack, int weight) {
        this.itemStack = itemStack;
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setChance(double chance) {
        this.chance = chance;
    }

    public double getChance() {
        return chance;
    }

    public ItemStack getItemStack() {
        return itemStack.clone();
    }
}
