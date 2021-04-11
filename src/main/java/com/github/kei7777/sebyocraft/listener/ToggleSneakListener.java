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
    SebyoCraft sc;

    public ToggleSneakListener(SebyoCraft sebyoCraft) {
        sc = sebyoCraft;
    }

    @EventHandler
    public void on(PlayerToggleSneakEvent e) {
        if (!e.isSneaking()) return;
        Player p = e.getPlayer();
        for (Entity entity : p.getNearbyEntities(1, 1, 1)) {
            if (entity instanceof Player && !entity.getUniqueId().equals(p.getUniqueId())) {
                Player target = ((Player) entity);
                boolean rub = (target.getInventory().getItemInMainHand().isSimilar(SebyoItemFactory.rub) || p.getInventory().getItemInMainHand().isSimilar(SebyoItemFactory.rub)); // コンドームの有無
               
                p.getLocation().getWorld().spawnParticle(Particle.HEART, p.getLocation().clone().add(0, 2.5, 0), 3);
                p.getLocation().getWorld().spawnParticle(Particle.HEART, target.getLocation().clone().add(0, 2.5, 0), 3);
                Location loc = target.getLocation();
                if (rub) {
                    if (target.getInventory().getItemInMainHand().isSimilar(SebyoItemFactory.rub)) {
                        if (target.getInventory().getItemInMainHand().getAmount() != 0) {
                            target.getInventory().getItemInMainHand().setAmount(target.getInventory().getItemInMainHand().getAmount() - 1);
                        } else {
                            target.getInventory().getItemInMainHand().setType(Material.AIR);
                        }
                    } else {
                        if (p.getInventory().getItemInMainHand().getAmount() != 0) {
                            p.getInventory().getItemInMainHand().setAmount(p.getInventory().getItemInMainHand().getAmount() - 1);
                        } else {
                            p.getInventory().getItemInMainHand().setType(Material.AIR);
                        }
                    }
                } else {
                    IllnessManager.mix(target, p);
                    IllnessManager.check(target);
                    IllnessManager.check(p);
                }
            }
        }
    }
}
