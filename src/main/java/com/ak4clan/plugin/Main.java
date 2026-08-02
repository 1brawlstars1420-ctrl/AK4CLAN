package com.ak4clan.plugin;

import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("¡AK4CLAN ha sido activado correctamente en Purpur!");
    }

    @Override
    public void onDisable() {
        getLogger().info("AK4CLAN se ha desactivado.");
    }
}
