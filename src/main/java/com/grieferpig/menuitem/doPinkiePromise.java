package com.grieferpig.menuitem;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
public class doPinkiePromise implements CommandExecutor{


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
            sender.sendMessage(ChatColor.LIGHT_PURPLE+"Cross my heart and hope to fly, stick a cupcake in my eye!");
            return true;
    }
}
