package com.github.kei7777.sebyocraft.illness;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Herpes extends IllnessManager {
    @Override
    public void on(Player p) {
        //p.getLocation().getWorld().createExplosion(p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ(), 3, false, false, p);
        p.addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, 20*5, 30, true, true, false));
        p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 20*5, 4, true, false, false));
    }
}
