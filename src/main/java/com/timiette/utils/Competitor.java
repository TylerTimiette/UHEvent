package com.timiette.utils;

import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;

public class Competitor {

    Player p;
    Player cause;
    int score = 0;
    public Competitor(Player p) {
        this.p = p;
    }





    public void setLastDamageCause(Player e) {
        cause = e;
    }

    public Player getLastDamageCause() {
        return p;
    }

    //ONLY CALL ZERO WHEN RESETTING SCORES
    public void setScore(int i) {
        if(i != 0)
            score += i;
        else
            score = 0;
    }

    public int getScore() {
        return score;
    }


}
