package com.timiette.loottables;

import com.timiette.utils.ChestManager;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class SkyWarsLoot extends SeedableGame {
    public HashMap<ItemStack, Double> chestInventory = new HashMap<>();



    public void initiate() {

        chestInventory.put(new ItemStack(Material.LEATHER_HELMET, 1), 40.0);

        chestInventory.put(new ItemStack(Material.DIAMOND_CHESTPLATE,1), 25.0);
        chestInventory.put(new ItemStack(Material.IRON_LEGGINGS,1), 25.0);
        chestInventory.put(new ItemStack(Material.IRON_BOOTS,1), 25.0);
        chestInventory.put(new ItemStack(Material.IRON_HELMET, 1), 25.0);


        chestInventory.put(new ItemStack(Material.STONE_SWORD, 1), 38.0);
        chestInventory.put(new ItemStack(Material.DIAMOND_SWORD), 28.0);

        chestInventory.put(new ItemStack(Material.SNOWBALL, 16), 39.0);
        chestInventory.put(new ItemStack(Material.EGG,16), 39.0);
        chestInventory.put(new ItemStack(Material.FLINT_AND_STEEL, 1), 25.0);
        chestInventory.put(new ItemStack(Material.WATER_BUCKET, 1), 25.0);

        chestInventory.put(new ItemStack(Material.OAK_LOG, 14), 30.0);
        chestInventory.put(new ItemStack(Material.STONE, 16), 30.0);


    }


    public void populateChest(Inventory inv) {
        resetSeed();
        //Generation of amount in chests
        int max = 7;
        int min = 4;
        Random random = new Random(getSeed());
        int maxItems = random.nextInt(max - min + 1) + min;
        List<ItemStack> lootList = new ArrayList<ItemStack>(chestInventory.keySet());

        //Picking an item and placing it in a random place in the chest. If a spot is taken, we move it to the next spot.
        for(int i = 0; i <= maxItems; i++) {
            int timesRolled = 0;
            int randomItem = new Random().nextInt(chestInventory.size());
            //We need to roll for the item to appear, first.
            double RNG = new Random().nextDouble();
            System.out.println("ROLLED " + RNG + " for item " + lootList.get(i).getType().name());

            //If we rolled in the right range for the item, we place it in the chest. We have a cap on how many times this is allowed to fail before we override.
            boolean success = RNG >= chestInventory.get(randomItem);
            if(timesRolled >=5) {
                //Manual override
                success = true;
            }

            if(success = true) {
                //Single chests have only 27 slots.
                int placement = new Random().nextInt(26);
                //catch clauses
                if(inv.getItem(i) != null)
                    placement++;
                if(placement == 27)
                    placement = 0;

                inv.setItem(placement, lootList.get(i));

            } else
                timesRolled++;

        }

    }
}
