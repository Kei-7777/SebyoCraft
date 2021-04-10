package com.github.kei7777.sebyocraft.listener;

import com.github.kei7777.sebyocraft.SebyoCraft;
import com.github.kei7777.sebyocraft.SebyoItemFactory;
import com.github.kei7777.sebyocraft.illness.IllnessManager;
import com.github.kei7777.sebyocraft.illness.IllnessType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;

public class HerpesListener implements Listener {
    public HerpesListener(SebyoCraft sebyoCraft) {
        this.plugin = sebyoCraft;
    }

    SebyoCraft plugin;

    @EventHandler
    public void on(PlayerItemConsumeEvent e) {
        if (e.getItem().isSimilar(SebyoItemFactory.med_h)) {
            e.getPlayer().sendMessage("ヘルペスを治療しました。");
            IllnessManager.cure(e.getPlayer(), IllnessType.herpes);
        }
    }
}