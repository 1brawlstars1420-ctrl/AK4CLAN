package com.ak4clan;

import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
    
    private static Main instance;

    @Override
    public void onEnable() {
        instance = this;
        getLogger().info("AK4CLAN ha sido activado correctamente con interfaz interactiva.");
        
        // Registrar comandos y eventos
        getCommand("clan").setExecutor(new ClanCommand());
        getServer().getPluginManager().registerEvents(new ClanListener(), this);
    }

    @Override
    public void onDisable() {
        getLogger().info("AK4CLAN desactivado.");
    }

    public static Main getInstance() {
        return instance;
    }
}
