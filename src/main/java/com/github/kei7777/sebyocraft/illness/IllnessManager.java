package com.github.kei7777.sebyocraft.illness;

import com.github.kei7777.sebyocraft.SebyoCraft;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.*;

public abstract class IllnessManager {

    private static Map<String, IllnessManager> methods = new HashMap<>();
    static Map<UUID, List<IllnessType>> sickplayers = new HashMap<>();

    public abstract void on(Player p);

    public static void reg(String id, IllnessManager clazz) {
        methods.put(id, clazz);
    }

    public static void reload() {
        reg(IllnessType.chlamydia.id, new Chlamydia());
        reg(IllnessType.syphilis.id, new Syphilis());
        reg(IllnessType.gonorrhea.id, new Gonorrhea());
        reg(IllnessType.herpes.id, new Herpes());
    }

    public static void cure(Player p, IllnessType t) {
        if (!sickplayers.containsKey(p.getUniqueId())) sickplayers.put(p.getUniqueId(), new ArrayList<>());
        sickplayers.get(p.getUniqueId()).remove(t);
    }

    public static void check(Player p) {
        String element = "settings.probability.";
        for (IllnessType type : IllnessType.values()) {
            int i = SebyoCraft.koko.getConfig().getInt(element + type.id);
            if (new Random().nextInt(i) == 0) {
                sick(p, type);
            }
        }
    }

    public static void tag() {
        for (Player p : Bukkit.getOnlinePlayers()) {
            if (!sickplayers.containsKey(p.getUniqueId())) sickplayers.put(p.getUniqueId(), new ArrayList<>());
            StringBuffer str = new StringBuffer();
            for (IllnessType t : IllnessType.values()) {
                if (sickplayers.get(p.getUniqueId()).contains(t)) {
                    str.append(t.color + t.icon);
                } else {
                    str.append(ChatColor.DARK_GRAY + t.icon);
                }
            }
            p.setPlayerListName(str.toString() + ChatColor.WHITE + p.getName());
        }
    }

    public static void mix(Player p, Player p2) {
        if (sickplayers.containsKey(p.getUniqueId())) {
            for (IllnessType t : sickplayers.get(p.getUniqueId())) {
                sick(p2, t);
            }
        }

        if (sickplayers.containsKey(p2.getUniqueId())) {
            for (IllnessType t : sickplayers.get(p2.getUniqueId())) {
                sick(p, t);
            }
        }
    }

    public static void sick(Player p, IllnessType t) {
        if (!sickplayers.containsKey(p.getUniqueId())) sickplayers.put(p.getUniqueId(), new ArrayList<>());
        if (sickplayers.get(p.getUniqueId()).contains(t)) return;
        sickplayers.get(p.getUniqueId()).add(t);
        broadcast(p, t);
    }

    static void broadcast(Player p, IllnessType t) {
        Bukkit.broadcastMessage(p.getName() + "が" + t.name + "に感染しました");
    }

    public static void run() {
        String element = "settings.run.";
        for (Map.Entry<UUID, List<IllnessType>> entry : sickplayers.entrySet()) {
            for (IllnessType type : IllnessType.values()) {
                if (entry.getValue().contains(type)) {
                    int i = SebyoCraft.koko.getConfig().getInt(element + type.id);
                    if (new Random().nextInt(i) == 0) {
                        methods.get(type.id).on(Bukkit.getPlayer(entry.getKey()));
                    }
                }
            }
        }
    }

}
