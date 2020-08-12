package com.timiette.modes;

import com.timiette.Main;
import com.timiette.loottables.Loot;
import com.timiette.loottables.Seedable;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.WorldType;
import org.bukkit.scheduler.BukkitRunnable;

public class Mode extends Loot {

    boolean PVP;

    public Boolean isPVPEnabled() {
        return PVP;
    }




    public void setPVP(boolean b) {

    }



    public void generateWorld(String mode) {
        //When a new round is started, we don't want the old worlds to hang around. We need a command to unload worlds.




        WorldCreator wc = new WorldCreator(mode);
        wc.environment(World.Environment.NORMAL);
        //We get the current seed
        Seedable seed = new Seedable();
        seed.resetSeed();
        wc.seed(seed.getSeed());
        wc.type(WorldType.LARGE_BIOMES);

        WorldCreator end = new WorldCreator(mode + "_the_end");
        end.environment(World.Environment.THE_END);
        end.seed(seed.getSeed());
        end.type(WorldType.NORMAL);

        WorldCreator nether = new WorldCreator(mode + "_nether");
        nether.environment(World.Environment.NETHER);
        nether.type(WorldType.NORMAL);
        nether.seed(seed.getSeed());


        wc.createWorld();
//I don't want world generation to take up the main thread, so I'll run the nether/end async for now and see how it performs.
        new BukkitRunnable() {
            @Override
            public void run() {
                nether.createWorld();
                end.createWorld();
            }

        }.runTaskAsynchronously(Main.getInstance());
    }

 }

