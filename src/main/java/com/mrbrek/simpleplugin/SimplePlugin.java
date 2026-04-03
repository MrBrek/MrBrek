package com.mrbrek.simpleplugin;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class SimplePlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("SimplePlugin включен.");
    }

    @Override
    public void onDisable() {
        getLogger().info("SimplePlugin выключен.");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("hello")) {
            sender.sendMessage(ChatColor.GREEN + "Привет! Это твой первый плагин 👋");
            return true;
        }

        if (command.getName().equalsIgnoreCase("heal")) {
            if (!(sender instanceof Player player)) {
                sender.sendMessage(ChatColor.RED + "Эту команду может использовать только игрок.");
                return true;
            }

            player.setHealth(player.getMaxHealth());
            player.setFoodLevel(20);
            player.setFireTicks(0);
            player.sendMessage(ChatColor.AQUA + "Ты полностью восстановлен!");
            return true;
        }

        return false;
    }
}
