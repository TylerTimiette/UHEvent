package com.timiette.loottables;

import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Loot extends Seedable {

    public HashMap<ItemStack, Double> chestInventory = new HashMap<>();

    public void populateChest(Inventory inv) {
        resetSeed();
        //Generation of amount in chests
        int max = 7;
        int min = 4;
        Random random = new Random(getSeed());
        int maxItems = random.nextInt(max - min + 1) + min;
        List<ItemStack> lootList = new ArrayList<ItemStack>(chestInventory.keySet());
        //Thanks Lily!
        List<Integer> list = IntStream.range(0, 26)
                .boxed()
                .collect(Collectors.toList());
        //Picking an item and placing it in a random place in the chest. If a spot is taken, we move it to the next spot.
        for(int i = 0; i <= maxItems; i++) {
            int timesRolled = 0;
            int randomItem = new Random().nextInt(chestInventory.size());
            //We need to roll for the item to appear, first.
            double RNG = new Random().nextDouble();
            System.out.println("ROLLED " + RNG + " for item " + lootList.get(i).getType().name());

            //If we rolled in the right range for the item, we place it in the chest. We have a cap on how many times this is allowed to fail before we override.
            boolean success = RNG >= chestInventory.get(randomItem);
            if(timesRolled >= 5) {
                //Manual override
                success = true;
            }

            if(success = true) {
                //Single chests have only 27 slots.

                int placement = list.get(i);
                //catch clauses
                if(inv.getItem(i) != null)
                    placement++;

                inv.setItem(placement, lootList.get(i));

            } else
                timesRolled++;

        }

    }
}
