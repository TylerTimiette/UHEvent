package com.timiette.listeners;

import com.timiette.utils.Competitor;
import com.timiette.utils.Nametag;
import com.timiette.utils.PlayerManager;
import com.timiette.utils.TeamAction;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener {

    public void onPlayerJoin(PlayerJoinEvent event) {

        if(!PlayerManager.getCompetitor.containsKey(event.getPlayer().getUniqueId())) {
            Competitor competitor = new Competitor(event.getPlayer());
            PlayerManager.getCompetitor.put(event.getPlayer(), competitor);
        }

        Nametag.changePlayerName(event.getPlayer(), "", " &c&l\nScore:" + PlayerManager.getCompetitor.get(event.getPlayer()).getScore(), TeamAction.CREATE);
    }
}
