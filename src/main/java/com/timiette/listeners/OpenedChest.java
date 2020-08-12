package com.timiette.listeners;

import com.timiette.loottables.SkyWarsLoot;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;

import static org.bukkit.Material.*;

public class OpenedChest implements Listener {
    @EventHandler
    public void playerInteractEvent(PlayerInteractEvent e) {
        if (e.getClickedBlock().getType().equals(Material.CHEST)) {

            Chest chest = (Chest) e.getClickedBlock().getState();
            //if(config.contains(e.getClickedBlock().getLocation(); we do shit

            openGennedInv(e.getPlayer(), chest, 0);
        }
    }

        public void openGennedInv(Player player, Chest chest, int level) {
            SkyWarsLoot sl = new SkyWarsLoot();

            sl.populateChest(chest.getInventory());
            chest.update();

    }
}

