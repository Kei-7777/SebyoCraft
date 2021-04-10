package com.github.kei7777.sebyocraft.illness;

import org.bukkit.Bukkit;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Gonorrhea extends IllnessManager {
    @Override
    public void on(Player p) {
        if (p == null || !p.isOnline()) return;
        p.addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, 20 * 5, 30, true, false, false));
        p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 20 * 5, 0, true, false, false));
    }
}
