package com.timiette;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    private static Main instance;
    public Main () {
        instance = this;
    }

    public void onEnable() {
        //do stuff
    }

    public void onDisable() {
        System.out.println("Goodbye!");
    }






    public static Main getInstance() {
        return instance;
    }
}
