package com.ak4clan;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class ClanCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Este comando solo puede ser usado por jugadores.");
            return true;
        }

        Player player = (Player) sender;
        openClanMenu(player);
        return true;
    }

    public static void openClanMenu(Player player) {
        // Creamos un menú cofre de 27 espacios con colores llamativos en el título
        Inventory menu = Bukkit.createInventory(null, 27, ChatColor.translateAlternateColorCodes('&', "&6&lAK4 &8» &eMenú de Clan"));

        // Opción 1: Información del Clan (Cabeza decorativa o papel)
        ItemStack info = new ItemStack(Material.PAPER);
        ItemMeta infoMeta = info.getItemMeta();
        infoMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&a&lINFORMACIÓN DEL CLAN"));
        infoMeta.setLore(Arrays.asList(
            ChatColor.translateAlternateColorCodes('&', "&7Revisa el estado de tu clan"),
            ChatColor.translateAlternateColorCodes('&', "&eMonedas: &61,000 🪙")
        ));
        info.setItemMeta(infoMeta);
        menu.setItem(11, info);

        // Opción 2: Opciones de Líder / Sublíder (Gestionar miembros, echar, rangos)
        ItemStack gestion = new ItemStack(Material.PLAYER_HEAD);
        ItemMeta gestionMeta = gestion.getItemMeta();
        gestionMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&c&lGESTIÓN DE MIEMBROS"));
        gestionMeta.setLore(Arrays.asList(
            ChatColor.translateAlternateColorCodes('&', "&7Opciones exclusivas de:"),
            ChatColor.translateAlternateColorCodes('&', "&4&lLÍDER &7y &c&lSUBLÍDER"),
            ChatColor.translateAlternateColorCodes('&', "&8▶ &cClic para expulsar o ascender")
        ));
        gestion.setItemMeta(gestionMeta);
        menu.setItem(13, gestion);

        // Opción 3: Banco / Monedas del Clan
        ItemStack banco = new ItemStack(Material.GOLD_INGOT);
        ItemMeta bancoMeta = banco.getItemMeta();
        bancoMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&e&lBANCO DE MONEDAS"));
        bancoMeta.setLore(Arrays.asList(
            ChatColor.translateAlternateColorCodes('&', "&7Deposita y retira monedas"),
            ChatColor.translateAlternateColorCodes('&', "&7para mejorar tu clan.")
        ));
        banco.setItemMeta(bancoMeta);
        menu.setItem(15, banco);

        player.openInventory(menu);
    }
    }
