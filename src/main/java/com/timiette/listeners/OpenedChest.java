package com.timiette.listeners;

import com.timiette.utils.ChestManager;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import static org.bukkit.Material.CHEST;
import static org.bukkit.Material.ENDER_CHEST;

public class OpenedChest implements Listener {
    @EventHandler
    public void playerInteractEvent(PlayerInteractEvent e) {
        switch(e.getClickedBlock().getType()) {
            case CHEST:
                //do something
            case ENDER_CHEST:
                //do something
            default: break;

            }
        }

        public void openedGennedInv(Player player, Block b) {
        if(!ChestManager.get().containsKey(b.getLocation())) {

            if(b.getType().equals(ENDER_CHEST)) {

            }
        }

    }
}

