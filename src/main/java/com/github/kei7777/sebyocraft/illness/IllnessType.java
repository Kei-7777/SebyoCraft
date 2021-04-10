package com.github.kei7777.sebyocraft.illness;

import org.bukkit.ChatColor;

public enum IllnessType {
    chlamydia("chlamydia", "クラミジア", "ク", ChatColor.AQUA),
    gonorrhea("gonorrhea", "淋病","淋", ChatColor.GREEN),
    syphilis("syphilis", "梅毒","梅", ChatColor.LIGHT_PURPLE),
    herpes("herpes", "ヘルペス","ヘ", ChatColor.YELLOW);

    public String name;
    public String id;
    public String icon;
    public ChatColor color;
    IllnessType(String id, String name, String ico, ChatColor color) {
        this.id = id;
        this.name = name;
        this.icon = ico;
        this.color = color;
    }
}
