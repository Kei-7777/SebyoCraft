package com.github.kei7777.sebyocraft.illness;

import org.bukkit.scheduler.BukkitRunnable;

public class IllnessRunTask extends BukkitRunnable {
    @Override
    public void run() {
        IllnessManager.run();
        IllnessManager.tag();
    }
}
