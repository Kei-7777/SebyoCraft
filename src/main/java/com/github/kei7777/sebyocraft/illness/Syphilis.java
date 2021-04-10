package com.github.kei7777.sebyocraft.illness;

import org.bukkit.*;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.potion.*;

public class Syphilis extends IllnessManager {
    @Override
    public void on(Player p) {
        if (p == null || !p.isOnline()) return;
        p.addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, 20 * 5, 30, true, true, false));
        p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 20 * 5, 0, true, true, false));
        //p.getWorld().spawnEntity(p.getLocation(), EntityType.SLIME);
        for (int i = 0; i < 10; i++) {
            p.spawnParticle(Particle.SLIME, p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ(), 10, 0.1, 0.1, 0.1);
            for (Player pl : Bukkit.getOnlinePlayers()) {
                pl.playSound(p.getLocation(), Sound.BLOCK_SLIME_BLOCK_BREAK, 0.75f, 0f);
            }
        }
    }
}
