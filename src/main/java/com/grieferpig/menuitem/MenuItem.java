package com.grieferpig.menuitem;

import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.Objects;

public final class MenuItem extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        System.out.println("Starting up MenuItem. Author: GrieferPig");
        getServer().getPluginManager().registerEvents(this, this);
        this.getCommand("doPinkiePromise").setExecutor(new doPinkiePromise());
    }

    @Override
    public void onDisable() {
        System.out.println("Shutting down MenuItem.");
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if (p.getInventory().getItemInMainHand().getType() == Material.COMPASS) {
            if(e.getAction() == Action.RIGHT_CLICK_BLOCK){
                openMenu(p);
            }else if (e.getAction() == Action.RIGHT_CLICK_AIR) {
                openMenu(p);
            }
        }
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        if(!e.getPlayer().getInventory().contains(getKit())){
            if(e.getPlayer().getInventory().getItem(8) != null){
                e.getPlayer().getInventory().addItem(getKit());
            }else{
                e.getPlayer().getInventory().setItem(8, getKit());
            }
        }
    }

    @EventHandler
    public void onPlayerDropItem(PlayerDropItemEvent e){
        if(Objects.equals(e.getItemDrop().getItemStack().getItemMeta().getDisplayName(), "菜单")){
            e.getItemDrop().remove();
            e.getPlayer().getInventory().addItem(getKit());
        }
    }

    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent e){
        e.getPlayer().getInventory().setItem(8, getKit());
    }


    public void openMenu(Player p){
        p.chat("/menu");
    }

    public ItemStack getKit(){
        ItemStack kit = new ItemStack(Material.COMPASS);
        ItemMeta meta = kit.getItemMeta(); //创建ItemMeta
        meta.setDisplayName("菜单");
        ArrayList<String> lore = new ArrayList<>();
        lore.add("右键打开");
        meta.setLore(lore);
        kit.setItemMeta(meta);
        return kit;
    }

}
