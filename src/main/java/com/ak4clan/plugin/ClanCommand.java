package com.ak4clan.plugin;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ClanCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("¡Este comando solo puede ser ejecutado por jugadores!");
            return true;
        }

        Player player = (Player) sender;

        if (args.length == 0) {
            player.sendMessage(ChatColor.YELLOW + "=== AK4CLAN ===");
            player.sendMessage(ChatColor.GREEN + "/clan create <nombre>" + ChatColor.WHITE + " - Crea tu clan.");
            player.sendMessage(ChatColor.GREEN + "/clan info" + ChatColor.WHITE + " - Muestra información de tu clan.");
            return true;
        }

        String subCommand = args[0].toLowerCase();

        if (subCommand.equals("create")) {
            if (args.length < 2) {
                player.sendMessage(ChatColor.RED + "Uso correcto: /clan create <nombre>");
                return true;
            }
            String clanName = args[1];
            player.sendMessage(ChatColor.GREEN + "¡Has creado con éxito el clan: " + ChatColor.GOLD + clanName + "!");
        } else {
            player.sendMessage(ChatColor.RED + "Subcomando desconocido. Usa /clan para ver la ayuda.");
        }

        return true;
    }
}
