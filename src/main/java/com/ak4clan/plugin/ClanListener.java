package com.ak4clan;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class ClanListener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        // Verificamos si el título del menú coincide con el de nuestro clan
        if (event.getView().getTitle().contains("Menú de Clan")) {
            event.setCancelled(true); // Evita que se lleven los ítems

            if (event.getCurrentItem() == null) return;
            Player player = (Player) event.getWhoClicked();

            // Dependiendo de dónde haga clic el jugador
            if (event.getSlot() == 11) {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&a[Clan] &fEstás consultando la información de tu clan."));
            } else if (event.getSlot() == 13) {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c[Clan] &fAbriendo panel de expulsión y rangos (Líder/Sublíder)."));
            } else if (event.getSlot() == 15) {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e[Clan] &fAccediendo al banco de monedas..."));
            }
        }
    }
}
