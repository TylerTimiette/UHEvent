package com.timiette.loottables;

import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class Table {

private ArrayList<LootEntry> entries;

    public Table(ArrayList<LootEntry> entries){
        this.entries = entries;
    }


    public ItemStack getItem() {
        double random = Math.random();

        for(int i = 0; i < entries.size() - 1; i++) {
            LootEntry entry = entries.get(i + 1);
            if(entry.getChance() > random)
                return entries.get(i).getItemStack();
        }
        return entries.get(entries.size() - 1).getItemStack();
    }






    public static class LowTableBuilder {
        private int totalweight = 0;
        private ArrayList<LootEntry> entries = new ArrayList<>();

        public LowTableBuilder add(ItemStack itemStack,  int weight) {
            totalweight += weight;
            entries.add(new LootEntry(itemStack, weight));
            return this;
        }

        public boolean isBuilt() {
            return entries.size() > 0 && totalweight > 0;
        }

        public Table build() {
            if(!isBuilt())
                return null;

            double base = 0;
            for(LootEntry e : entries) {
                double chance = getChance(base);
                e.setChance(chance);
                base += e.getWeight();
            }
            return new Table(entries);
        }


        private double getChance(double weight) {
            return weight / totalweight;
        }
    }

    public static class HighTableBuilder {

    }
}
