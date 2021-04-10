package com.github.kei7777.sebyocraft.listener;

import com.github.kei7777.sebyocraft.SebyoCraft;
import com.github.kei7777.sebyocraft.SebyoItemFactory;
import com.github.kei7777.sebyocraft.illness.IllnessManager;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import java.util.*;

public class ToggleSneakListener implements Listener {
    public static Map<String, Integer> data;
    SebyoCraft sc;
    public ToggleSneakListener(SebyoCraft sebyoCraft) {
        data = new HashMap<>();
        sc = sebyoCraft;
        for (String s : sebyoCraft.getConfig().getStringList("users")) {
            data.put(s, 0);
        }
    }

    @EventHandler
    public void on(PlayerToggleSneakEvent e){
        if(!e.isSneaking()) return;
        if (!data.containsKey(e.getPlayer().getName())) {
            Player p = e.getPlayer();
            for (Entity entity : p.getNearbyEntities(1, 1, 1)) {
                if (entity instanceof Player) {
                    Player target = ((Player) entity);
                    if (data.containsKey(target.getName())) {
                        boolean rub = (target.getInventory().getItemInMainHand().isSimilar(SebyoItemFactory.rub) || p.getInventory().getItemInMainHand().isSimilar(SebyoItemFactory.rub)); // コンドームの有無
                        int o = data.get(target.getName()) + 1;

                        for (Player pl : Bukkit.getOnlinePlayers()) {
                            pl.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 1f, 1f);
                        }

                        p.getLocation().getWorld().spawnParticle(Particle.HEART, p.getLocation().clone().add(0, 2.5, 0), 3);
                        p.getLocation().getWorld().spawnParticle(Particle.HEART, target.getLocation().clone().add(0, 2.5, 0), 3);

                        if (o >= sc.getConfig().getInt(target.getName())) {
                            data.replace(target.getName(), 0);

                            Location loc = target.getLocation();
                            Collections.shuffle(sc.mobs);
                            String str = rub ? "てしまった！" : "た！";
                            if(rub){
                                if(target.getInventory().getItemInMainHand().isSimilar(SebyoItemFactory.rub)) {
                                    if(target.getInventory().getItemInMainHand().getAmount() != 0) {
                                        target.getInventory().getItemInMainHand().setAmount(target.getInventory().getItemInMainHand().getAmount() - 1);
                                    } else {
                                        target.getInventory().getItemInMainHand().setType(Material.AIR);
                                    }
                                } else {
                                    if(p.getInventory().getItemInMainHand().getAmount() != 0) {
                                        p.getInventory().getItemInMainHand().setAmount(p.getInventory().getItemInMainHand().getAmount() - 1);
                                    } else {
                                        p.getInventory().getItemInMainHand().setType(Material.AIR);
                                    }
                                }
                            }
                            loc.getWorld().spawnEntity(loc, sc.mobs.get(0)).setCustomName(ChatColor.LIGHT_PURPLE + target.getName() + ChatColor.WHITE + " x " + ChatColor.AQUA + p.getName() + ChatColor.WHITE + " の子供");
                            Bukkit.broadcastMessage(ChatColor.LIGHT_PURPLE + target.getName() + ChatColor.WHITE + "と" + ChatColor.AQUA + p.getName() + ChatColor.WHITE + "の間に" + ChatColor.GOLD + sc.mobs.get(0).name() + ChatColor.WHITE + "が産まれ" +
                                    str);
                            for (Player pl : Bukkit.getOnlinePlayers()) {
                                pl.playSound(p.getLocation(), Sound.UI_TOAST_CHALLENGE_COMPLETE, 1f, 1f);
                            }

                            if(!rub){
                                IllnessManager.mix(target, p);
                                IllnessManager.check(target);
                                IllnessManager.check(p);
                            }

                        } else {
                            data.replace(target.getName(), o);
                        }
                    }
                }
            }
        }
    }
}
