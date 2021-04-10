package com.github.kei7777.sebyocraft.illness;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.potion.*;

public class Chlamydia extends IllnessManager {
    @Override
    public void on(Player p) {
        if(p == null || !p.isOnline()) return;
        p.addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, 20*5, 30, true, true, false));
        p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 20*5, 4, true, false, false));
    }
}
